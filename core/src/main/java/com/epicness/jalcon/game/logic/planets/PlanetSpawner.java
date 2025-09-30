package com.epicness.jalcon.game.logic.planets;

import static com.badlogic.gdx.graphics.Color.GRAY;
import static com.epicness.fundamentals.constants.SharedConstants.VIEWPORT_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.VIEWPORT_WIDTH;
import static com.epicness.jalcon.game.GameConstants.MAX_PLANET_RADIUS;
import static com.epicness.jalcon.game.GameConstants.MIN_PLANET_RADIUS;
import static com.epicness.jalcon.game.GameConstants.PLANET_HALF_THICKNESS;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.fundamentals.stuff.shapes.bidimensional.CirclePlus;
import com.epicness.jalcon.game.logic.GameLogicHandler;
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
        float radius = MathUtils.random(MIN_PLANET_RADIUS, MAX_PLANET_RADIUS);
        boolean overlaps;
        do {
            float x = MathUtils.random(PLANET_HALF_THICKNESS, VIEWPORT_WIDTH - radius * 2f - PLANET_HALF_THICKNESS);
            float y = MathUtils.random(PLANET_HALF_THICKNESS, VIEWPORT_HEIGHT - radius * 2f - PLANET_HALF_THICKNESS);
            circle.setPosition(x, y);
            circle.setRadius(radius);
            overlaps = overlapsPlanets(circle);
        } while (overlaps);
        float productionInterval = MathUtils.map(MIN_PLANET_RADIUS, MAX_PLANET_RADIUS, 1f, 0.3f, radius);
        Sprite planetSprite = MathUtils.randomBoolean() ? assets.getPlanet1() : assets.getPlanet2();
        Planet planet = new Planet(planetSprite, circle, sharedAssets.getPixelFont(), productionInterval);
        planet.setFontScale(2.5f);
        planet.setPlanetAndBGColor(GRAY);
        planet.setProducing(false);
        planets.add(planet);
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