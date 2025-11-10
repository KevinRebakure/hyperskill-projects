package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public int selectOption() throws RuntimeException {
        int option = Integer.parseInt(scanner.nextLine());

        List<Integer> validOptions = List.of(1,2,0);
        if (!validOptions.contains(option))
            throw new IllegalArgumentException();

        return option;
    }
}
