package com.epicness.jalcon.game.logic;

import static com.epicness.fundamentals.constants.ColorConstants.PASTEL_PURPLE;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.epicness.fundamentals.stuff.SpritePlus;

public class BackgroundHandler extends GameLogicHandler {

    private SpritePlus background;

    @Override
    protected void init() {
        background = stuff.getBackground();
        background.setColor(PASTEL_PURPLE);
    }

    @Override
    public void resize(int width, int height) {
        Camera cam = screen.getStaticCamera();
        Viewport viewport = renderer.getViewport();

        float bgX = cam.position.x - viewport.getWorldWidth() / 2f;
        float bgY = cam.position.y - viewport.getWorldHeight() / 2f;

        background.setPosition(bgX, bgY);
        background.setSize(viewport.getWorldWidth(), viewport.getWorldHeight());
    }
}