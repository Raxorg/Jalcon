package com.epicness.jalcon.game.logic;

import com.epicness.fundamentals.logic.Logic;
import com.epicness.jalcon.game.logic.other.BackgroundHandler;
import com.epicness.jalcon.game.logic.other.CameraHandler;
import com.epicness.jalcon.game.logic.other.InitCoordinator;
import com.epicness.jalcon.game.logic.other.PlayerSpawner;
import com.epicness.jalcon.game.logic.ships.ShipMover;
import com.epicness.jalcon.game.logic.ships.ShipSpawner;
import com.epicness.jalcon.game.logic.planets.PlanetDragHandler;
import com.epicness.jalcon.game.logic.planets.PlanetOwnershipHandler;
import com.epicness.jalcon.game.logic.planets.PlanetProductionHandler;
import com.epicness.jalcon.game.logic.planets.PlanetSelector;
import com.epicness.jalcon.game.logic.planets.PlanetSpawner;

public class GameLogic extends Logic {

    private final BackgroundHandler backgroundHandler;
    private final PlanetProductionHandler planetProductionHandler;
    private final ShipMover shipMover;

    public GameLogic() {
        // Other
        registerHandler(backgroundHandler = new BackgroundHandler());
        registerHandler(new CameraHandler());
        registerHandler(new PlayerSpawner());
        // Planets
        registerHandler(new PlanetDragHandler());
        registerHandler(new PlanetOwnershipHandler());
        registerHandler(planetProductionHandler = new PlanetProductionHandler());
        registerHandler(new PlanetSelector());
        registerHandler(new PlanetSpawner());
        // Ships
        registerHandler(new ShipSpawner());
        registerHandler(shipMover = new ShipMover());

        registerHandler(new InitCoordinator()); // Always register at the end
    }

    @Override
    public void update() {
        planetProductionHandler.update();
        shipMover.update();
    }

    @Override
    public void resize(int width, int height) {
        backgroundHandler.resize(width, height);
    }
}
