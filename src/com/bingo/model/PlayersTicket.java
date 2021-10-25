package com.bingo.model;

/*
 * This class represents a combination of player and ticket in one game.
 */
public class PlayersTicket {

    private final Ticket ticket;
    private final Player player;

    public PlayersTicket(Player player, Ticket ticket) {
        this.player = player;
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "Player: " + player.toString() +
                "\nTicket=" + ticket.toString();
    }
}
