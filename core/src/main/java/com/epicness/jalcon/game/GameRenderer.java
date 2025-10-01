package com.epicness.jalcon.game;

import static com.badlogic.gdx.graphics.Color.BLACK;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.rendering.Renderer;
import com.epicness.fundamentals.stuff.Shader;
import com.epicness.jalcon.game.stuff.GameStuff;

public class GameRenderer extends Renderer<GameStuff> {

    private FrameBuffer sceneFBO, downsampleFBO1, downsampleFBO2, horizontalBlurFBO;
    private Shader horizontalBlurShader, verticalBlurShader;
    private float blurRadius;
    private float boost;

    public void init() {
        horizontalBlurShader = stuff.getHorizontalBlur();
        verticalBlurShader = stuff.getVerticalBlur();
        blurRadius = 1f;
        boost = 1.25f;
    }

    @Override
    public void render() {
        // 1. Render the main scene to a full-resolution FBO
        sceneFBO.begin();
        renderMainScene();
        sceneFBO.end();

        // Render the un-blurred scene to the screen as the base layer
        spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.setShader(null);
        spriteBatch.begin();
        drawFBO(sceneFBO, true);
        spriteBatch.end();

        renderBlur();

        // 5. Render foreground elements (UI, etc.) on top of everything
        renderStuffOnTop();
    }

    private void renderMainScene() {
        ScreenUtils.clear(BLACK);

        useStaticCamera();
        spriteBatch.begin();
        stuff.getBackground().draw(spriteBatch);
        spriteBatch.flush();

        useDynamicCamera();
        // NOTE: Don't draw the things you want to have a bloom/blur effect here.
        // We will draw them in the "renderStuffOnTop" method.
        // For example, if you only want ships to bloom, only draw planets and background here.
        drawArray(stuff.getPlanets());
        stuff.getDragLine().draw(shapeDrawer);
        drawArray(stuff.getShips());
        spriteBatch.end();
    }

    private void renderBlur() {
        spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // 2. Downsample
        // Downsample from full-res to 1/2 res
        downsampleFBO1.begin();
        spriteBatch.begin();
        drawFBO(sceneFBO, false); // Source texture is already flipped from scene render
        spriteBatch.end();
        downsampleFBO1.end();

        // Downsample from 1/2 res to 1/4 res
        downsampleFBO2.begin();
        spriteBatch.begin();
        drawFBO(downsampleFBO1, false);
        spriteBatch.end();
        downsampleFBO2.end();

        // 3. Apply horizontal blur on the smallest FBO
        horizontalBlurFBO.begin();
        spriteBatch.setShader(horizontalBlurShader.getShaderProgram());
        horizontalBlurShader.bind();
        horizontalBlurShader.setUniformF("u_resolution_x", downsampleFBO2.getWidth());
        horizontalBlurShader.setUniformF("u_radius", blurRadius);
        horizontalBlurShader.setUniformF("u_boost", boost);
        spriteBatch.begin();
        drawFBO(downsampleFBO2, false);
        spriteBatch.end();
        horizontalBlurFBO.end();

        // 4. Apply vertical blur and upscale, blending additively onto the screen
        spriteBatch.enableBlending();
        spriteBatch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE); // Additive blending for a "bloom" effect

        spriteBatch.setShader(verticalBlurShader.getShaderProgram());
        verticalBlurShader.bind();
        verticalBlurShader.setUniformF("u_resolution_y", horizontalBlurFBO.getHeight());
        verticalBlurShader.setUniformF("u_radius", blurRadius);
        verticalBlurShader.setUniformF("u_boost", boost);
        spriteBatch.begin();
        // This final draw goes to the screen, not an FBO
        drawFBO(horizontalBlurFBO, false);
        spriteBatch.end();

        // Reset blending and shader
        spriteBatch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        spriteBatch.setShader(null);
    }

    // Helper method to draw a FBO's texture to the current target
    private void drawFBO(FrameBuffer fbo, boolean flipY) {
        Texture texture = fbo.getColorBufferTexture();
        spriteBatch.draw(
            texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
            0, 0, texture.getWidth(), texture.getHeight(),
            false, flipY
        );
    }

    private void renderStuffOnTop() {
        // This is where you draw the crisp, un-blurred things that appear on top of the scene
        // like ships, UI, etc.
        useDynamicCamera();
        spriteBatch.begin();
        drawArray(stuff.getPlanets());
        stuff.getDragLine().draw(shapeDrawer);
        drawArray(stuff.getShips());
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        if (sceneFBO != null) sceneFBO.dispose();
        if (downsampleFBO1 != null) downsampleFBO1.dispose();
        if (downsampleFBO2 != null) downsampleFBO2.dispose();
        if (horizontalBlurFBO != null) horizontalBlurFBO.dispose();

        sceneFBO = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
        downsampleFBO1 = new FrameBuffer(Pixmap.Format.RGBA8888, width / 2, height / 2, false);
        downsampleFBO2 = new FrameBuffer(Pixmap.Format.RGBA8888, width / 4, height / 4, false);
        horizontalBlurFBO = new FrameBuffer(Pixmap.Format.RGBA8888, width / 4, height / 4, false);
    }

    public void setBlurRadius(float blurRadius) {
        this.blurRadius = blurRadius;
    }
}