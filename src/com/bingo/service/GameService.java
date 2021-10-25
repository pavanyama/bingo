package com.bingo.service;

import com.bingo.generator.PlayerGenerator;
import com.bingo.generator.TicketGenerator;
import com.bingo.marker.TicketMarker;
import com.bingo.model.Game;
import com.bingo.model.Player;
import com.bingo.model.PlayersTicket;
import com.bingo.model.Ticket;
import com.bingo.util.Constants;
import com.bingo.util.GameHelper;
import com.bingo.util.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This represents the whole game. This class is a singleton class.
 * TODO: Make this as a singleton. All service classes along with this.
 */
public final class GameService {

    private PlayerGenerator playerGenerator;
    private TicketGenerator ticketGenerator;
    private TicketMarker ticketMarker;
    private EvaluationService evaluationService;
    private Game game;

    public void initialize(int upperBound, int playersCount, String ticketSize, int numbersPerRow) {

        Validator.validateGameInputs(upperBound, playersCount, ticketSize, numbersPerRow);
        this.game = new Game(upperBound, playersCount, ticketSize, numbersPerRow);
        createHelpers();
        List<Ticket> tickets = ticketGenerator.generate(this.game);
        List<Player> players = playerGenerator.generate(this.game);
        assignTicketsToPlayers(tickets, players, this.game);
        System.out.println(this.game);
    }

    private void assignTicketsToPlayers(List<Ticket> tickets, List<Player> players, Game game) {
        if(tickets.size() < players.size()) {
            throw new IllegalStateException("Not enough tickets generated!");
        } else {
            for(int i=0; i<players.size(); i++) {
                Player player = players.get(i);
                Ticket ticket = tickets.get(i);
                PlayersTicket playersTicket = new PlayersTicket(player, ticket);
                game.addPlayersTicket(playersTicket);
            }
        }
    }

    private void createHelpers() {
        this.playerGenerator = new PlayerGenerator();
        this.ticketGenerator = new TicketGenerator();
        this.ticketMarker = new TicketMarker();
        this.evaluationService = new EvaluationService();
    }

    public Integer generateRandomNumber() {
        return GameHelper.generateRandomNumber(1, game);
    }

    public boolean play() {
        this.ticketMarker.markTickets(this.game);
        this.evaluationService.evaluate(this.game);
        if(this.evaluationService.isEveryEvaluationIdentifiedWinner()) {
            return true;
        } else {
            return false;
        }
    }

    public void generateSummary() {
        GameHelper.generateSummary(this.game);
    }
}
