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

public class OldRenderer extends Renderer<GameStuff> {

    private FrameBuffer fboA, fboB;
    private Shader horizontalBlurShader, verticalBlurShader;
    private float blurRadius;

    public void init() {
        horizontalBlurShader = stuff.getHorizontalBlur();
        verticalBlurShader = stuff.getVerticalBlur();
        blurRadius = 5f;
    }

    @Override
    public void render() {
        renderToA();
        renderAToB();
        renderBToScreen();
        renderStuffOnTop();
    }

    private void renderToA() {
        fboA.begin();
        spriteBatch.setShader(null);
        renderStuffToBlur();
        fboA.end();
        spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    // Original render method
    private void renderStuffToBlur() {
        ScreenUtils.clear(BLACK);

        useStaticCamera();
        spriteBatch.begin();
        stuff.getBackground().draw(spriteBatch);
        spriteBatch.flush();

        useDynamicCamera();
        drawArray(stuff.getPlanets());
        stuff.getDragLine().draw(shapeDrawer);
        drawArray(stuff.getShips());
        spriteBatch.end();
    }

    private void renderAToB() {
        fboB.begin();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.setShader(horizontalBlurShader.getShaderProgram());
        horizontalBlurShader.bind();
        horizontalBlurShader.setUniformF("u_resolution_x", Gdx.graphics.getWidth());
        horizontalBlurShader.setUniformF("u_radius", blurRadius);

        spriteBatch.begin();
        Texture fboATexture = fboA.getColorBufferTexture();
        spriteBatch.draw(fboATexture,       // The texture from the FBO
            0,                        // x position
            0,                        // y position
            Gdx.graphics.getWidth(),  // destination width
            Gdx.graphics.getHeight(), // destination height
            0,                        // source x
            0,                        // source y
            fboATexture.getWidth(),   // source width
            fboATexture.getHeight(),  // source height
            false,                    // flip horizontally
            true);                    // flip vertically (false for reflection effect)
        spriteBatch.end();
        fboB.end();
    }

    private void renderBToScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.setShader(verticalBlurShader.getShaderProgram());
        verticalBlurShader.bind();
        verticalBlurShader.setUniformF("u_resolution_y", Gdx.graphics.getHeight());
        verticalBlurShader.setUniformF("u_radius", blurRadius);

        spriteBatch.begin();
        Texture fboBTexture = fboB.getColorBufferTexture();

        spriteBatch.draw(fboBTexture,       // The texture from the FBO
            0,                        // x position
            0,                        // y position
            Gdx.graphics.getWidth(),  // destination width
            Gdx.graphics.getHeight(), // destination height
            0,                        // source x
            0,                        // source y
            fboBTexture.getWidth(),   // source width
            fboBTexture.getHeight(),  // source height
            false,                    // flip horizontally
            true);                    // flip vertically (false for reflection effect)
        spriteBatch.end();

        // Reset shader
        spriteBatch.setShader(null);
    }

    private void renderStuffOnTop() {
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

        if (fboA != null) fboA.dispose();
        if (fboB != null) fboB.dispose();

        fboA = new FrameBuffer(Pixmap.Format.RGBA8888, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
        fboB = new FrameBuffer(Pixmap.Format.RGBA8888, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
    }

    public void setBlurRadius(float blurRadius) {
        this.blurRadius = blurRadius;
    }
}