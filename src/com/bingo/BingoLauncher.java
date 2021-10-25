package com.bingo;

import com.bingo.service.GameService;

import java.util.Scanner;

public class BingoLauncher {

    public static void main(String[] args) {
/*
        int numberRangeMax = 25;
        int playersCount = 3;
        String ticketSize = "3x8";
        int numbersPerRow = 5;
*/
        Scanner scanner = new Scanner(System.in);

        System.out.println("**** Lets Play Housie *****");
        System.out.print("Note: - Press 'Q' to quit any time.");
        System.out.print("Enter the number range(1-n) :");
        int numberRangeMax = scanner.nextInt();
        System.out.print("Enter Number of players playing the game.");
        int playersCount = scanner.nextInt();
        scanner.nextLine(); // To swallow enter button.
        System.out.println("Enter Ticket Size :");
        String ticketSize = scanner.nextLine();
        System.out.println("Enter numbers per row:");
        int numbersPerRow = scanner.nextInt();

        //Create a service instance and launch game.
        GameService gameService = new GameService();
        gameService.playGame(numberRangeMax, playersCount, ticketSize, numbersPerRow);

    }
}