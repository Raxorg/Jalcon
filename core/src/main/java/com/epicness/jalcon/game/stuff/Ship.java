package com.epicness.jalcon.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.rendering.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.SpritePlus;
import com.epicness.fundamentals.stuff.interfaces.HasCenter;
import com.epicness.fundamentals.stuff.interfaces.HasMovable;
import com.epicness.fundamentals.stuff.interfaces.Movable;
import com.epicness.fundamentals.stuff.interfaces.SpriteBatchDrawable;

public class Ship implements SpriteBatchDrawable, HasMovable, HasCenter {

    private final SpritePlus sprite;
    public final Vector2 target;

    public Ship(Sprite shipSprite, float x, float y, float targetX, float targetY) {
        sprite = new SpritePlus(shipSprite);
        sprite.setPosition(x, y);
        sprite.setSize(10f, 12.5f);
        sprite.setOriginCenter();

        target = new Vector2(targetX, targetY);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    @Override
    public void drawDebug(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
    }

    @Override
    public Movable getMovable() {
        return sprite;
    }

    @Override
    public float getCenterX() {
        return sprite.getCenterX();
    }

    @Override
    public float getCenterY() {
        return sprite.getCenterY();
    }

    public void setAngle(float angle) {
        sprite.setRotation(angle);
    }

    public void setColor(Color color) {
        sprite.setColor(color);
    }
}