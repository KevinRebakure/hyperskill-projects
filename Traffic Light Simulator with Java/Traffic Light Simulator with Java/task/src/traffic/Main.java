package traffic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);

        Messages.welcome();
        int roads = input.readValue("Input the number of roads: ");
        int interval = input.readValue("Input the interval: ");

        input.clear();  // Clear after initial input
        Messages.displayMenu();
        int option = input.readOption("");

        while (option != 0) {
            switch (option) {
                case 1:
                    System.out.println("Road added");
                    break;
                case 2:
                    System.out.println("Road deleted");
                    break;
                case 3:
                    System.out.println("System opened");
                    break;
                default:
                    System.out.println("Incorrect option. Try again.");
            }

            scanner.nextLine();
            input.clear();
            Messages.displayMenu();
            option = input.readOption("");
        }
        System.out.print("Bye!");
    }
}