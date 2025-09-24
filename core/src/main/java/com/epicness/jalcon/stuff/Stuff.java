package com.epicness.jalcon.stuff;

import com.badlogic.gdx.utils.SnapshotArray;

/**
 * Holds all the game objects, tangible or intangible
 */
public class Stuff {

    public final SnapshotArray<Planet> planets;

    public Stuff() {
        planets = new SnapshotArray<>();
    }
}