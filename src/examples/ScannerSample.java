package examples;

import java.util.Scanner;

public class ScannerSample {

    public static void main(String[] args) {

        // Create scanner
        Scanner scan = new Scanner(System.in);

        // variables
        int year;
        int numQuestions;
        String name;


        // Create Geek
        System.out.println("Please enter the geeks name: ");
        name = scan.nextLine();

        System.out.println("\nPlease enter a command or type: ");
        String option = scan.nextLine();
        System.out.println("Please enter the number of questions the geek answers: ");
        numQuestions = Integer.parseInt(scan.nextLine());


    }

}