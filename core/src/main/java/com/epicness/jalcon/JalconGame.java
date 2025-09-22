package com.epicness.jalcon;

import com.badlogic.gdx.Game;

public class JalconGame extends Game {

    private Renderer renderer;

    @Override
    public void create() {
        renderer = new Renderer();
        Stuff stuff = new Stuff();

        renderer.setStuff(stuff);
    }

    @Override
    public void render() {
        renderer.render();
    }
}