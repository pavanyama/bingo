package com.bingo;

import com.bingo.model.Game;

import java.util.Scanner;

public class BingoStarterMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**** Lets Play Housie *****");
        System.out.printf("Note: - Press 'Q' to quit any time.");
        System.out.printf("Enter the number range(1-n) :");
        int numberRangeMax = scanner.nextInt();
        System.out.printf("Enter Number of players playing the game.");
        int playersCount = scanner.nextInt();
        System.out.println("Enter Ticket Size :");
        String ticketSize = scanner.nextLine();
        System.out.println("Enter numbers per row:");
        int numbersPerRow = scanner.nextInt();

        Game game = Game.getInstance();
        game.init(numberRangeMax, playersCount, ticketSize, numbersPerRow);
        game.start();

        System.out.println("***Ticket Created Successfully ****");
        System.out.println("Press 'N' to generate next number.");
        boolean isGameOver = false;
        while(!isGameOver) {
            String letter = scanner.nextLine();
            if(letter.equalsIgnoreCase("N")) {
                System.out.println("Next number is: " + game.generateRandomNumber());
                isGameOver = game.play();
            }
        }
        System.out.println("***** Game Over *****");
    }
}