package com.epicness.jalcon.game.stuff;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.fundamentals.stuff.SpritePlus;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Line;
import com.epicness.jalcon.game.assets.GameAssets;

public class GameStuff extends Stuff<GameAssets> {

    private SpritePlus background;
    private SnapshotArray<Planet> planets;
    private Line dragLine;
    private SnapshotArray<Ship> ships;
    private SnapshotArray<Player> players;

    @Override
    public void initializeStuff() {
        background = new SpritePlus(assets.getStarfield());
        planets = new SnapshotArray<>();
        ships = new SnapshotArray<>();
        players = new SnapshotArray<>();
        dragLine = new Line(0f);
    }

    public SpritePlus getBackground() {
        return background;
    }

    public SnapshotArray<Planet> getPlanets() {
        return planets;
    }

    public Line getDragLine() {
        return dragLine;
    }

    public SnapshotArray<Ship> getShips() {
        return ships;
    }

    public SnapshotArray<Player> getPlayers() {
        return players;
    }
}