package com.epicness.jalcon.game.logic;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.ORANGE;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.jalcon.game.GameConstants.JALCON_MINT;
import static com.epicness.jalcon.game.GameConstants.JALCON_PERIWINKLE;
import static com.epicness.jalcon.game.GameConstants.JALCON_PURPLE;
import static com.epicness.jalcon.game.GameConstants.JALCON_SALMON;
import static com.epicness.jalcon.game.GameConstants.JALCON_YELLOW;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.jalcon.game.stuff.Planet;
import com.epicness.jalcon.game.stuff.Player;

public class PlayerSpawner extends GameLogicHandler {

    private PlanetOwnershipHandler ownershipHandler;

    private SnapshotArray<Player> players;
    private SnapshotArray<Planet> planets;

    @Override
    protected void init() {
        ownershipHandler = get(PlanetOwnershipHandler.class);

        players = stuff.getPlayers();
        planets = stuff.getPlanets();
    }

    public void spawnPlayers() {
        Player periwinkle = new Player(JALCON_PERIWINKLE);
        Player purple = new Player(JALCON_PURPLE);
        Player yellow = new Player(JALCON_YELLOW);
        Player salmon = new Player(JALCON_SALMON);
        Player mint = new Player(JALCON_MINT);
        Player orange = new Player(ORANGE);
        players.addAll(periwinkle, purple, yellow, salmon, mint, orange);

        ownershipHandler.setOwner(planets.get(0), periwinkle);
        ownershipHandler.setOwner(planets.get(1), purple);
        ownershipHandler.setOwner(planets.get(2), yellow);
        ownershipHandler.setOwner(planets.get(3), salmon);
        ownershipHandler.setOwner(planets.get(4), mint);
        ownershipHandler.setOwner(planets.get(5), orange);

        for (int i = 0; i < 6; i++) {
            planets.get(i).setFontColor(CLEAR);
            planets.get(i).setProducing(true);
        }
        planets.get(0).setFontColor(WHITE);
    }
}