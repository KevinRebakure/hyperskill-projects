package tictactoe;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        // rows
        List<String> row1 = List.of(input.substring(0, 3).split(""));
        List<String> row2 = List.of(input.substring(3, 6).split(""));
        List<String> row3 = List.of(input.substring(6, 9).split(""));

        // columns
        List<String> col1 = List.of(row1.getFirst(), row2.getFirst(), row3.getFirst());
        List<String> col2 = List.of(row1.get(1), row2.get(1), row3.get(1));
        List<String> col3 = List.of(row1.getLast(), row2.getLast(), row3.getLast());

        // diagonals
        List<String> diag1 = List.of(row1.getFirst(), row2.get(1), row3.getLast());
        List<String> diag2 = List.of(row1.getLast(), row2.get(1), row3.getFirst());

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
        int countY = (int) matrix.stream().flatMap(List::stream).filter(x -> Objects.equals(x, "O")).count();
        int countSpaces = (int) matrix.stream().flatMap(List::stream).filter(x -> Objects.equals(x, "_")).count();

        if (Math.abs(countX - countY) > 1 ) {
            System.out.println("Impossible");
            return;
        }

        // check winners
        List<String> rowWinner = checkRowOrColumn(row1, row2, row3);
        List<String> colWinner = checkRowOrColumn(col1, col2, col3);
        List<String> diagonalWinner = checkDiagonal(diag1, diag2);

        if (rowWinner.size() > 1 || colWinner.size() > 1) {
            System.out.println("Impossible");
            return;
        }

        if (rowWinner.size() == 1) {
            System.out.println(rowWinner.getFirst() + " wins");
            return;
        }

        if (colWinner.size() == 1) {
            System.out.println(colWinner.getFirst() + " wins");
            return;
        }

        if (diagonalWinner.size() == 1) {
            System.out.println(diagonalWinner.getFirst() + " wins");
            return;
        }

        if (countSpaces == 0) {
            System.out.println("Draw");
            return;
        }

        if (countSpaces > 0) {
            System.out.println("Game not finished");
            return;
        }

        scanner.close();
    }

    public static List<String> checkRowOrColumn (List<String> row1, List<String> row2, List<String> row3) {
        List<String> winner = new ArrayList<>();
        if ((Objects.equals(row1.get(0), row1.get(1))) && (Objects.equals(row1.get(0), row1.get(2)))) {
            winner.add(row1.getFirst());
        }

        if ((Objects.equals(row2.get(0), row2.get(1))) && (Objects.equals(row2.get(0), row2.get(2)))) {
            winner.add(row2.getFirst());
        }

        if ((Objects.equals(row3.get(0), row3.get(1))) && (Objects.equals(row3.get(0), row3.get(2)))) {
            winner.add(row3.getFirst());
        }

        return winner;
    }

    public static List<String> checkDiagonal (List<String> row1, List<String> row2) {
        List<String> winner = new ArrayList<>();
        if ((Objects.equals(row1.get(0), row1.get(1))) && (Objects.equals(row1.get(0), row1.get(2)))) {
            winner.add(row1.getFirst());
        }

        if ((Objects.equals(row2.get(0), row2.get(1))) && (Objects.equals(row2.get(0), row2.get(2)))) {
            winner.add(row2.getFirst());
        }

        return winner;
    }
}
