package com.bingo.evaluators.impl;

import com.bingo.model.*;
import com.bingo.util.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TopLineEvaluator extends AbstractEvaluator {

    @Override
    public boolean evaluate(Game game) {
        game.getPlayersTickets().forEach( playersTicket -> {
            evaluateTicket(playersTicket, game);
        });
        return false;
    }

    private void evaluateTicket(PlayersTicket playersTicket, Game game) {
        AtomicInteger count = new AtomicInteger();

        TicketRow firstRow = playersTicket.getTicket().getTicketRows().get(0);
        if(firstRow.areAllCellsMarked()){
            System.out.println("We have a winner:"+ playersTicket.getPlayer().getName()
                    +" has won 'Top Line' winning combination.");
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
        return Constants.TOP_LINE_DESCRIPTION;
    }
}