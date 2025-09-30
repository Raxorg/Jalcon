package com.epicness.jalcon.game.logic;

import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    private final BackgroundHandler backgroundHandler;
    private final PlanetProductionHandler planetProductionHandler;

    public GameLogic() {
        registerHandler(backgroundHandler = new BackgroundHandler());
        registerHandler(new CameraHandler());
        registerHandler(new DragHandler());
        registerHandler(new PlanetSpawner());
        registerHandler(new PlanetOwnershipHandler());
        registerHandler(planetProductionHandler = new PlanetProductionHandler());
        registerHandler(new PlanetSelector());
        registerHandler(new PlayerSpawner());

        registerHandler(new InitCoordinator()); // Always register at the end
    }

    @Override
    public void update() {
        planetProductionHandler.update();
    }

    @Override
    public void resize(int width, int height) {
        backgroundHandler.resize(width, height);
    }
}
