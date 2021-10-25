package com.bingo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketRow {
    private final List<TicketCell> ticketCells = new ArrayList<>();

    public void addTicketCell(TicketCell ticketCell){
        this.ticketCells.add(ticketCell);
    }

    public List<TicketCell> getTicketCells() {
        return ticketCells;
    }
    /* This will check every cell and return true if every cell is marked.*/
    public boolean areAllCellsMarked() {
        AtomicInteger count = new AtomicInteger();
        ticketCells.forEach(ticketCell -> {
            if(ticketCell.isCellMarked() || ticketCell.getValue() ==0){
                count.incrementAndGet();
            }
        });
        return count.get() == ticketCells.size();
    }

    public void markCellsWithMatchingNumber(Integer number){
        ticketCells.forEach(ticketCell -> {
            if(Objects.equals(ticketCell.getValue(), number)){
                ticketCell.markCell();
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ticketCells.forEach(ticketCell -> builder.append(ticketCell.toString()));
        return builder.toString()+"\n";
    }
}
