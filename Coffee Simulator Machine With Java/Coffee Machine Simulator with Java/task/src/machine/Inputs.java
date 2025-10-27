package machine;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

public class Inputs {
    private final Scanner readInput;

    public Inputs(Scanner readInput) {
        this.readInput = readInput;
    }

    public String chooseAction() {
        System.out.println("Write action (buy, fill, take):");
        String choice = readInput.nextLine();

        return choice;
    }

    public String chooseCoffee() {
        // choose: (1) espresso, (2) latte, (3) cappuccino
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");

        Supplier<String> choiceSwitch = () -> {
            return switch (readInput.nextLine()) {
                case "1" -> "espresso";
                case "2" -> "latte";
                case "3" -> "cappuccino";
                default -> "Invalid";
            };
        };

        String choice = choiceSwitch.get();

        return choice;
    }
}
