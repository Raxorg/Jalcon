package com.epicness.jalcon.game.assets;

import static com.epicness.jalcon.game.assets.GameAssetPaths.*;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {
    private Music musicLobby;

    private Sprite planet1;

    private Sprite planet2;

    private Sprite ship;

    private Sprite starfield;

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
}