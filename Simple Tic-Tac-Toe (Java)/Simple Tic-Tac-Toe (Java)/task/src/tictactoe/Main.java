package tictactoe;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static boolean xWins = false;
    private static boolean oWins = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide initial ");
        String input = scanner.nextLine();

        // rows
        List<String> row1 = List.of(input.substring(0, 3).split(""));
        List<String> row2 = List.of(input.substring(3, 6).split(""));
        List<String> row3 = List.of(input.substring(6, 9).split(""));

        // matrix
        List<List<String>> matrix = List.of(row1, row2, row3);

        System.out.println("-".repeat(9));
        for (List<String> row : matrix) {
            System.out.print("| ");
            System.out.print(String.join(" ", row));
            System.out.print(" |\n");
        }
        System.out.println("-".repeat(9));

        int countX = (int) matrix.stream().flatMap(List::stream).filter(x -> Objects.equals(x, "X")).count();
        int countO = (int) matrix.stream().flatMap(List::stream).filter(x -> Objects.equals(x, "O")).count();
        int countSpaces = (int) matrix.stream().flatMap(List::stream).filter(x -> Objects.equals(x, "_")).count();

        // Reset flags before checking
        xWins = false;
        oWins = false;

        checkRows(matrix);
        checkColumns(matrix);
        checkDiagonals(matrix);

        if (Math.abs(countX - countO) > 1) {
            System.out.println("Impossible");
            return;
        }

        if (xWins && oWins) {
            System.out.println("Impossible");
            return;
        }

        if (xWins) {
            System.out.println("X wins");
            return;
        }

        if (oWins) {
            System.out.println("O wins");
            return;
        }

        if (countSpaces == 0) {
            System.out.println("Draw");
            return;
        }

        System.out.println("Game not finished");
        scanner.close();
    }

    public static void checkRows(List<List<String>> matrix) {
        for (List<String> row : matrix) {
            int xCount = 0;
            for (String cell : row) {
                if (Objects.equals(cell, "X")) xCount += 1;
                else if (Objects.equals(cell, "O")) xCount -= 1;
            }
            if (xCount == 3) {
                xWins = true;
            } else if (xCount == -3) {
                oWins = true;
            }
        }
    }

    public static void checkColumns(List<List<String>> matrix) {
        for (int col = 0; col < 3; col++) {
            int xCount = 0;
            for (int row = 0; row < 3; row++) {
                String cell = matrix.get(row).get(col);
                if (Objects.equals(cell, "X")) xCount += 1;
                else if (Objects.equals(cell, "O")) xCount -= 1;
            }
            if (xCount == 3) {
                xWins = true;
            } else if (xCount == -3) {
                oWins = true;
            }
        }
    }

    public static void checkDiagonals(List<List<String>> matrix) {
        // first diagonal
        int xCount = 0;
        for (int i = 0; i < 3; i++) {
            String cell = matrix.get(i).get(i);
            if (Objects.equals(cell, "X")) xCount += 1;
            else if (Objects.equals(cell, "O")) xCount -= 1;
        }
        if (xCount == 3) {
            xWins = true;
        } else if (xCount == -3) {
            oWins = true;
        }

        // second diagonal
        xCount = 0;
        for (int i = 0; i < 3; i++) {
            String cell = matrix.get(i).get(2 - i);
            if (Objects.equals(cell, "X")) xCount += 1;
            else if (Objects.equals(cell, "O")) xCount -= 1;
        }
        if (xCount == 3) {
            xWins = true;
        } else if (xCount == -3) {
            oWins = true;
        }
    }
}