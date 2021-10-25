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

    private final List<Winner> winners = new ArrayList<>();
    private final List<PlayersTicket> playersTickets = new ArrayList<>();
    private final List<Integer> callerNumbers = new ArrayList<>();

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

    public void assignTicketsToPlayers(List<Ticket> tickets, List<Player> players) {
        if(tickets.size() < players.size()) {
            throw new IllegalStateException("Not enough tickets generated!");
        } else {
            for(int i=0; i<players.size(); i++) {
                Player player = players.get(i);
                Ticket ticket = tickets.get(i);
                PlayersTicket playersTicket = new PlayersTicket(player, ticket);
                addPlayersTicket(playersTicket);
            }
        }
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
