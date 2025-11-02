package bullscows;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");
        int lengthOfSecret = scanner.nextInt();
        scanner.nextLine();

        if (lengthOfSecret >= 11) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.\n");
            return;
        }

        String secret = generateSecret(lengthOfSecret);
        System.out.printf("the random secret number is %s.\n", secret);

        String guess = null;
        boolean won = false;
        int turns = 1;

        while (!won) {
            System.out.printf("Turn %d\n", turns++);
            guess = scanner.nextLine();
            gradeGuess(guess, secret);

            if (Objects.equals(secret, guess)) {
                won = true;
            }
        }

        System.out.println("Congratulations! You guessed the secret code.\n");

        scanner.close();
    }

    private static String generateSecret(int lengthOfSecret) {
        StringBuilder secret = new StringBuilder();

        while (secret.length() < lengthOfSecret) {
            long pseudoRandomNumber = System.nanoTime();
            String[] randomNumberDigits = String.valueOf(pseudoRandomNumber).split("");

            for (int i = randomNumberDigits.length - 1; i >= 0; i--) {
                String currentDigit = randomNumberDigits[i];

                if (secret.isEmpty() && currentDigit.equals("0")) {
                    continue;
                }

                if (!secret.toString().contains(currentDigit) && Character.isDigit(currentDigit.charAt(0))) {
                    secret.append(currentDigit);
                }

                if (secret.length() == lengthOfSecret) {
                    break;
                }
            }
        }

        return secret.toString();
    }


    private static void gradeGuess(String guess, String secret) {
        String[] digits = guess.split("");

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < digits.length; i++) {
            String currentDigit = digits[i];
            if (secret.contains(currentDigit)) {
                if (secret.indexOf(currentDigit) == i) {
                    bulls += 1;
                } else {
                    cows += 1;
                }
            }
        }

        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.\n", bulls, cows, secret);
        } else if (bulls > 0) {
            System.out.printf("Grade: %d bull(s). The secret code is %s.\n", bulls, secret);
        } else if (cows > 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %s.\n", cows, secret);
        } else {
            System.out.printf("Grade: None. The secret code is %s.\n", secret);
        }
    }
}
