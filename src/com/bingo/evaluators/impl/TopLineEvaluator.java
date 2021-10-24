package com.bingo.evaluators.impl;

import com.bingo.evaluators.IEvaluator;
import com.bingo.model.Game;
import com.bingo.model.PlayersTicket;
import com.bingo.model.TicketCell;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TopLineEvaluator extends AbstractEvaluator {

    @Override
    public boolean evaluate(Game game) {
        game.getPlayersTickets().forEach( playersTicket -> {
            evaluate(playersTicket, game);
        });
        return false;
    }

    private void evaluate(PlayersTicket playersTicket, Game game) {
        AtomicInteger count = new AtomicInteger();

        List<TicketCell> firstRow = playersTicket.getTicket().getTicketCells().get(0);
        firstRow.forEach(ticketCell -> {
            if(ticketCell.isCellMarked()){
                count.incrementAndGet();
            }
            if(count.get() == game.getTicketColCount()){
                System.out.println("We have a winner:"+ playersTicket.getPlayer().getName()
                        +" has won 'Top Line' winning combination.");
                this.setEvaluationIdentifiedWinner(true);
                return;
            }
        });
    }
}