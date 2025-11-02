package tictactoe;

import java.util.*;
import java.util.Objects;

public class Main {
    private static boolean xWins = false;
    private static boolean oWins = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // empty rows
        List<String> row1 = Arrays.asList("_", "_", "_");
        List<String> row2 = Arrays.asList("_", "_", "_");
        List<String> row3 = Arrays.asList("_", "_", "_");

        // matrix
        List<List<String>> matrix = List.of(row1, row2, row3);

        printMatrix(matrix);

        char currentPlayer = 'X';
        boolean gameNotFinished = true;

        while (gameNotFinished) {
            System.out.print("Enter the coordinates: ");
            getInput(matrix, scanner, currentPlayer);
            printMatrix(matrix);

            int countX = (int) matrix.stream().flatMap(List::stream).filter(x -> Objects.equals(x, "X")).count();
            int countO = (int) matrix.stream().flatMap(List::stream).filter(x -> Objects.equals(x, "O")).count();
            int countSpaces = (int) matrix.stream().flatMap(List::stream).filter(x -> Objects.equals(x, "_")).count();

            // Reset flags before checking
            xWins = false;
            oWins = false;

            checkRows(matrix);
            checkColumns(matrix);
            checkDiagonals(matrix);

            if (Math.abs(countX - countO) > 1 || (xWins && oWins)) {
                System.out.println("Impossible");
                gameNotFinished = false;
            } else if (xWins) {
                System.out.println("X wins");
                gameNotFinished = false;
            } else if (oWins) {
                System.out.println("O wins");
                gameNotFinished = false;
            } else if (countSpaces == 0) {
                System.out.println("Draw");
                gameNotFinished = false;
            }

            if (gameNotFinished) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    public static void getInput(List<List<String>> matrix, Scanner scanner, char player) {
        boolean placed = false;
        while (!placed) {
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                String selectedCell = matrix.get(x - 1).get(y - 1);

                if (!selectedCell.equals("_")) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                matrix.get(x - 1).set(y - 1, String.valueOf(player));
                placed = true;
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
    }

    public static void printMatrix(List<List<String>> matrix) {
        System.out.println("-".repeat(9));
        for (List<String> row : matrix) {
            System.out.print("| ");
            System.out.print(String.join(" ", row));
            System.out.print(" |\n");
        }
        System.out.println("-".repeat(9));
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