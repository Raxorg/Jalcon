package com.epicness.jalcon.stuff;

import static com.epicness.jalcon.Constants.PLANET_HALF_THICKNESS;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.SnapshotArray;

public class Stuff {

    public final SnapshotArray<Planet> planets;

    public Stuff() {
        planets = new SnapshotArray<>();

        for (int i = 0; i < 25; i++) {
            spawnPlanet();
        }
    }

    private void spawnPlanet() {
        Circle circle;
        boolean overlaps;
        do {
            float radius = MathUtils.random(10f, 50f);
            float x = MathUtils.random(radius + PLANET_HALF_THICKNESS, 1200f - radius - PLANET_HALF_THICKNESS);
            float y = MathUtils.random(radius + PLANET_HALF_THICKNESS, 700f - radius - PLANET_HALF_THICKNESS);
            circle = new Circle(x, y, radius);
            overlaps = overlapsPlanets(circle);
        } while (overlaps);
        planets.add(new Planet(circle));
    }

    private boolean overlapsPlanets(Circle circle) {
        for (int i = 0; i < planets.size; i++) {
            if (planets.get(i).circle.overlaps(circle)) {
                return true;
            }
        }
        return false;
    }
}