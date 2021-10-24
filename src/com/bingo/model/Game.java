package com.bingo.model;

import java.util.List;

public class Game {


    private int upperBound;
    private int playersCount;
    private int ticketRowCount;
    private int ticketColCount;
    private int numbersPerRow;

    private List<Winner> winners;
    private List<Ticket> tickets;
    private List<Player> players;

    public Game(int upperBound, int playersCount, String ticketSize, int numbersPerRow) {

        this.upperBound = upperBound;
        this.playersCount = playersCount;
        this.numbersPerRow = numbersPerRow;
        populateRowsAndColumnsCount(ticketSize);
    }

    private void populateRowsAndColumnsCount(String ticketSize) {
        String[] sizes = ticketSize.split("X");
        this.ticketRowCount = Integer.parseInt(sizes[0]);
        this.ticketColCount = Integer.parseInt(sizes[1]);
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public void setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
    }

    public int getTicketRowCount() {
        return ticketRowCount;
    }

    public void setTicketRowCount(int ticketRowCount) {
        this.ticketRowCount = ticketRowCount;
    }

    public int getTicketColCount() {
        return ticketColCount;
    }

    public void setTicketColCount(int ticketColCount) {
        this.ticketColCount = ticketColCount;
    }

    public int getNumbersPerRow() {
        return numbersPerRow;
    }

    public void setNumbersPerRow(int numbersPerRow) {
        this.numbersPerRow = numbersPerRow;
    }

    public List<Winner> getWinners() {
        return winners;
    }

    public void setWinners(List<Winner> winners) {
        this.winners = winners;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
