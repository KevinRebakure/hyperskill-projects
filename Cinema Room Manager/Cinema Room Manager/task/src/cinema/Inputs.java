package cinema;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Inputs {
    private final Scanner scanner;
    private final Message message;
    public Inputs(Scanner scanner, Message message) {
        this.scanner = scanner;
        this.message = message;
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
}
