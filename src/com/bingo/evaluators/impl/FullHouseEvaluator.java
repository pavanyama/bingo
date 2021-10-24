package com.bingo.evaluators.impl;

import com.bingo.model.Game;
import com.bingo.model.PlayersTicket;

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
        game.getTotalNumbersCountOnTicket();
        AtomicInteger markedCellCount = new AtomicInteger();
        playersTicket.getTicket().getTicketCells().forEach(ticketRow -> {
            ticketRow.forEach(ticketCell -> {
                if(ticketCell.isCellMarked()){
                    markedCellCount.getAndIncrement();
                }
                if(markedCellCount.get() == game.getTotalNumbersCountOnTicket()){
                    System.out.println("We have a winner:"+ playersTicket.getPlayer().getName()
                            +" has won 'Full House' winning combination.");
                    this.setEvaluationIdentifiedWinner(true);
                    return;
                }
            });
        });
    }
}