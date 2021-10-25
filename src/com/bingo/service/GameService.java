package com.bingo.service;

import com.bingo.generator.PlayerGenerator;
import com.bingo.generator.TicketGenerator;
import com.bingo.marker.TicketMarker;
import com.bingo.model.Game;
import com.bingo.model.Player;
import com.bingo.model.Ticket;
import com.bingo.util.GameHelper;
import com.bingo.util.Validator;

import java.util.List;
import java.util.Scanner;

/*
 * This represents the whole game. This class is a singleton class.
 */
public final class GameService {

    private final PlayerGenerator playerGenerator = new PlayerGenerator();
    private final TicketGenerator ticketGenerator = new TicketGenerator();
    private final TicketMarker ticketMarker = new TicketMarker();
    private final EvaluationService evaluationService = new EvaluationService();

    public void playGame(int upperBound, int playersCount, String ticketSize, int numbersPerRow) {

        Validator.validateGameInputs(upperBound, playersCount, ticketSize, numbersPerRow);

        Game game = initiateGame(upperBound, playersCount, ticketSize, numbersPerRow);
        playGame(game);
        summarizeGame(game);
    }


    private Game initiateGame(int upperBound, int playersCount, String ticketSize, int numbersPerRow) {
        //Create a game instance
        Game game = new Game(upperBound, playersCount, ticketSize, numbersPerRow);
        //Generate tickets for the game.
        List<Ticket> tickets = ticketGenerator.generate(game);

        //Generate players for the game.
        List<Player> players = playerGenerator.generate(game);

        //Distribute tickets to players.
        game.assignTicketsToPlayers(tickets, players);

        System.out.println(game);
        System.out.println("***Ticket Created Successfully ****");
        return game;
    }

    private void playGame(Game game) {
        System.out.println("Press 'N' to generate next number.");

        Scanner scanner = new Scanner(System.in);
        boolean isGameOver = false;
        while(!isGameOver) {
            String letter = scanner.nextLine();
            if(letter.equalsIgnoreCase("N")) {
                Integer randomNumber = GameHelper.generateRandomNumber(1, game);
                System.out.println("Next number is: " + randomNumber);

                this.ticketMarker.markTickets(game);
                this.evaluationService.evaluate(game);
                isGameOver = this.evaluationService.isEveryEvaluationIdentifiedWinner();

            } else if(letter.equalsIgnoreCase("Q")) {
                System.exit(1);
            }
        }
        System.out.println("***** Game Over *****");
    }

    private void summarizeGame(Game game) {
        GameHelper.generateSummary(game);
    }
}
