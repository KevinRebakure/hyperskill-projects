package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        final int mlOfWaterPerCup = 200;
        final int mlOfMilkPerCup = 50;
        final int gOfCoffeeBeansPerCup = 15;

        Scanner readInput = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need: ");
        int cups = readInput.nextInt();

        System.out.printf("For %d cups of coffee you will need: ", cups);
        System.out.println();

        System.out.printf("%d ml of water", cups * mlOfWaterPerCup);
        System.out.println();

        System.out.printf("%d ml of milk", cups * mlOfMilkPerCup);
        System.out.println();

        System.out.printf("%d g of coffee beans", cups * gOfCoffeeBeansPerCup);
        System.out.println();

        readInput.close();
    }
}