package com.bingo.model;

import java.util.List;

/*
 *  This class represents a generated and assigned ticket to a player.
 */
public class Ticket {

    List<List<TicketCell>> ticketCells;

    public void addRow(List<TicketCell> ticketRow) {
        this.ticketCells.add(ticketRow);
    }

    public List<List<TicketCell>> getTicketCells() {
        return ticketCells;
    }

    public void setTicketCells(List<List<TicketCell>> ticketCells) {
        this.ticketCells = ticketCells;
    }
}
