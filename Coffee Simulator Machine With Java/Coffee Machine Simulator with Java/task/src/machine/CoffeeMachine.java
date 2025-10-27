package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static final int mlOfWaterPerCup = 200;
    static final int mlOfMilkPerCup = 50;
    static final int gOfCoffeeBeansPerCup = 15;

    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        Store store = new Store(400, 540, 120, 9, 550);
        Message message = new Message(store);
        Inputs input = new Inputs(readInput);
        Fill refill = new Fill(readInput, store, message);

        message.showCurrentMachineStatus();

        while (true) {
            String action  = input.chooseAction();

            if (action.equals("exit")) {
                System.exit(0);
                break;
            }

            switch (action) {
                case "buy":
                    String coffeChoice = input.chooseCoffee();
                    Buy buy = new Buy(coffeChoice, store, message);
                    buy.buyCoffee();
                    break;
                case "fill":
                    refill.refill();
                    break;
                case "take":
                    System.out.println("Correct money");
                    Finances finances = new Finances(store);
                    int currentRevenue = finances.take();

                    System.out.printf("I gave you $%d", currentRevenue);
                    System.out.println();
                    message.showCurrentMachineStatus();

                    break;
                case "remaining":
                    message.showCurrentMachineStatus();
                    break;
                default:
                    System.out.println("Server error!");
            }
        }

        readInput.close();
    }
}
