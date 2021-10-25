package com.bingo.evaluators.impl;

import com.bingo.model.Game;
import com.bingo.model.PlayersTicket;
import com.bingo.model.Winner;
import com.bingo.util.Constants;

import java.util.concurrent.atomic.AtomicInteger;

public class FullHouseEvaluator extends AbstractEvaluator {

    @Override
    public boolean evaluate(Game game) {
        game.getPlayersTickets().forEach(playersTicket -> {
            evaluateTicket(playersTicket, game);
        });
        return false;
    }

    private void evaluateTicket(PlayersTicket playersTicket, Game game) {
        if(playersTicket.getTicket().areAllRowsMarked()) {
            System.out.println("We have a winner:"+ playersTicket.getPlayer().getName()
                    +" has won 'Full House' winning combination.");
            this.setEvaluationIdentifiedWinner(true);
            Winner winner = new Winner(playersTicket.getPlayer(),
                    playersTicket.getTicket(),
                    this);
            game.addWinner(winner);
            return;
        }
    }
    @Override
    public String getName() {
        return Constants.FULL_HOUSE_DESCRIPTION;
    }
}