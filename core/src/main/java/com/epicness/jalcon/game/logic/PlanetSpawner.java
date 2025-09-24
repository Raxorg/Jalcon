package com.epicness.jalcon.game.logic;

import static com.epicness.fundamentals.constants.SharedConstants.VIEWPORT_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.VIEWPORT_WIDTH;
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
            spawnRandomPlanet();
        }
    }

    private void spawnRandomPlanet() {
        CirclePlus circle = new CirclePlus();
        float radius = MathUtils.random(10f, 50f);
        boolean overlaps;
        do {
            float x = MathUtils.random(PLANET_HALF_THICKNESS, VIEWPORT_WIDTH - radius * 2f - PLANET_HALF_THICKNESS);
            float y = MathUtils.random(PLANET_HALF_THICKNESS, VIEWPORT_HEIGHT - radius * 2f - PLANET_HALF_THICKNESS);
            circle.setPosition(x, y);
            circle.setRadius(radius);
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