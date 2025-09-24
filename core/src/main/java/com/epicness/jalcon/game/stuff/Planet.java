package com.epicness.jalcon.game.stuff;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.rendering.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.fundamentals.stuff.shapes.bidimensional.CirclePlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Drawable2D;
import com.epicness.fundamentals.utils.CollisionUtils;

public class Planet implements Drawable2D {

    private final CirclePlus circle;
    private final Text shipCount;
    private int ships;

    public Planet(CirclePlus circle, BitmapFont font) {
        this.circle = circle;
        shipCount = new Text(font);
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
        circle.draw(shapeDrawer);
        shipCount.draw(spriteBatch);
    }

    @Override
    public void drawDebug(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {

    }

    public boolean overlaps(CirclePlus circle) {
        return CollisionUtils.overlaps(this.circle, circle);
    }

    public int getShips() {
        return ships;
    }

    public void setShips(int ships) {
        this.ships = ships;
    }
}