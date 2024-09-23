package az.edu.turing.module01.lessonZ;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
    private final int[] guessedNumbers = new int[101];
    private int k = 0;

    public void start() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int target = rand.nextInt(101);
        System.out.print("Please, enter your name: ");
        String name = sc.nextLine();
        System.out.println("Let the game begin!");
        while (true) {
            if (k == 100) {
                System.out.println("You guessed a lot!!!");
                return;
            }
            int guess = guessNumber();
            if (guess == target) {
                System.out.println("Congratulations, " + name);
                break;
            } else if (guess < target) {
                System.out.println("Your number is too small. Please, try again.");
            } else {
                System.out.println("Your number is too big. Please, try again.");
            }
        }
        sortAndPrintArray();
    }

    private void sortAndPrintArray() {
        Arrays.sort(guessedNumbers, 0, k);
        System.out.print("Your numbers: ");
        for (int i = k - 1; i >= 0; i--) {
            System.out.print(guessedNumbers[i] + " ");
        }
    }

    private int guessNumber() {
        Scanner sc = new Scanner(System.in);
        int guess;
        while (true) {
            System.out.print("Enter your guess: ");
            if (sc.hasNextInt()) {
                guess = sc.nextInt();
                break;
            } else {
                System.out.println("Invalid guess! Please try again!");
                sc.nextLine();
            }
        }
        guessedNumbers[k++] = guess;
        return guess;
    }

}
