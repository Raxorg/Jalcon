package com.epicness.jalcon.game.logic.other;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.epicness.jalcon.game.logic.GameLogicHandler;

public class CameraHandler extends GameLogicHandler {

    private OrthographicCamera camera;

    @Override
    protected void init() {
        camera = screen.getDynamicCamera();
    }
}