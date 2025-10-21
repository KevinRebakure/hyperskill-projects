package cinema;

import java.util.Scanner;

public class Seats {
    private int rows;
    private int seatsPerRow;
    private final int totalSeats;
    private final Scanner scanner;
    private int selectedRowNumber;
    private int selectedSeatNumber;

    public Seats(Scanner scanner) {
        this.scanner = scanner;
        this.rows = readValue("Enter the number of rows: ", 1, 9);
        this.seatsPerRow = readValue("Enter the number of seats in each row: ", 1, 9);
        this.selectedRowNumber = readValue("Enter a row number", 1, rows);
        this.selectedSeatNumber = readValue("Enter a seat number in that row: ", 1, seatsPerRow);
        this.totalSeats = this.rows + this.seatsPerRow;
    }

    private byte readValue(String message, int min, int max) {
        System.out.println(message);
        assert scanner != null;
        byte value = scanner.nextByte();

        while (value < min || value > max) {
            System.out.printf("Please enter a value between %d and %d: %n", min, max);
            System.out.println();

            value = scanner.nextByte();
            System.out.println();
        }

        return value;
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

    public int getSelectedRowNumber() {
        return selectedRowNumber;
    }

    public int getSelectedSeatNumber() {
        return selectedSeatNumber;
    }

    public void printSeats() {
        System.out.println("Cinema: ");
        for (int i = 0; i < rows + 1 ; i++) {
            if (i == 0) {
                System.out.print("  ");
                for (int j = 1; j < seatsPerRow + 1; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            } else {
                System.out.println(i + " " +"S ".repeat(seatsPerRow));
            }
        }
    }

    public void showChosenSeat() {
        System.out.println("Cinema: ");
        for (int i = 0; i < rows + 1 ; i++) {
            if (i == 0) {
                System.out.print("  ");
                for (int j = 1; j < seatsPerRow + 1; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            } else {
                if (i == selectedRowNumber) {
                    printChosenRow(i);
                } else {
                    System.out.println(i + " " +"S ".repeat(seatsPerRow));
                }
            }
        }
    }

    private void printChosenRow(int rowNumber) {
        System.out.print(rowNumber);
        for (int i = 1; i <= seatsPerRow; i++) {
            if (i != selectedSeatNumber) {
                System.out.print(" S");
            } else {
                System.out.print(" B");
            }
        }
        System.out.println();
    }
}
