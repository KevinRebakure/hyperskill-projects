package traffic;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readValue(String message) {
        System.out.print(message);
        int value = 0;

        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine());

                if (value < 1) {
                    System.out.print("Error! Incorrect Input. Try again: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Error! Incorrect Input. Try again: ");
            }
        }
        return value;
    }

    public int readOption(String message) {
        System.out.print(message);
        int value = -1;  // Default invalid value

        try {
            value = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Just return -1, let Main handle the error message
        }

        return value;
    }

    public void clear() {
        try {
            var clearCommand = System.getProperty("os.name").contains("Windows")
                    ? new ProcessBuilder("cmd", "/c", "cls")
                    : new ProcessBuilder("clear");
            clearCommand.inheritIO().start().waitFor();
        }
        catch (IOException | InterruptedException e) {}
    }
}