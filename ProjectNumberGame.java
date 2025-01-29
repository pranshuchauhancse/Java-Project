import java.util.Random;
import java.util.Scanner;

public class ProjectNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate random number between 1 and 100
        int numberToGuess = random.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        // Allow the user to guess up to 5 times
        while (attempts < 5) {
            System.out.print("Enter your guess (1 to 100): ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Correct! You've guessed the number.");
                break;
            }
        }

        // If the user didn't guess correctly within 5 attempts
        if (guess != numberToGuess) {
            System.out.println("Sorry! You've used all attempts. The correct number was " + numberToGuess);
        }

        scanner.close();
    }
}