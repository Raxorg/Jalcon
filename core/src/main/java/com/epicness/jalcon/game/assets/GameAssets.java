package com.epicness.jalcon.game.assets;

import static com.epicness.jalcon.game.assets.GameAssetPaths.*;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {
    private Music musicLobby;

    private Sprite planet1;

    private Sprite planet2;

    private Sprite ship;

    private Sprite starfield;

    private ShaderProgram horizontalBlur4;

    private ShaderProgram horizontalBlur8;

    private ShaderProgram verticalBlur4;

    private ShaderProgram verticalBlur8;

    public GameAssets() {
        super(ASSETS);
    }

    @Override
    public void initializeAssets() {
        musicLobby = get(MUSICLOBBY_MUSIC);
        planet1 = get(PLANET1_SPRITE);
        planet2 = get(PLANET2_SPRITE);
        ship = get(SHIP_SPRITE);
        starfield = get(STARFIELD_SPRITE);
        horizontalBlur4 = get(HORIZONTALBLUR4_SHADER_PROGRAM);
        horizontalBlur8 = get(HORIZONTALBLUR8_SHADER_PROGRAM);
        verticalBlur4 = get(VERTICALBLUR4_SHADER_PROGRAM);
        verticalBlur8 = get(VERTICALBLUR8_SHADER_PROGRAM);
    }

    public Music getMusicLobby() {
        return musicLobby;
    }

    public Sprite getPlanet1() {
        return planet1;
    }

    public Sprite getPlanet2() {
        return planet2;
    }

    public Sprite getShip() {
        return ship;
    }

    public Sprite getStarfield() {
        return starfield;
    }

    public ShaderProgram getHorizontalBlur4() {
        return horizontalBlur4;
    }

    public ShaderProgram getHorizontalBlur8() {
        return horizontalBlur8;
    }

    public ShaderProgram getVerticalBlur4() {
        return verticalBlur4;
    }

    public ShaderProgram getVerticalBlur8() {
        return verticalBlur8;
    }
}