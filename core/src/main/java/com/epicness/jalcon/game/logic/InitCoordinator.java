package com.epicness.jalcon.game.logic;

public class InitCoordinator extends GameLogicHandler {

    @Override
    protected void init() {
        get(PlanetSpawner.class).spawnPlanets();
        get(PlayerSpawner.class).spawnPlayers();
    }
}