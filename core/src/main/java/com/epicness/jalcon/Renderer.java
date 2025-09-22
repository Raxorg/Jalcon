package com.epicness.jalcon;

import static com.badlogic.gdx.graphics.Color.BLACK;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.ScreenUtils;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Renderer {

    private Stuff stuff;

    private final SpriteBatch spriteBatch;
    private final ShapeDrawer shapeDrawer;

    public Renderer() {
        spriteBatch = new SpriteBatch();
        TextureRegion pixelRegion = new TextureRegion(new Texture("pixel.png"));
        shapeDrawer = new ShapeDrawer(spriteBatch, pixelRegion);
    }

    public void render() {
        ScreenUtils.clear(BLACK);

        spriteBatch.begin();
        for (int i = 0; i < stuff.circles.size; i++) {
            Circle circle = stuff.circles.get(i);
            shapeDrawer.circle(circle.x, circle.y, circle.radius);
        }
        spriteBatch.end();
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }
}