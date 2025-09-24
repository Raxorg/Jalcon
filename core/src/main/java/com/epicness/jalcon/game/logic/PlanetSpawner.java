package com.epicness.jalcon.game.logic;

import static com.epicness.jalcon.game.GameConstants.PLANET_HALF_THICKNESS;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.fundamentals.stuff.shapes.bidimensional.CirclePlus;
import com.epicness.jalcon.game.stuff.Planet;

public class PlanetSpawner extends GameLogicHandler {

    private SnapshotArray<Planet> planets;

    @Override
    protected void init() {
        planets = stuff.getPlanets();
    }

    public void spawnPlanets() {
        for (int i = 0; i < 25; i++) {
            spawnPlanet();
        }
    }

    private void spawnPlanet() {
        CirclePlus circle;
        boolean overlaps;
        do {
            float radius = MathUtils.random(10f, 50f);
            float x = MathUtils.random(radius + PLANET_HALF_THICKNESS, 1200f - radius - PLANET_HALF_THICKNESS);
            float y = MathUtils.random(radius + PLANET_HALF_THICKNESS, 700f - radius - PLANET_HALF_THICKNESS);
            circle = new CirclePlus(x, y, radius);
            overlaps = overlapsPlanets(circle);
        } while (overlaps);
        planets.add(new Planet(circle, sharedAssets.getPixelFont()));
    }

    private boolean overlapsPlanets(CirclePlus circle) {
        for (int i = 0; i < planets.size; i++) {
            if (planets.get(i).overlaps(circle)) {
                return true;
            }
        }
        return false;
    }
}