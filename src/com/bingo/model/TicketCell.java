package com.bingo.model;

/*
* This model represents one cell(or a number) on the ticket assigned to a player.
* */

public class TicketCell {
    int value;
    boolean isCellMarked = false;

    public TicketCell(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public boolean markCell(){
        this.isCellMarked = true;
        return this.isCellMarked;
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
