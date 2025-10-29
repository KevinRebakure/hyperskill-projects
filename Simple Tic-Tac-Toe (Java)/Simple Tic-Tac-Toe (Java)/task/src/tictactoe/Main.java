package tictactoe;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] row1 = input.substring(0, 3).split("");
        String[] row2 = input.substring(3, 6).split("");
        String[] row3 = input.substring(6, 9).split("");

        List<String[]> matrix = List.of(row1, row2, row3);

        System.out.println("-".repeat(9));
        for (String[] row : matrix) {
            System.out.print("| ");
            System.out.print(String.join(" ", row));
            System.out.print(" |\n");
        }

        System.out.println("-".repeat(9));

        scanner.close();
    }
}
