package com.bingo.marker.impl;

import com.bingo.model.Game;

public class TicketMarker {

    public void markTickets(Game game) {

        game.getTickets().forEach(ticket -> { //For each players ticket
            ticket.getTicketCells().forEach(ticketRows ->  // For each row in each ticket
                    ticketRows.forEach(ticketCell -> { // For each cell in each row
                        if (game.getMostRecentCallerNumber() == ticketCell.getValue()) {
                            ticketCell.markCell();
                        }
                    }
            ));
        });
    }
}
