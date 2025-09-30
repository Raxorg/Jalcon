package com.epicness.jalcon.game.logic;

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

    private SnapshotArray<Player> players;
    private SnapshotArray<Planet> planets;

    @Override
    protected void init() {
        players = stuff.getPlayers();
        planets = stuff.getPlanets();
    }

    public void spawnPlayers() {
        Player periwinkle = new Player(JALCON_PERIWINKLE);
        Player purple = new Player(JALCON_PURPLE);
        Player yellow = new Player(JALCON_YELLOW);
        Player salmon = new Player(JALCON_SALMON);
        Player mint = new Player(JALCON_MINT);
        players.addAll(periwinkle, purple, yellow, salmon, mint);

        planets.get(0).setPlanetAndBGColor(JALCON_PERIWINKLE);
        planets.get(1).setPlanetAndBGColor(JALCON_PURPLE);
        planets.get(2).setPlanetAndBGColor(JALCON_YELLOW);
        planets.get(3).setPlanetAndBGColor(JALCON_SALMON);
        planets.get(4).setPlanetAndBGColor(JALCON_MINT);

        for (int i = 0; i < 5; i++) {
            planets.get(i).setFontColor(WHITE);
            planets.get(i).setProducing(true);
        }
    }
}