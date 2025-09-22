package com.epicness.jalcon;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.SnapshotArray;

public class Stuff {

    public final SnapshotArray<Circle> circles;

    public Stuff() {
        circles = new SnapshotArray<>();
        for (int i = 0; i < 20; i++) {
            float x = MathUtils.random(1200f);
            float y = MathUtils.random(700f);
            circles.add(new Circle(x, y, 10f));
        }
    }
}