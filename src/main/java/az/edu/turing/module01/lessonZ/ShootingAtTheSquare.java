package az.edu.turing.module01.lessonZ;

import java.util.Random;
import java.util.Scanner;

public class ShootingAtTheSquare {
    char[][] matrix;
    boolean gameWon;
    int n;
    int m;
    Random random = new Random();

    public ShootingAtTheSquare() {
        matrix = new char[5][5];
        gameWon = false;
        n = random.nextInt(5);
        m = random.nextInt(5);
        initializeBoard();
    }

    public void startDefaultGame() { // assign all matrix to '-'
        System.out.println("All set. Get ready to rumble!");
        while (!gameWon) {
            int row = guess("row") - 1;
            int column = guess("column") - 1;
            gameWon = checkPotentialWin(row, column);
            if (gameWon) {
                System.out.println("You have won!");
                printMatrix();
            } else {
                System.out.println("Try again");
                printMatrix();
            }
        }
    }

    public void startAdvancedGame() {
        boolean isHorizontal = random.nextBoolean();
        n = random.nextInt(3);
        System.out.println("All set. Get ready to rumble!");
        while (!gameWon) {
            int row = guess("row") - 1;
            int column = guess("column") - 1;
            gameWon = checkPotentialWin(row, column, isHorizontal);
            if (gameWon) {
                System.out.println("You have won!");
                printMatrix();
            } else {
                System.out.println("Try again");
                printMatrix();
            }
        }
    }

    private boolean checkPotentialWin(int row, int column) {
        if (row == n && column == m) {
            matrix[row][column] = 'x';
            return true;
        } else {
            matrix[row][column] = '*';
        }
        return false;
    }


    private boolean checkPotentialWin(int row, int column, boolean isHorizontal) {
        if (isHorizontal) {
            if ((row >= n && row <= n + 2) && column == m) {
                matrix[m][n] = 'x';
                matrix[m][n + 1] = 'x';
                matrix[m][n + 2] = 'x';
                return true;
            } else {
                matrix[row][column] = '*';
            }
        } else {
            if (row == m && (column >= n && column <= n + 2)) {
                matrix[n][m] = 'x';
                matrix[n + 1][m] = 'x';
                matrix[n + 2][m] = 'x';
                return true;
            } else {
                matrix[row][column] = '*';
            }
        }
        return false;
    }

    private void initializeBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = '-';
            }
        }
    }

    private boolean notValid(int n) {
        return n < 1 || n > 5;
    }

    private int guess(String type) {
        Scanner sc = new Scanner(System.in);
        int a;
        while (true) {
            System.out.printf("Enter the shooting %s (1-5): ", type);
            if (sc.hasNextInt()) {
                a = sc.nextInt();
            } else {
                System.out.println("Please enter an integer!");
                sc.nextLine();
                continue;
            }
            if (notValid(a)) {
                System.out.println("Please enter an integer between 1 and 5!");
            } else return a;
        }
    }

    private void printMatrix() {
        for (int i = 0; i <= 5; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print(i + 1 + " | ");
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
