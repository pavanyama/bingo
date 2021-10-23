package com.bingo.model;

import com.bingo.generator.IGenerator;
import com.bingo.generator.TickerGenerator;
import com.bingo.util.Validator;

import java.util.List;

/*
 * This represents the whole game. This class is a singleton class.
 */
public class Game {

    private static Game game;
    private int numberRangeMax;
    private int playersCount;
    private int ticketRowCount;
    private int ticketColCount;
    private int numbersPerRow;
    private String ticketSize;

    private List<Winner> winners;
    private List<Ticket> tickets;
    private List<Player> players;

    private Game() { }

    public Game init(int numberRangeMax, int playersCount, String ticketSize, int numbersPerRow) {
        Validator.validateInputs(numberRangeMax, playersCount, ticketSize, numbersPerRow);

        this.numberRangeMax = numberRangeMax;
        this.playersCount = playersCount;
        this.numbersPerRow = numbersPerRow;
        populateRowsAndColumnsCount(ticketSize);
        return game;
    }

    private void populateRowsAndColumnsCount(String ticketSize) {
        String[] sizes = ticketSize.split("X");
        this.ticketRowCount = Integer.parseInt(sizes[0]);
        this.ticketColCount = Integer.parseInt(sizes[1]);
    }

    public static Game getInstance() {
        return game;
    }

    public void start() {
        // I wouldn't use builder pattern here as only 4 params,
        // all these values are available and these are mandatory for generator.
        TickerGenerator generator = new TickerGenerator(numberRangeMax, ticketRowCount, ticketColCount,
                playersCount, numbersPerRow);
        generator.generate(playersCount);
    }

    public int generateRandomNumber() {
        return 1;
    }

    public boolean play() {
        return true;
    }
}
