package com.epicness.jalcon.stuff;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.SnapshotArray;

public class Stuff {

    public final SnapshotArray<Planet> planets;

    public Stuff() {
        planets = new SnapshotArray<>();
        for (int i = 0; i < 20; i++) {
            float radius = MathUtils.random(10f, 50f);
            float x = MathUtils.random(1200f);
            float y = MathUtils.random(700f);
            planets.add(new Planet(x, y, radius));
        }
    }
}