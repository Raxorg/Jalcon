package com.epicness.jalcon.game.logic.planets;

import static com.badlogic.gdx.graphics.Color.CLEAR;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.SnapshotArray;
import com.epicness.fundamentals.stuff.shapes.bidimensional.Line;
import com.epicness.jalcon.game.logic.GameLogicHandler;
import com.epicness.jalcon.game.logic.ships.ShipSpawner;
import com.epicness.jalcon.game.stuff.Planet;
import com.epicness.jalcon.game.stuff.Player;

public class PlanetDragHandler extends GameLogicHandler {

    private ShipSpawner shipSpawner;
    private PlanetOwnershipHandler ownershipHandler;

    private Player player;
    private SnapshotArray<Planet> planets;
    private Line dragLine;

    private Planet sourcePlanet, targetPlanet;
    private Vector2 auxVector;

    @Override
    protected void init() {
        shipSpawner = get(ShipSpawner.class);
        ownershipHandler = get(PlanetOwnershipHandler.class);

        planets = stuff.getPlanets();
        dragLine = stuff.getDragLine();

        auxVector = new Vector2();
    }

    public void identifyPlayer() {
        player = stuff.getPlayers().first();
    }

    @Override
    public void touchDown(float x, float y, int button) {
        for (Planet planet : planets) {
            if (ownershipHandler.isOwner(player, planet) && planet.contains(x, y)) {
                sourcePlanet = planet;
                return;
            }
        }
    }

    @Override
    public void touchDragged(float x, float y) {
        if (sourcePlanet == null) return;

        if (sourcePlanet.contains(x, y)) {
            dragLine.setColor(CLEAR);
            return;
        }
        dragLine.setColorA(player.getColor());
        dragLine.setColorB(CLEAR);

        targetPlanet = null;
        for (int i = 0; i < planets.size; i++) {
            Planet planet = planets.get(i);
            if (planet != sourcePlanet && planet.contains(x, y)) {
                targetPlanet = planet;
                dragLine.setColorB(targetPlanet.getPlanetColor());
                break;
            }
        }

        if (targetPlanet != null) {
            updateLineToTargetPlanet(targetPlanet);
        } else {
            updateLineFromSurfacePoint(x, y);
        }
    }

    @Override
    public void touchUp(float x, float y, int button) {
        if (sourcePlanet != null && targetPlanet != null && targetPlanet.contains(x, y)) {
            shipSpawner.spawnShips(sourcePlanet, targetPlanet);
        }
        sourcePlanet = null;
        dragLine.setColor(CLEAR);
    }

    private void updateLineToTargetPlanet(Planet target) {
        // Get centers
        float sourceX = sourcePlanet.getCenterX();
        float sourceY = sourcePlanet.getCenterY();
        float targetX = target.getCenterX();
        float targetY = target.getCenterY();

        // Calculate direction
        auxVector.set(targetX - sourceX, targetY - sourceY);
        auxVector.nor();

        // Calculate start point on source planet surface
        float startX = sourceX + sourcePlanet.getRadius() * auxVector.x;
        float startY = sourceY + sourcePlanet.getRadius() * auxVector.y;

        // Calculate end point on target planet surface
        float endX = targetX - target.getRadius() * auxVector.x;
        float endY = targetY - target.getRadius() * auxVector.y;

        // Update line
        dragLine.setPoints(startX, startY, endX, endY);
    }

    private void updateLineFromSurfacePoint(float targetX, float targetY) {
        // Calculate direction from planet center to target point
        float centerX = sourcePlanet.getCenterX();
        float centerY = sourcePlanet.getCenterY();

        auxVector.set(targetX - centerX, targetY - centerY);

        // Calculate point on planet surface
        float radius = sourcePlanet.getRadius();
        auxVector.nor();
        float surfaceX = centerX + radius * auxVector.x;
        float surfaceY = centerY + radius * auxVector.y;

        dragLine.setPoints(surfaceX, surfaceY, targetX, targetY);
    }
}