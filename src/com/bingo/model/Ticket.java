package com.bingo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 *  This class represents one ticket in one game.
 */
public class Ticket {

    private final List<TicketRow> ticketRows = new ArrayList<>();

    public void addRow(TicketRow ticketRow) {
        this.ticketRows.add(ticketRow);
    }

    public List<TicketRow> getTicketRows() {
        return ticketRows;
    }

    /* This will check every cell and return true if every cell in every row marked.*/
    public boolean areAllRowsMarked() {
        AtomicInteger count = new AtomicInteger();
        ticketRows.forEach(ticketRow -> {
            if(ticketRow.areAllCellsMarked()){
                count.incrementAndGet();
            }
        });
        return count.get() == ticketRows.size();
    }

    public void markTicketWithMatchingNumber(Integer number){
        ticketRows.forEach(ticketRows -> ticketRows.markCellsWithMatchingNumber(number));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ticketRows.forEach(ticketRow -> builder.append(ticketRow.toString()));
        return builder.toString()+"\n";
    }
}
