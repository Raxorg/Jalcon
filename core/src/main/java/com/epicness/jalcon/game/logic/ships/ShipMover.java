package com.epicness.jalcon.game.logic.ships;

import static com.epicness.jalcon.game.GameConstants.SHIP_SPEED;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.jalcon.game.logic.GameLogicHandler;
import com.epicness.jalcon.game.stuff.Ship;

public class ShipMover extends GameLogicHandler {

    private SnapshotArray<Ship> ships;
    private Vector2 shipCenter, direction;

    @Override
    protected void init() {
        ships = stuff.getShips();
        shipCenter = new Vector2();
        direction = new Vector2();
    }

    @Override
    protected void update(float delta) {
        Object[] array = ships.begin();
        for (int i = 0, n = ships.size; i < n; i++) {
            moveShip((Ship) array[i], delta);
        }
        ships.end();
    }

    private void moveShip(Ship ship, float delta) {
        shipCenter.set(ship.getCenterX(), ship.getCenterY());
        direction.set(ship.target).sub(shipCenter);

        // Calculate distance to target
        float distance = direction.len();

        // Only move if not already at target
        if (distance > 0.1f) { // Small threshold to avoid jittering
            float angle = direction.angleDeg();
            ship.setAngle(angle - 90f);

            float moveDistance = SHIP_SPEED * delta;
            // Don't overshoot the target
            if (moveDistance > distance) {
                moveDistance = distance;
            }

            direction.nor().scl(moveDistance);
            ship.translate(direction.x, direction.y);
        }
    }
}
