package cinema;

import java.util.*;

public class Seats {
    private int rows;
    private int seatsPerRow;
    private final int totalSeats;
    private final Scanner scanner;
    private int selectedRowNumber;
    private int selectedSeatNumber;
    // Mapping rows to seats. 1 -> [1,2,3,4,5]
    // This means row 1 has seats: 1,2,3,4,5
    private static final Map<Integer, ArrayList<Integer>> seats = new HashMap<>();
    private Pricing pricingModal;


    public Seats(Scanner scanner) {
        this.scanner = scanner;
        this.rows = readValue("Enter the number of rows: ", 1, 9);
        this.seatsPerRow = readValue("Enter the number of seats in each row: ", 1, 9);
        this.totalSeats = this.rows + this.seatsPerRow;
    }

    private int readValue(String message, int min, int max) {
        System.out.println(message);
        assert scanner != null;

        int value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                value = scanner.nextByte();

                if (value >= min || value <= max) {
                    valid = true;
                } else {
                    System.out.printf("Please enter a value between %d and %d: %n", min, max);
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.printf("Please enter a value between %d and %d: %n", min, max);
            }
        }

        return value;
    }

    public void printSeats() {
        System.out.println("Cinema: ");

        for (int i = 0; i < rows + 1 ; i++) {
            if (i == 0) {
                printHeader();
            } else {
                System.out.printf(i + " ");
                printRowSeats(i);
            }
        }
        System.out.println();
    }

    private void printRowSeats(int i) {
        var currentRow = getSeats().get(i);

        if (currentRow != null) {
            for (int j = 1; j <= seatsPerRow; j++) {
                if (currentRow.contains(j)) {
                    System.out.print("B ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        } else {
            System.out.println("S ".repeat(seatsPerRow));
        }
    }

    private void printHeader() {
        System.out.print("  ");
        for (int j = 1; j < seatsPerRow + 1; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
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

    public void bookASeat(){
        // 1 -> [1,2,4]
        // 2 -> [1,3,4]

        // ✅ check if the seat is available
        // ✅ save a seat
        // show ticket price
        // show seats (available and unavailable seats)

        int rowNumber = readValue("Enter row number: ", 1, rows);
        int seatNumber =  readValue("Enter a seat number in that row: ", 1, seatsPerRow);

        if (getSeats().containsKey(rowNumber)) {
            List<Integer> seatsInSelectedRow = getSeats().get(rowNumber);

            if (seatsInSelectedRow.contains(seatNumber)) {
                System.out.println("Seat was already taken!");
            } else {
                seatsInSelectedRow.add(seatNumber);
            }
        } else {
            getSeats().put(rowNumber, new ArrayList<>(List.of(seatNumber)));
        }

        if (pricingModal == null) {
            throw new IllegalStateException("Pricing model not initialized. Call setPricing() first.");
        }

        System.out.printf("Ticket price: $%d", pricingModal.ticketPrice(rowNumber));
        System.out.println();
    }

    public Map<Integer, ArrayList<Integer>> getSeats() {
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

    public int getSelectedRow() {
        return selectedRowNumber;
    }

    public int getSelectedSeat() {
        return selectedSeatNumber;
    }

    public void selectARow() {
        this.selectedRowNumber = readValue("Enter a row number:", 1, rows);
    }

    public void selectASeat() {
        this.selectedSeatNumber = readValue("Enter a seat number in that row:", 1, seatsPerRow);
    }

    public void setPricingModal(Pricing pricingModal) {
        this.pricingModal = pricingModal;
    }
}