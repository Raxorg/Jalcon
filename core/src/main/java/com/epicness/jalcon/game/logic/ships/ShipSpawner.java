package com.epicness.jalcon.game.logic.ships;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.epicness.jalcon.game.GameConstants.SHIP_HALF_HEIGHT;
import static com.epicness.jalcon.game.GameConstants.SHIP_HALF_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.jalcon.game.logic.GameLogicHandler;
import com.epicness.jalcon.game.logic.planets.PlanetOwnershipHandler;
import com.epicness.jalcon.game.stuff.Planet;
import com.epicness.jalcon.game.stuff.Ship;

public class ShipSpawner extends GameLogicHandler {

    private PlanetOwnershipHandler ownershipHandler;
    private SnapshotArray<Ship> ships;

    @Override
    protected void init() {
        ownershipHandler = get(PlanetOwnershipHandler.class);
        ships = stuff.getShips();
        assets.getShip().getTexture().setFilter(Linear, Linear);
    }

    public void spawnShips(Planet planet) {
        int quantity = planet.getShipCount() / 2;
        float centerX = planet.getCenterX() - SHIP_HALF_WIDTH;
        float centerY = planet.getCenterY() - SHIP_HALF_HEIGHT;
        for (int i = 0; i < quantity; i++) {
            float angle = MathUtils.random(360f);
            float x = centerX + MathUtils.cosDeg(angle) * planet.getRadius();
            float y = centerY + MathUtils.sinDeg(angle) * planet.getRadius();
            Ship ship = new Ship(assets.getShip(), x, y);
            ship.setColor(ownershipHandler.getOwner(planet).getColor());
            ship.setAngle(angle - 90f);
            ships.add(ship);
        }
    }
}