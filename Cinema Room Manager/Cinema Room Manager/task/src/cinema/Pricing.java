package cinema;

public class Pricing {
    private final Seats seats;
    private double percentage;
    private int currentIncome;
    private final int totalIncome;
    private int purchasedTickets;

    public Pricing(Seats seats) {
        this.seats = seats;
        this.totalIncome = calculateRevenue();
    }

    public int calculateRevenue() {
        if (seats.getTotalSeats() <= 60) {
            return seats.getTotalSeats() * 10;
        }

        boolean hasEvenRows = seats.getRows() % 2 == 0;
        if (hasEvenRows) {
            int half = seats.getTotalSeats() / 2;
            return (half * 10) + (half * 8);
        } else {
            int firstHalf = seats.getRows() / 2;
            int secondHalf = seats.getRows() - firstHalf;
            return (firstHalf * seats.getSeatsPerRow() * 10) + (secondHalf * seats.getSeatsPerRow() * 8);
        }
    }

    public int ticketPrice(int rowNumber) {
        if (seats.getTotalSeats() <= 60) return 10;

        boolean sittingInFirstHalf = rowNumber <= seats.getRows() / 2;

        return sittingInFirstHalf ? 10 : 8;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public int getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(int purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }
}
