package com.bingo.generator;

import com.bingo.generator.IGenerator;

public class TickerGenerator /*implements IGenerator*/ {

    private int numberRangeMax;
    private int count;
    private int ticketSize;
    private int numbersPerRow;

    public TickerGenerator(int rangeMax, int ticketRowCount, int numberRangeMax,
                           int ticketSize,
                           int numbersPerRow) {
        this.numberRangeMax = numberRangeMax;
        this.ticketSize = ticketSize;
        this.numbersPerRow = numbersPerRow;
    }

    public boolean generate(int count) {
        this.count = count;
        return false;
    }
}
