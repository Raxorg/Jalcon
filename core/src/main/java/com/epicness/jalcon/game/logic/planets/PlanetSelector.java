package com.epicness.jalcon.game.logic.planets;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.GREEN;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.jalcon.game.logic.GameLogicHandler;
import com.epicness.jalcon.game.stuff.Planet;

public class PlanetSelector extends GameLogicHandler {

    private SnapshotArray<Planet> planets;
    private Planet lastSelectedPlanet;

    @Override
    protected void init() {
        planets = stuff.getPlanets();
        lastSelectedPlanet = null;
    }

    @Override
    public void mouseMovedDynamic(float x, float y) {
        if (lastSelectedPlanet != null && !lastSelectedPlanet.contains(x, y)) lastSelectedPlanet.setSelectorColor(CLEAR);

        Planet planet;
        for (int i = 0; i < planets.size; i++) {
            planet = planets.get(i);
            if (planet.contains(x, y)) {
                planet.setSelectorColor(GREEN);
                lastSelectedPlanet = planet;
                return;
            }
        }
    }

    @Override
    public void touchDragged(float x, float y) {
        mouseMovedDynamic(x, y);
    }
}