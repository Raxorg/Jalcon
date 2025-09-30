package com.epicness.jalcon.game.logic.ships;

import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.jalcon.game.logic.GameLogicHandler;
import com.epicness.jalcon.game.stuff.Ship;

public class ShipMover extends GameLogicHandler {

    private SnapshotArray<Ship> ships;

    @Override
    protected void init() {
        ships = stuff.getShips();
    }

    @Override
    protected void update(float delta) {

    }
}
