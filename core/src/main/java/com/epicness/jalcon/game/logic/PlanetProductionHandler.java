package com.epicness.jalcon.game.logic;

import static com.epicness.fundamentals.utils.ArrayUtils.loopArray;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.jalcon.game.stuff.Planet;

public class PlanetProductionHandler extends GameLogicHandler {

    private SnapshotArray<Planet> planets;

    @Override
    protected void init() {
        planets = stuff.getPlanets();
    }

    @Override
    protected void update(float delta) {
        loopArray(planets, planet -> {
            float newProductionTime = planet.getProductionTime() + delta;
            if (newProductionTime >= planet.productionInterval) {
                planet.setShips(planet.getShips() + 1);
                newProductionTime -= planet.productionInterval;
            }
            planet.setProductionTime(newProductionTime);
        });
    }
}