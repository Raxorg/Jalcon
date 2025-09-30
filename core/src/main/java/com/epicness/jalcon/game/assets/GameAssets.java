package com.epicness.jalcon.game.assets;

import static com.epicness.jalcon.game.assets.GameAssetPaths.*;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {
    private Sprite planet1;

    private Sprite planet2;

    private Sprite starfield;

    public GameAssets() {
        super(ASSETS);
    }

    @Override
    public void initializeAssets() {
        planet1 = get(PLANET1_SPRITE);
        planet2 = get(PLANET2_SPRITE);
        starfield = get(STARFIELD_SPRITE);
    }

    public Sprite getPlanet1() {
        return planet1;
    }

    public Sprite getPlanet2() {
        return planet2;
    }

    public Sprite getStarfield() {
        return starfield;
    }
}