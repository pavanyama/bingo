package com.bingo.evaluators.impl;

import com.bingo.model.*;
import com.bingo.util.Constants;

public class TopLineEvaluator extends AbstractEvaluator {

    @Override
    public void evaluate(Game game) {
        game.getPlayersTickets().forEach( playersTicket -> {
            evaluateTicket(playersTicket, game);
        });
    }

    private void evaluateTicket(PlayersTicket playersTicket, Game game) {
        TicketRow firstRow = playersTicket.getTicket().getTicketRows().get(0);
        if(firstRow.areAllCellsMarked()){
            System.out.println("We have a winner:"+ playersTicket.getPlayer().getName()
                    +" has won 'Top Line' winning combination.");
            //Mark as this evaluation is identified a winner.
            this.setEvaluationIdentifiedWinner(true);
            //Build a winner and add to game.
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