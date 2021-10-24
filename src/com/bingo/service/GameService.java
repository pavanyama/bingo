package com.bingo.service;

import com.bingo.evaluators.EvaluationEngine;
import com.bingo.generator.PlayerGenerator;
import com.bingo.generator.RandomNumberGenerator;
import com.bingo.generator.TickerGenerator;
import com.bingo.marker.impl.TicketMarker;
import com.bingo.model.Game;
import com.bingo.util.Validator;

/*
 * This represents the whole game. This class is a singleton class.
 * TODO: Make this as a singleton. All service classes along with this.
 */
public class GameService {


    private PlayerGenerator playerGenerator;
    private TickerGenerator tickerGenerator;
    private TicketMarker ticketMarker;
    private RandomNumberGenerator randomNumberGenerator;
    private EvaluationEngine evaluationEngine;
    private Game game;

    public GameService() { }

    public void initialize(int upperBound, int playersCount, String ticketSize, int numbersPerRow) {

        Validator.validateGame(upperBound, playersCount, ticketSize, numbersPerRow);

        this.game = new Game(upperBound, playersCount, ticketSize, numbersPerRow);
        createHelpers();

        tickerGenerator.generateAndPopulate(this.game);
        playerGenerator.generateAndPopulate(this.game);
    }

    private void createHelpers() {
        this.playerGenerator = new PlayerGenerator();
        this.tickerGenerator = new TickerGenerator();
        this.ticketMarker = new TicketMarker();
        this.randomNumberGenerator = new RandomNumberGenerator(this.game);
        this.evaluationEngine = new EvaluationEngine();
    }

    public Integer generateRandomNumber() {
        return this.randomNumberGenerator.generate();
    }

    public boolean play() {
        this.ticketMarker.markTickets(this.game);
        this.evaluationEngine.evaluate();
        return true;
    }
}
