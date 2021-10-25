package com.bingo.model;

/*
* This model represents one cell(or a number) on the ticket assigned to a player.
* */

public class TicketCell {
    private final int value;
    private boolean isCellMarked = false;

    public TicketCell(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public void markCell(){
        this.isCellMarked = true;
    }

    public boolean isCellMarked() {
        return isCellMarked;
    }

    /* Adding a quote if a cell is marked*/
    @Override
    public String toString() {
        if(isCellMarked)
            return value +"' " ;
        else
            return value + " ";
    }
}
