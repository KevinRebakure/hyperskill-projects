package machine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fill {
    private final Scanner readInput;
    private final Store store;
    private final Message message;

    public Fill(Scanner readInput, Store store, Message message) {
        this.readInput = readInput;
        this.store = store;
        this.message = message;
    }

    public void refill() {
        try {
            System.out.println("Write how many ml of water you want to add: ");
            int water = readInput.nextInt();
            store.setWater(store.getWater() + water);

            System.out.println("Write how many ml of milk you want to add: ");
            int milk = readInput.nextInt();
            store.setMilk(store.getMilk() + milk);

            System.out.println("Write how many grams of coffee beans you want to add: ");
            int beans = readInput.nextInt();
            store.setCoffeeBeans(store.getCoffeeBeans() + beans);

            System.out.println("Write how many disposable cups you want to add: ");
            int cups = readInput.nextInt();
            store.setCups(store.getCups() + cups);

            message.showCurrentMachineStatus();
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid numbers!");
        }
    }
}
