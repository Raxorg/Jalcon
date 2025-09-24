package com.epicness.jalcon.game;

import com.epicness.fundamentals.initializer.Initializer;
import com.epicness.jalcon.game.assets.GameAssets;
import com.epicness.jalcon.game.logic.GameLogic;
import com.epicness.jalcon.game.stuff.GameStuff;

public class GameInitializer extends Initializer<GameAssets, GameLogic, GameRenderer, GameStuff> {

    public GameInitializer(GameAssets assets) {
        super(assets, new GameLogic(), new GameRenderer(), new GameStuff());
    }
}