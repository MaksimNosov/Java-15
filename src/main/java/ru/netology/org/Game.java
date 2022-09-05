package ru.netology.org;

import java.util.HashMap;

public class Game {

    protected HashMap<String, Integer> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.name, player.strength);
    }

    public int round(String playerName1, String playerName2) {
        String player1 = null;
        String player2 = null;

        for (String s : players.keySet()) {

            if (players.containsKey(playerName1)) {
                player1 = playerName1;
            }
            if (players.containsKey(playerName2)) {
                player2 = playerName2;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException("Player with name: " + playerName1 + " ne zaregistrirovan");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player with name: " + playerName2 + " ne zaregistrirovan");
        }

        if (players.get(player1) > players.get(player2)) {
            return 1;
        }
        if (players.get(player1) < players.get(player2)) {
            return 2;
        } else {
            return 0;
        }
    }
}


