package com.epicness.jalcon.game.logic.other;

import static com.badlogic.gdx.Input.Keys.NUM_1;
import static com.badlogic.gdx.Input.Keys.NUM_2;
import static com.badlogic.gdx.Input.Keys.NUM_3;
import static com.badlogic.gdx.Input.Keys.NUM_4;
import static com.badlogic.gdx.Input.Keys.Q;
import static com.badlogic.gdx.Input.Keys.W;

import com.epicness.fundamentals.stuff.Shader;
import com.epicness.jalcon.game.logic.GameLogicHandler;

public class ShaderTester extends GameLogicHandler {

    private Shader horizontalBlur, verticalBlur;

    @Override
    protected void init() {
        horizontalBlur = stuff.getHorizontalBlur();
        verticalBlur = stuff.getVerticalBlur();
    }

    @Override
    public void keyDown(int keycode) {
        switch (keycode) {
            case NUM_1:
                renderer.setBlurRadius(5f);
                break;
            case NUM_2:
                renderer.setBlurRadius(10f);
                break;
            case NUM_3:
                renderer.setBlurRadius(15f);
                break;
            case NUM_4:
                renderer.setBlurRadius(20f);
                break;
            case Q:
                horizontalBlur.setShaderProgram(assets.getHorizontalBlur4());
                verticalBlur.setShaderProgram(assets.getVerticalBlur4());
                break;
            case W:
                horizontalBlur.setShaderProgram(assets.getHorizontalBlur8());
                verticalBlur.setShaderProgram(assets.getVerticalBlur8());
                break;
        }
    }
}