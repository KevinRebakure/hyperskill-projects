package traffic;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readValue(String message) {
        System.out.print(message);
        int value = scanner.nextInt();
        return value;
    }
}
