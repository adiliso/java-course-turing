package az.edu.turing.module01.lessonZ;

import java.util.Random;
import java.util.Scanner;

public class ShootingAtTheSquare {
    char[][] matrix;
    boolean gameWon;
    int targetRow;
    int targetColumn;
    Random random = new Random();

    public ShootingAtTheSquare() {
        matrix = new char[5][5];
        gameWon = false;
        targetRow = random.nextInt(5);
        targetColumn = random.nextInt(5);
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
        targetRow = random.nextInt(3);
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
        if (row == targetRow && column == targetColumn) {
            matrix[row][column] = 'x';
            return true;
        } else {
            matrix[row][column] = '*';
        }
        return false;
    }


    private boolean checkPotentialWin(int row, int column, boolean isHorizontal) {
        if (isHorizontal) {
            if ((row >= targetRow && row <= targetRow + 2) && column == targetColumn) {
                matrix[targetColumn][targetRow] = 'x';
                matrix[targetColumn][targetRow + 1] = 'x';
                matrix[targetColumn][targetRow + 2] = 'x';
                return true;
            } else {
                matrix[row][column] = '*';
            }
        } else {
            if (row == targetColumn && (column >= targetRow && column <= targetRow + 2)) {
                matrix[targetRow][targetColumn] = 'x';
                matrix[targetRow + 1][targetColumn] = 'x';
                matrix[targetRow + 2][targetColumn] = 'x';
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
