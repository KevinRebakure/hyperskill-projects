package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    static List<Account> accountList = new ArrayList<>();

    public static Account createAccount() {
        final String BIN = "400000";
        var random = new Random();

        String accountNumber = BIN + (100_000_000 + random.nextInt(900_000_000));

        String finalAccountNumber = accountNumber;
        while (accountList.stream().anyMatch(account -> account.getAccountNumber().equals(finalAccountNumber))) {
            accountNumber = BIN + (100_000_000 + random.nextInt(900_000_000));
        }

        var newAccount = new Account(accountNumber);
        accountList.add(newAccount);
        return newAccount;
    }

    public static boolean login(Scanner scanner) {
        System.out.println("Enter your card number: ");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter your PIN: ");
        String pin = scanner.nextLine();

        var existingAccount = accountList.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst();

        if (existingAccount.isPresent()) {
            return  existingAccount.get().getPin().equals(pin);
        } else {
            return false;
        }
    }
}
