package cinema;

import java.util.Scanner;

// 1. ✅ read rows and seats
// 2. ✅ Show seats - empty seats S, taken seats B
// 3. ✅ buy a ticket
// 4. exit


// if you buy a ticket
// [row, seat]

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Seats seats = new Seats(scanner);
        Pricing pricingModal = new Pricing(seats);

        seats.setPricingModal(pricingModal);

        Message message = new Message(pricingModal);
        Inputs inputs = new Inputs(scanner, message, seats);

        while (true) {
            switch (inputs.chooseMenuOption()) {
                case 1:
                    seats.printSeats();
                    break;
                case 2:
                    System.out.println("Buy a ticket");
                    seats.bookASeat();
                    break;
                case 3:
                    message.showStatistics();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }
}
