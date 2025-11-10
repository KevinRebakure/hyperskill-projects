package banking;

/*
- first number is (Major Industry Identifier) MII ->
      we'll use 4 (4 and 5 are issued by banking and financial institutions)
- The first 6 digits are (Bank Identification Number) BBI
- The seventh digit to the second-to-last is the (Customer Account Number)
    9 numbers are usually used but you can use up to 12
- The last digit is the check digit or checksum. Used to validate the card using
    Luhn Algorithm but for now we'll use any digit

-----------------------------------------------------------

[] Print the menu
[] 1. Create an account
        - Generate account number
        - Generate a PIN (0000 - 9999)
[] 2. Log into account
        - Ask card info -> card number and pin
[] 3. After logging in
        - 1. Balance -> to check balance
        - 2. Log out ->
        - 3. Exit
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}