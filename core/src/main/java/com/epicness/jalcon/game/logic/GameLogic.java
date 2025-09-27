package com.epicness.jalcon.game.logic;

import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    private final PlanetProductionHandler planetProductionHandler;

    public GameLogic() {
        registerHandler(new CameraHandler());
        registerHandler(new PlanetSpawner());
        registerHandler(planetProductionHandler = new PlanetProductionHandler());
        registerHandler(new PlanetSelector());
        registerHandler(new InitCoordinator()); // Always register at the end
    }

    @Override
    public void update() {
        planetProductionHandler.update();
    }

    @Override
    public void resize(int width, int height) {
    }
}
