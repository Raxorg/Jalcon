package com.epicness.jalcon.game.stuff;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.graphics.Color;
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
    public final float productionInterval;
    private float productionTime;
    private boolean producing;

    public Planet(CirclePlus circlePlus, BitmapFont font, float productionInterval) {
        circle = circlePlus;
        circle.setFillColor(CLEAR);
        shipCount = new Text(font);
        shipCount.setPosition(circle.getCenterX(), circle.getCenterY());
        shipCount.hAlignCenter();
        shipCount.setVerticallyCentered(true);
        shipCount.setWrapWidth(0f);
        this.productionInterval = productionInterval;
        setShips(5);
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
        circle.draw(shapeDrawer);
        shipCount.draw(spriteBatch);
    }

    @Override
    public void drawDebug(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {

    }

    public boolean contains(float x, float y) {
        return circle.contains(x, y);
    }

    public boolean overlaps(CirclePlus circle) {
        return CollisionUtils.overlaps(this.circle, circle);
    }

    public void setFontScale(float scale) {
        shipCount.setScale(scale);
    }

    public void setFontColor(Color color) {
        shipCount.setColor(color);
    }

    public void setBorderColor(Color color) {
        circle.setBorderColor(color);
    }

    public void setFillColor(Color color) {
        circle.setFillColor(color);
    }

    public int getShips() {
        return ships;
    }

    public void setShips(int ships) {
        this.ships = ships;
        shipCount.setText(String.valueOf(ships));
    }

    public float getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(float productionTime) {
        this.productionTime = productionTime;
    }

    public boolean isProducing() {
        return producing;
    }

    public void setProducing(boolean producing) {
        this.producing = producing;
    }
}