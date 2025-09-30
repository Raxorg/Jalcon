package com.epicness.jalcon.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.rendering.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.SpritePlus;
import com.epicness.fundamentals.stuff.interfaces.SpriteBatchDrawable;

public class Ship implements SpriteBatchDrawable {

    private final SpritePlus sprite;

    public Ship(Sprite shipSprite, float x, float y) {
        sprite = new SpritePlus(shipSprite);
        sprite.setPosition(x, y);
        sprite.setSize(10f, 12.5f);
        sprite.setOriginCenter();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    @Override
    public void drawDebug(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
    }

    public void setAngle(float angle) {
        sprite.setRotation(angle);
    }

    public void setColor(Color color) {
        sprite.setColor(color);
    }
}