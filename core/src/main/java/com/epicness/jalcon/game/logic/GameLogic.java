package com.epicness.jalcon.game.logic;

import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    public GameLogic() {
        registerHandler(new CameraHandler());
        registerHandler(new PlanetSpawner());
        registerHandler(new PlanetSelector());
        registerHandler(new InitCoordinator()); // Always register at the end
    }

    @Override
    public void update() {
    }

    @Override
    public void resize(int width, int height) {
    }
}
