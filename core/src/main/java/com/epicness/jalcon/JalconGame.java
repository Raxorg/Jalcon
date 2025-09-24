package com.epicness.jalcon;

import com.badlogic.gdx.Game;
import com.epicness.fundamentals.SharedResources;
import com.epicness.jalcon.game.GameInitializer;
import com.epicness.jalcon.game.assets.GameAssets;

public class JalconGame extends Game {

    @Override
    public void create() {
        GameAssets assets = new GameAssets();
        assets.queueAssetLoading();
        assets.finishLoading();
        assets.initAssets();

        new GameInitializer(assets).initialize(new SharedResources());
    }
}