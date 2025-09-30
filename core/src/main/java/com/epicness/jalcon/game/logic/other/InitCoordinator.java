package com.epicness.jalcon.game.logic.other;

import com.epicness.jalcon.game.logic.GameLogicHandler;
import com.epicness.jalcon.game.logic.planets.PlanetDragHandler;
import com.epicness.jalcon.game.logic.planets.PlanetSpawner;

public class InitCoordinator extends GameLogicHandler {

    @Override
    protected void init() {
        get(PlanetSpawner.class).spawnPlanets();
        get(PlayerSpawner.class).spawnPlayers();
        get(PlanetDragHandler.class).identifyPlayer();
    }
}