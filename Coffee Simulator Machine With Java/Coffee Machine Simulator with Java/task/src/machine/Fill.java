package machine;

import java.util.Arrays;
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

    private static void calculateIngredients(Scanner readInput) {
        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterCapacityInml = readInput.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkCapacityInml = readInput.nextInt();

        System.out.println("Write how many grams of coffee beans coffee machine has: ");
        int coffeeBeansCapacityIng = readInput.nextInt();

        System.out.println("Write how many cups of coffee you will need: ");
        int cupsRequested = readInput.nextInt();

        int capacity = calculateNumberOfCupsToMake(waterCapacityInml, milkCapacityInml, coffeeBeansCapacityIng);

        if (capacity > cupsRequested){
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)%n", capacity - cupsRequested);
            System.out.println();
        } else if (capacity < cupsRequested) {
            System.out.printf("No, I can make only %d cup(s) of coffee", capacity);
            System.out.println();
        } else {
            System.out.println("Yes, I can make that amount of coffee");
        }
    }

    public static int calculateNumberOfCupsToMake(
            int water,
            int milk,
            int beans) {

        int waterCups = water / CoffeeMachine.mlOfWaterPerCup;
        int milkCups = milk / CoffeeMachine.mlOfMilkPerCup;
        int beansGrams = beans / CoffeeMachine.gOfCoffeeBeansPerCup;

        int[] amounts = {waterCups, milkCups, beansGrams};

        return Arrays.stream(amounts).min().getAsInt();
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
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid numbers!");
        }
    }
}
