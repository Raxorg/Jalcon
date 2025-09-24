package com.epicness.jalcon.game.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraHandler extends GameLogicHandler {

    private OrthographicCamera camera;

    @Override
    protected void init() {
        camera = screen.getDynamicCamera();
    }
}