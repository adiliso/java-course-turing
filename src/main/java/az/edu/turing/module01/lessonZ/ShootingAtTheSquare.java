package az.edu.turing.module01.lessonZ;

import java.util.Random;
import java.util.Scanner;

public class ShootingAtTheSquare {
    char[][] matrix = new char[5][5];
    Random random = new Random();
    int n = random.nextInt(5);
    int m = random.nextInt(5);

    public void startDefaultGame() {
        generateDefaultValue(); // assign all matrix to '-'
        System.out.println("All set. Get ready to rumble!");
        while (true) {
            int a, b;
            a = guess("row");
            b = guess("column");
            if (a == n && b == m) {
                System.out.println("You have won!");
                matrix[a][b] = 'x';
                printMatrix();
                break;
            } else {
                System.out.println("Try again");
                matrix[a][b] = '*';
                printMatrix();
            }
        }
    }

    public void startAdvancedGame() {
        generateDefaultValue();
        boolean isHorizontal = random.nextBoolean();
        n = random.nextInt(3);
        System.out.println("All set. Get ready to rumble!");
        while (true) {
            int a, b;
            a = guess("row");
            b = guess("column");
            if (isHorizontal) {
                if ((a >= n && a <= n + 2) && b == m) {
                    matrix[m][n] = 'x';
                    matrix[m][n + 1] = 'x';
                    matrix[m][n + 2] = 'x';
                    System.out.println("You have won!");
                    printMatrix();
                    break;
                } else {
                    System.out.println("Try again");
                    matrix[a][b] = '*';
                    printMatrix();
                }
            } else {
                if (a == m && (b >= n && b <= n + 2)) {
                    matrix[n][m] = 'x';
                    matrix[n + 1][m] = 'x';
                    matrix[n + 2][m] = 'x';
                    System.out.println("You have won!");
                    printMatrix();
                    break;
                } else {
                    System.out.println("Try again");
                    matrix[a][b] = '*';
                    printMatrix();
                }
            }
        }
    }

    private void generateDefaultValue() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = '-';
            }
        }
    }

    private boolean notValid(int n) {
        return n < 0 || n > 4;
    }

    private int guess(String type) {
        Scanner sc = new Scanner(System.in);
        int a;
        do {
            System.out.printf("Enter the shooting %s (1-5): ", type);
            a = sc.nextInt() - 1;
        } while (notValid(a));
        return a;
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
