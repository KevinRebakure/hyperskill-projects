package machine;

import java.util.Arrays;
import java.util.Scanner;

public class Inputs {
    private final Scanner readInput;

    public Inputs(Scanner readInput) {
        this.readInput = readInput;
    }

    public String chooseAction() {
        System.out.println("Write action (buy, fill, take):");
        String choice = readInput.nextLine();
        String[] validChoices = {"buy", "fill", "take"};

        boolean isValid = Arrays.asList(validChoices).contains(choice);

        while (!isValid) {
            System.out.println("Please choose between (buy, fill, take):");

            String anotherChoice = readInput.nextLine();
            choice = readInput.nextLine();

            isValid = Arrays.asList(validChoices).contains(anotherChoice);
        }

        return choice;
    }

    public String chooseCoffee() {
        // choose: (1) espresso, (2) latte, (3) cappuccino
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String choice = switch (readInput.next()) {
            case "1" -> "espresso";
            case "2" -> "latte";
            case "3" -> "cappuccino";
            default -> "Invalid";
        };

        while (choice.equals("Invalid")) {
            choice = switch (readInput.next()) {
                case "1" -> "espresso";
                case "2" -> "latte";
                case "3" -> "cappuccino";
                default -> "Invalid";
            };
        }

        return choice;
    }
}
