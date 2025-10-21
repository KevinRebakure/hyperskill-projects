package cinema;

import java.util.Scanner;

public class ReadInput {
    private int rows;
    private int seatsPerRow;
    private final Scanner scanner;

    public  ReadInput() {
        this.scanner = new Scanner(System.in);
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow() {
        System.out.println("Enter the number seats per row: ");
        seatsPerRow = scanner.nextByte();

        while (seatsPerRow <= 0 || seatsPerRow > 9) {
            System.out.println("Please enter a value between 1 and 9: ");

            seatsPerRow = scanner.nextByte();
            System.out.println();
        }

        scanner.close();
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = scanner.nextByte();
    }
}
