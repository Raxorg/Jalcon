package com.epicness.jalcon.stuff;

import static com.epicness.jalcon.Constants.PLANET_THICKNESS;

import com.badlogic.gdx.math.Circle;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Planet {

    public final Circle circle;

    public Planet(Circle circle) {
        this.circle = circle;
    }

    public Planet(float x, float y, float radius) {
        circle = new Circle(x, y, radius);
    }

    public void draw(ShapeDrawer shapeDrawer) {
        shapeDrawer.circle(circle.x, circle.y, circle.radius, PLANET_THICKNESS);
    }
}