package cinema;

public class Message {
    private final Pricing pricingModal;

    public Message(Pricing pricingModal) {
        this.pricingModal = pricingModal;
    }

    public void displayMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public void showStatistics() {
        System.out.printf("Number of purchased tickets: %d", pricingModal.getPurchasedTickets());
        System.out.println();

        System.out.printf("Percentage: %.2f%%", pricingModal.getPercentage());
        System.out.println();

        System.out.printf("Current income: $%d", pricingModal.getCurrentIncome());
        System.out.println();

        System.out.printf("Total income: $%d", pricingModal.getTotalIncome());
        System.out.println();
        System.out.println();
    }
}
