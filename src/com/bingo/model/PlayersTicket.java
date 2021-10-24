package com.bingo.model;

public class PlayersTicket {

    private Ticket ticket;
    private Player player;

    public PlayersTicket(Player player, Ticket ticket) {
        this.player = player;
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
