package com.epicness.jalcon.stuff;

import static com.epicness.jalcon.Constants.PLANET_INNER_THICKNESS;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.SnapshotArray;

public class Stuff {

    public final SnapshotArray<Planet> planets;

    public Stuff() {
        planets = new SnapshotArray<>();

        float offset = PLANET_INNER_THICKNESS;
        for (int i = 0; i < 20; i++) {
            float radius = MathUtils.random(10f, 50f);
            float x = MathUtils.random(radius + offset, 1200f - radius - offset);
            float y = MathUtils.random(radius + offset, 700f - radius - offset);
            planets.add(new Planet(x, y, radius));
        }
    }
}