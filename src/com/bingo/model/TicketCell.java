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

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isCellMarked() {
        return isCellMarked;
    }

    public void setCellMarked(boolean cellMarked) {
        isCellMarked = cellMarked;
    }
}
