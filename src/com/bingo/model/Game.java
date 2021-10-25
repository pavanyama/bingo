package com.bingo.model;

import java.util.ArrayList;
import java.util.List;

/*
 * This represents the whole game.
 * This has all game configurations and players, tickets and Winner details.
 */
public class Game {

    private final int totalNumbersCountOnTicket;
    private final int upperBound;
    private final int playersCount;
    private final int ticketRowCount;
    private final int ticketColCount;
    private final int numbersPerRow;

    private List<Winner> winners = new ArrayList<>();
    private List<PlayersTicket> playersTickets = new ArrayList<>();
    private List<Integer> callerNumbers = new ArrayList<>();

    public Game(int upperBound, int playersCount, String ticketSize, int numbersPerRow) {

        this.upperBound = upperBound;
        this.playersCount = playersCount;
        this.numbersPerRow = numbersPerRow;
        String[] sizes = ticketSize.split("x");
        this.ticketRowCount = Integer.parseInt(sizes[0]);
        this.ticketColCount = Integer.parseInt(sizes[1]);
        this.totalNumbersCountOnTicket = this.ticketRowCount * this.ticketColCount;
    }

    public void addWinner(Winner winner) {
        this.winners.add(winner);
    }

    public Integer getMostRecentCallerNumber() {
        return this.callerNumbers.get(this.callerNumbers.size() - 1);
    }

    public void addPlayersTicket(PlayersTicket playersTicket) {
        this.playersTickets.add(playersTicket);
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public int getTicketRowCount() {
        return ticketRowCount;
    }

    public int getTicketColCount() {
        return ticketColCount;
    }

    public int getNumbersPerRow() {
        return numbersPerRow;
    }

    public List<PlayersTicket> getPlayersTickets() {
        return playersTickets;
    }

    public List<Integer> getCallerNumbers() {
        return callerNumbers;
    }

    public int getTotalNumbersCountOnTicket() {
        return totalNumbersCountOnTicket;
    }

    public List<Winner> getWinners() {
        return winners;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        playersTickets.forEach(playersTicket -> builder.append(playersTicket.toString()));
        return builder.toString()+"\n";
    }
}
