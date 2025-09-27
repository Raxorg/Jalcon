package com.epicness.jalcon.game.stuff;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.jalcon.game.assets.GameAssets;

public class GameStuff extends Stuff<GameAssets> {

    private SnapshotArray<Planet> planets;
    private SnapshotArray<Player> players;

    @Override
    public void initializeStuff() {
        planets = new SnapshotArray<>();
        players = new SnapshotArray<>();
    }

    public SnapshotArray<Planet> getPlanets() {
        return planets;
    }

    public SnapshotArray<Player> getPlayers() {
        return players;
    }
}