package cinema;

import java.util.Scanner;

//☑️ read number of rows
// ️☑️ read number of seats in each row

// ✅ read row number
// ✅ read seat number

// same rules as the previous task

// PROGRAM FLOW
// -------------
// 1. ✅ Print out all seats in the room
// 2. ✅ Mark the chosen seat with B symbol
// 3. ✅ Print ticket price


// CONDITIONS
// ----------
// if number of seats is not >60 - each seat $10
// in a larger room, 1st front half - each seat $10
//                   2nd back half - each seat $8
// if number of rows is odd like 9, the first half is 4, second 5
// number of rows and seats won't be greater than 9

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Seats seats = new Seats(scanner);
        Pricing pricingModal = new Pricing(seats.getRows(), seats.getSeatsPerRow());

        seats.printSeats();
        System.out.println();

        int ticketPrice = pricingModal.ticketPrice(seats.getSelectedRowNumber());
        System.out.printf("Ticket price: $%d", ticketPrice);
        System.out.println();
        System.out.println();

        seats.showChosenSeat();

        scanner.close();
    }
}