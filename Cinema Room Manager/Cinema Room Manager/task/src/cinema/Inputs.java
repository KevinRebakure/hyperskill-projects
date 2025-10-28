package cinema;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Inputs {
    private final Scanner scanner;
    private final Message message;
    private final Seats seats;
    public Inputs(Scanner scanner, Message message, Seats seats) {
        this.scanner = scanner;
        this.message = message;
        this.seats = seats;
    }

    public int chooseMenuOption() {
        boolean valid = false;
        List<Integer> validChoices = List.of(1,2,3);

        int choice = 0;

        while (!valid) {
            try {
                message.displayMenu();
                choice = scanner.nextInt();

                if (validChoices.contains(choice)) {
                    valid = true;
                } else {
                    System.out.println("Please choose from the menu:");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please choose from the menu:");
            }
        }
        return choice;
    }

    private byte readValue(String message, int min, int max) {
        System.out.println(message);
        assert scanner != null;

        byte value = 0;
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
}
