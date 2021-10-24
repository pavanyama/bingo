package com.bingo.model;

import java.util.ArrayList;
import java.util.List;

public class Game {


    private final int totalNumbersCountOnTicket;
    private final int upperBound;
    private final int playersCount;
    private final int ticketRowCount;
    private final int ticketColCount;
    private final int numbersPerRow;

    private List<Winner> winners;
    private List<Ticket> tickets;
    private List<Player> players;
    private List<PlayersTicket> playersTickets = new ArrayList<>();
    private List<Integer> callerNumbers = new ArrayList<>();

    public Game(int upperBound, int playersCount, String ticketSize, int numbersPerRow) {

        this.upperBound = upperBound;
        this.playersCount = playersCount;
        this.numbersPerRow = numbersPerRow;
        String[] sizes = ticketSize.split("X");
        this.ticketRowCount = Integer.parseInt(sizes[0]);
        this.ticketColCount = Integer.parseInt(sizes[1]);
        this.totalNumbersCountOnTicket = this.ticketRowCount * this.ticketColCount;
    }

    private void populateRowsAndColumnsCount(String ticketSize) {

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

    public List<Winner> getWinners() {
        return winners;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addPlayersTicket(PlayersTicket playersTicket) {
        this.playersTickets.add(playersTicket);
    }

    public void addCallerNumber(Integer callerNumber) {
        this.callerNumbers.add(callerNumber);
    }

    public Integer getMostRecentCallerNumber() {
        return this.callerNumbers.get(this.callerNumbers.size() - 1);
    }

    public List<PlayersTicket> getPlayersTickets() {
        return playersTickets;
    }

    public void setPlayersTickets(List<PlayersTicket> playersTickets) {
        this.playersTickets = playersTickets;
    }

    public List<Integer> getCallerNumbers() {
        return callerNumbers;
    }

    public void setCallerNumbers(List<Integer> callerNumbers) {
        this.callerNumbers = callerNumbers;
    }

    public int getTotalNumbersCountOnTicket() {
        return totalNumbersCountOnTicket;
    }

    public void addWinner(Winner winner) {
        this.winners.add(winner);
    }
}
