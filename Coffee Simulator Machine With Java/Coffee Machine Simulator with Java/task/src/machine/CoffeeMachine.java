package machine;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    static final int mlOfWaterPerCup = 200;
    static final int mlOfMilkPerCup = 50;
    static final int gOfCoffeeBeansPerCup = 15;

    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);

        Store store = new Store(400, 540, 120, 9, 550);

        readInput.close();
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

        int waterCups = water / mlOfWaterPerCup;
        int milkCups = milk / mlOfMilkPerCup;
        int beansGrams = beans / gOfCoffeeBeansPerCup;

        int[] amounts = {waterCups, milkCups, beansGrams};

        return Arrays.stream(amounts).min().getAsInt();
    }
}

// STEP 1.
// buy
// fill
// take

// STEP 2. buy
// choose: (1) espresso, (2) latte, (3) cappuccino
// espresso - 250ml water, 16g beans -- $4
// latte - 350 ml water, 75ml milk, 20g beans -- $7
// cappuccino - 200ml water, 100ml milk, 12g beans - $6

// STEP 3. fill
// water
// milk
// beans
// cups

// STEP 4. take
// give out all the money