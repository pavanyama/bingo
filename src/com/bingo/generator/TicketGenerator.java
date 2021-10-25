package com.bingo.generator;

import com.bingo.model.Game;
import com.bingo.model.Ticket;
import com.bingo.model.TicketCell;
import com.bingo.model.TicketRow;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/*
 * This class contains the logic of
 * - generating random numbers of a ticket
 * - arranging them in row and columns in a ticket.
 */
public class TicketGenerator{

    public List<Ticket> generate(Game game) {
        List<Ticket> tickets = new ArrayList<>(game.getPlayersCount());

        for(int i=0; i < game.getPlayersCount(); i++) {
            Ticket ticket = generateTicket(game);
            tickets.add(ticket);
        }

        return tickets;
    }

    private Ticket generateTicket(Game game) {
        // This list has all the generated numbers of the ticket.
        // In next steps i will distribute it to all rows.
        int requiredRandomNumbers = game.getNumbersPerRow() * game.getTicketRowCount();
        List<Integer> randomList = RandomNumberGenerator.generate(requiredRandomNumbers, game.getUpperBound());
        int randomListPointer = 0;
        //Create a ticket object and fill it with rows/columns
        Ticket ticket = new Ticket();
        for(int j = 0; j< game.getTicketRowCount(); j++) {
            TicketRow ticketRow = new TicketRow();
            // Create cells on the ticket with randomly generated numbers.
            for(int i = 0; i< game.getNumbersPerRow(); i++) {
                TicketCell ticketCell = new TicketCell(randomList.get(randomListPointer));
                ticketRow.addTicketCell(ticketCell);
                randomListPointer++;
            }
            // Fill the ticket row with empty(or 0) cells.
            for(int k = game.getNumbersPerRow(); k< game.getTicketColCount(); k++) {
                TicketCell ticketCell = new TicketCell(0);
                ticketRow.addTicketCell(ticketCell);
            }
            Collections.shuffle(ticketRow.getTicketCells());
            //Add row to ticket./**/
            ticket.addRow(ticketRow);
        }
        return ticket;
    }
}
