package com.bingo.evaluators.impl;

import com.bingo.model.Game;
import com.bingo.model.PlayersTicket;
import com.bingo.model.Ticket;
import com.bingo.model.Winner;

import java.util.concurrent.atomic.AtomicInteger;

public class EarlyCountEvaluator extends AbstractEvaluator {

    private Integer WINNING_COUNT = 5;
    private String WINNING_DESCRIPTION = "First Five";
    @Override
    public boolean evaluate(Game game) {

        game.getPlayersTickets().forEach(playersTicket -> {
            evaluateTicket(playersTicket, game);
        });
        return true;
    }

    private void evaluateTicket(PlayersTicket playersTicket, Game game) {
        AtomicInteger count = new AtomicInteger();
        playersTicket.getTicket().getTicketCells().forEach(ticketCells -> {
            ticketCells.forEach( ticketCell -> {
                if(ticketCell.isCellMarked()) {
                    count.getAndIncrement();
                    if(count.get() == WINNING_COUNT) {
                        System.out.println("We have a winner:"+ playersTicket.getPlayer().getName()
                                +" has won '"+WINNING_DESCRIPTION+"' winning combination.");
                        this.setEvaluationIdentifiedWinner(true);
                        Winner winner = new Winner(playersTicket.getPlayer(),
                                playersTicket.getTicket(),
                                this);
                        game.addWinner(winner);
                        return;
                    }
                }
            });
        });
    }
}
