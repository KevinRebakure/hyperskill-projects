package cinema;

import java.util.Scanner;

public class Seats {
    private int rows;
    private int seatsPerRow;
    private final int totalSeats;
    private final Scanner scanner;

    public Seats(Scanner scanner) {
        this.scanner = scanner;
        this.rows = readValue("Enter the number of rows: ");
        this.seatsPerRow = readValue("Enter the number of seats in each row: ");
        this.totalSeats = this.rows + this.seatsPerRow;
    }

    private byte readValue(String message) {
        System.out.println(message);
        assert scanner != null;
        byte seats = scanner.nextByte();

        while (seats <= 0 || seats > 9) {
            System.out.println("Please enter a value between 1 and 9: ");

            seats = scanner.nextByte();
            System.out.println();
        }

        return seats;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        // TODO: safe guard
        this.rows = rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        // TODO: safe guard
        this.seatsPerRow = seatsPerRow;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void printSeats() {
        System.out.println("Cinema: ");
        for (int i = 0; i < 8 ; i++) {
            if (i == 0) {
                System.out.print("  ");
                for (int j = 1; j < 9; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            } else {
                System.out.println(i + " " +"S ".repeat(8));
            }
        }
    }
}
