package com.epicness.jalcon;

import com.badlogic.gdx.Game;
import com.epicness.jalcon.stuff.Stuff;

public class JalconGame extends Game {

    private Renderer renderer;

    @Override
    public void create() {
        renderer = new Renderer();
        Stuff stuff = new Stuff();
        Logic logic = new Logic();

        logic.setStuff(stuff);
        renderer.setStuff(stuff);

        logic.spawnPlanets();
    }

    @Override
    public void render() {
        renderer.render();
    }
}