package com.bingo.evaluators.impl;

import com.bingo.model.Game;
import com.bingo.model.PlayersTicket;
import com.bingo.model.Winner;
import com.bingo.util.Constants;

import java.util.concurrent.atomic.AtomicInteger;

public class EarlyCountEvaluator extends AbstractEvaluator {

    @Override
    public void evaluate(Game game) {
        game.getPlayersTickets().forEach(playersTicket -> evaluateTicket(playersTicket, game));
    }

    @Override
    public String getName() {
        return Constants.WINNING_DESCRIPTION;
    }

    private void evaluateTicket(PlayersTicket playersTicket, Game game) {
        AtomicInteger count = new AtomicInteger();
        playersTicket.getTicket().getTicketRows().forEach(ticketRow -> {
            ticketRow.getTicketCells().forEach( ticketCell -> {
                if(ticketCell.isCellMarked()) {
                    count.getAndIncrement();
                    if(count.get() == Constants.WINNING_COUNT) {
                        System.out.println("We have a winner:"+ playersTicket.getPlayer().getName()
                                +" has won '"+ Constants.WINNING_DESCRIPTION+"' winning combination.");
                        this.setEvaluationIdentifiedWinner(true);
                        Winner winner = new Winner(playersTicket.getPlayer(),
                                playersTicket.getTicket(),
                                this);
                        game.addWinner(winner);
                        //noinspection UnnecessaryReturnStatement
                        return;
                    }
                }
            });
        });
    }
}
