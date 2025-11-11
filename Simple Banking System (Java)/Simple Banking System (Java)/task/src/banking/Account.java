package banking;

import java.util.Random;

public class Account {
    private final String accountNumber;
    private String pin;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        createPin();
    }

    public String createPin() {
        var random = new Random();
        String pin = String.valueOf(1000 + random.nextInt(9000));
        this.pin = pin;
        return pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }
}
