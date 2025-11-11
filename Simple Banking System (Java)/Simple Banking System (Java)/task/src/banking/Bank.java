package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void login() {
        System.out.println("Logged in");
    }
}
