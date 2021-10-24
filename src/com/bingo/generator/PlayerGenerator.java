package com.bingo.generator;

import com.bingo.model.Game;
import com.bingo.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerGenerator  {

    public List<Player> generate(Game game) {
        List<Player> players = new ArrayList<>(game.getPlayersCount());
        for(int i=1; i<= game.getPlayersCount(); i++) {
            Player player = new Player("Player"+i);
            players.add(player);
        }
        return players;
    }
}
