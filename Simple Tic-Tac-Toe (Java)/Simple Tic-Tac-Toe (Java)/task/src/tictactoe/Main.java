package tictactoe;

import java.util.*;
import java.util.Objects;

public class Main {
    private static boolean xWins = false;
    private static boolean oWins = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        // rows
        List<String> row1 = Arrays.asList(input.substring(0, 3).split(""));
        List<String> row2 = Arrays.asList(input.substring(3, 6).split(""));
        List<String> row3 = Arrays.asList(input.substring(6, 9).split(""));

        // matrix
        List<List<String>> matrix = List.of(row1, row2, row3);

        printMatrix(matrix);

        System.out.print("Enter the coordinates: ");
        getInput(matrix, scanner);

        printMatrix(matrix);

        /* Commented out for this stage - will be used in final stage
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
        */
        scanner.close();
    }

    public static void getInput(List<List<String>> matrix, Scanner scanner) {
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

                matrix.get(x - 1).set(y - 1, "X");
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