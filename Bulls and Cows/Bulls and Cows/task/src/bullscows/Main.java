package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthOfSecret = 0;
        int numberOfPossibleSymbols = 0;

        try {
            System.out.println("Input the length of the secret code:");
            lengthOfSecret = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Input the number of possible symbols in the code:");
            numberOfPossibleSymbols = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            String badInput = scanner.nextLine();
            System.out.printf("Error: %s isn't a valid number.", badInput);
            return;
        }

        validateInputs(lengthOfSecret, numberOfPossibleSymbols);

//        if (lengthOfSecret > numberOfPossibleSymbols) {
//            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.\n", lengthOfSecret, numberOfPossibleSymbols);
//            return;
//        }
//
//        if (numberOfPossibleSymbols > 36) {
//            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
//            return;
//        }

        String secret = generateSecret(lengthOfSecret, numberOfPossibleSymbols);

        // Print the prepared secret message
        printPreparedSecret(lengthOfSecret, numberOfPossibleSymbols);
        System.out.println("Okay, let's start a game!");

        String guess = null;
        boolean won = false;
        int turns = 1;

        while (!won) {
            System.out.printf("Turn %d:\n", turns++);
            guess = scanner.nextLine();
            won = gradeGuess(guess, secret);
        }

        System.out.println("Congratulations! You guessed the secret code.");

        scanner.close();
    }

    private static void validateInputs(int lengthOfSecret, int numberOfPossibleSymbols) {
        if (numberOfPossibleSymbols > lengthOfSecret) {
            System.out.println("Error: it's not possible to generate a code with a length of 6 with 5 unique symbols.");
            System.exit(0);
        }

        if (numberOfPossibleSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }
    }

    private static void printPreparedSecret(int length, int numSymbols) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stars.append("*");
        }

        String range;
        if (numSymbols <= 10) {
            range = String.format("(0-%d)", numSymbols - 1);
        } else {
            char lastLetter = (char) ('a' + numSymbols - 11);
            range = String.format("(0-9, a-%c)", lastLetter);
        }

        System.out.printf("The secret is prepared: %s %s.\n", stars, range);
    }

    private static String generateSecret(int lengthOfSecret, int numberOfPossibleSymbols) {
        List<Character> allCharacters = new ArrayList<>();

        // add all numbers
        for (int i = 0; i < 10; i++) {
            allCharacters.add((char) ('0' + i));
        }

        // add all letters
        for (int i = 0; i < 26; i++) {
            allCharacters.add((char) ('a' + i));
        }

        List<Character> allowedRange = allCharacters.subList(0, numberOfPossibleSymbols);

        Collections.shuffle(allowedRange);

        StringBuilder secret = new StringBuilder();

        for (int i = 0; i < lengthOfSecret; i++) {
            secret.append(allowedRange.get(i));
        }

        return secret.toString();
    }

    private static boolean gradeGuess(String guess, String secret) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < guess.length(); i++) {
            char currentChar = guess.charAt(i);
            if (secret.indexOf(currentChar) == i) {
                bulls += 1;
            } else if (secret.indexOf(currentChar) != -1) {
                cows += 1;
            }
        }

        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s)\n", bulls, cows);
        } else if (bulls > 0) {
            System.out.printf("Grade: %d bull(s)\n", bulls);
        } else if (cows > 0) {
            System.out.printf("Grade: %d cow(s)\n", cows);
        } else {
            System.out.println("Grade: None");
        }

        return bulls == secret.length();
    }
}