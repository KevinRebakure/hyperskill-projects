package calculator;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> items = Map.of(
                "Bubblegum", 202,
                "Toffee", 118,
                "Ice cream", 2250,
                "Milk chocolate", 1680,
                "Doughnut", 1075,
                "Pancake", 80
        );

        System.out.println("Earned amount:");
        System.out.println("Bubblegum: $202");
        System.out.println("Toffee: $118");
        System.out.println("Ice cream: $2250");
        System.out.println("Milk chocolate: $1680");
        System.out.println("Doughnut: $1075");
        System.out.println("Pancake: $80");
        System.out.println();

        int sum = items.values().stream().mapToInt(Integer::intValue).sum();

        System.out.printf("Income: $%d", sum);
        System.out.println();
    }
}