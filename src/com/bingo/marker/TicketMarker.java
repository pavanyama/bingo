package com.bingo.marker;

import com.bingo.model.Game;

/*
 * This class responsible to mark the cells of matching number announced by caller.
 */
public class TicketMarker {

    public void markTickets(Game game) {
        game.getPlayersTickets().forEach(playersTicket -> { //For each players ticket
            playersTicket.getTicket().markTicketWithMatchingNumber(game.getMostRecentCallerNumber());
        });
    }
}
