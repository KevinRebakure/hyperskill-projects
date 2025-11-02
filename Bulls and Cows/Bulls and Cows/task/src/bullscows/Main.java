package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String secret  = "9305";

        Scanner scanner = new Scanner(System.in);

        String guess = scanner.nextLine();
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
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.", bulls, cows, secret);
        } else if (bulls > 0) {
            System.out.printf("Grade: %d bull(s). The secret code is %s.", bulls, secret);
        } else if (cows > 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %s.", cows, secret);
        } else {
            System.out.printf("Grade: None. The secret code is %s.", secret);
        }

        scanner.close();
    }
}
