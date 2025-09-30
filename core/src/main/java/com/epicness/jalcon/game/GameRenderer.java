package com.epicness.jalcon.game;

import static com.badlogic.gdx.graphics.Color.BLACK;

import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.rendering.Renderer;
import com.epicness.jalcon.game.stuff.GameStuff;

public class GameRenderer extends Renderer<GameStuff> {

    @Override
    public void render() {
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
}