package cinema;

// ✅ read: number of rows
// ✅ read: number of seats in each row
// ✅ determine the ticket price
//
// CONDITIONS
// ----------
// if number of seats is not >60 - each seat $10
// in a larger room, 1st front half - each seat $10
//                   2nd back half - each seat $8
// if number of rows is odd like 9, the first half is 4, second 5
// number of rows and seats won't be greater than 9


import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Seats seats = new Seats(scanner);

        Pricing pricingModal = new Pricing(seats.getRows(), seats.getSeatsPerRow());

        int total = pricingModal.calculatePricing();

        System.out.println("Total income:");
        System.out.printf("$%d", total);

        scanner.close();
    }
}