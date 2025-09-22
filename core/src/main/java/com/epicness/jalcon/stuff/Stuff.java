package com.epicness.jalcon.stuff;

import static com.epicness.jalcon.Constants.PLANET_INNER_THICKNESS;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.SnapshotArray;

public class Stuff {

    public final SnapshotArray<Planet> planets;

    public Stuff() {
        planets = new SnapshotArray<>();

        float offset = PLANET_INNER_THICKNESS;
        for (int i = 0; i < 25; i++) {
            float radius = MathUtils.random(10f, 50f);
            float x = MathUtils.random(radius + offset, 1200f - radius - offset);
            float y = MathUtils.random(radius + offset, 700f - radius - offset);
            Circle circle = new Circle(x, y, radius);
            boolean overlaps = false;
            for (int j = 0; j < planets.size; j++) {
                if (planets.get(j).circle.overlaps(circle)) {
                    overlaps = true;
                }
            }
            if (overlaps) {
                i--;
            } else {
                planets.add(new Planet(circle));
            }
        }
    }
}