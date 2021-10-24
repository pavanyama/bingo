package com.bingo.generator;

import com.bingo.model.Game;
import com.bingo.model.Player;

public class PlayerGenerator implements IGenerator {


    @Override
    public boolean generateAndPopulate(Game game) {
        int playerCount = game.getPlayersCount();
        for(int i=1; i<= playerCount; i++) {
            Player player = new Player("Player"+i);
            game.addPlayer(player);
        }
        return true;
    }
}
