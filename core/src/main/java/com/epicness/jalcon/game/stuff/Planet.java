package com.epicness.jalcon.game.stuff;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.rendering.ShapeDrawerPlus;
import com.epicness.fundamentals.stuff.SpritePlus;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.fundamentals.stuff.shapes.bidimensional.CirclePlus;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Drawable2D;
import com.epicness.fundamentals.utils.CollisionUtils;

public class Planet implements Drawable2D {

    private final SpritePlus sprite;
    private final CirclePlus background, selector;
    private final Text shipCount;
    private int ships;
    public final float productionInterval;
    private float productionTime;
    private boolean producing;

    public Planet(Sprite planetSprite, CirclePlus circle, BitmapFont font, float productionInterval) {
        sprite = new SpritePlus(planetSprite);
        sprite.setSize(circle.getRadius() * 2f - 5f);
        sprite.setPosition(circle.getX() + 2.5f, circle.getY() + 2.5f);

        background = circle;

        selector = new CirclePlus(circle);
        selector.setRadius(circle.getRadius() + 7f);
        selector.translate(-7f, -7f);
        selector.setColor(CLEAR);

        shipCount = new Text(font);
        shipCount.setPosition(background.getCenterX(), background.getCenterY());
        shipCount.hAlignCenter();
        shipCount.setVerticallyCentered(true);
        shipCount.setWrapWidth(0f);

        this.productionInterval = productionInterval;
        setShips(5);
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {
        background.draw(shapeDrawer);
        sprite.draw(spriteBatch);
        shipCount.draw(spriteBatch);
        selector.draw(shapeDrawer);
    }

    @Override
    public void drawDebug(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer) {

    }

    public boolean contains(float x, float y) {
        return background.contains(x, y);
    }

    public boolean overlaps(CirclePlus circle) {
        return CollisionUtils.overlaps(this.background, circle);
    }

    public void setFontScale(float scale) {
        shipCount.setScale(scale);
    }

    public void setFontColor(Color color) {
        shipCount.setColor(color);
    }

    public void setSelectorColor(Color color) {
        selector.setBorderColor(color);
    }

    public void setPlanetColor(Color color) {
        sprite.setColor(color);
    }

    public void setBackgroundColor(Color color) {
        background.setColor(color);
    }

    public void setPlanetAndBGColor(Color color) {
        setPlanetColor(color);
        setBackgroundColor(color);
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

    public float getCenterX() {
        return background.getCenterX();
    }

    public float getCenterY() {
        return background.getCenterY();
    }

    public float getRadius() {
        return background.getRadius();
    }
}