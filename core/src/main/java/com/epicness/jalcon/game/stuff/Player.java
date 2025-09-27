package com.epicness.jalcon.game.stuff;

import com.badlogic.gdx.graphics.Color;

public class Player {

    private final Color color;

    public Player(Color color) {
        this.color = new Color(color);
    }

    public Color getColor() {
        return color;
    }
}