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
        assets.getShip3().getTexture().setFilter(Linear, Linear);
    }

    public void spawnShips(Planet sourcePlanet, Planet targetPlanet) {
        int quantity = sourcePlanet.getShipCount() / 2;
        float centerX = sourcePlanet.getCenterX() - SHIP_HALF_WIDTH;
        float centerY = sourcePlanet.getCenterY() - SHIP_HALF_HEIGHT;
        float targetX = targetPlanet.getCenterX();
        float targetY = targetPlanet.getCenterY();

        for (int i = 0; i < quantity; i++) {
            float angle = MathUtils.random(360f);
            float x = centerX + MathUtils.cosDeg(angle) * sourcePlanet.getRadius();
            float y = centerY + MathUtils.sinDeg(angle) * sourcePlanet.getRadius();
            Ship ship = new Ship(assets.getShip3(), x, y, targetX, targetY);
            ship.setColor(ownershipHandler.getOwner(sourcePlanet).getColor());
            ship.setAngle(angle - 90f);
            ships.add(ship);
        }
    }
}