package com.epicness.jalcon.game.logic.planets;

import com.epicness.jalcon.game.logic.GameLogicHandler;
import com.epicness.jalcon.game.stuff.Planet;
import com.epicness.jalcon.game.stuff.Player;

import java.util.HashMap;

public class PlanetOwnershipHandler extends GameLogicHandler {

    private HashMap<Planet, Player> ownershipMap;

    @Override
    protected void init() {
        ownershipMap = new HashMap<>();
    }

    public void setOwner(Planet planet, Player player) {
        ownershipMap.put(planet, player);
        planet.setPlanetAndBGColor(player.getColor());
    }

    public boolean isOwner(Player player, Planet planet) {
        return ownershipMap.get(planet) == player;
    }

    public Player getOwner(Planet planet) {
        return ownershipMap.get(planet);
    }
}
