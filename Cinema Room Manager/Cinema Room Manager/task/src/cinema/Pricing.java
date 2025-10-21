package cinema;

public class Pricing {
    private final int rows;
    private final int seatsPerRow;
    private final int totalSeats;

    public Pricing(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        totalSeats = rows * seatsPerRow;
    }

    public int calculatePricing() {
        if (totalSeats <= 60) {
            return totalSeats * 10;
        }

        boolean hasEvenRows = rows % 2 == 0;
        if (hasEvenRows) {
            int half = totalSeats / 2;
            return (half * 10) + (half * 8);
        } else {
            int firstHalf = rows / 2;
            int secondHalf = rows - firstHalf;
            return (firstHalf * seatsPerRow * 10) + (secondHalf * seatsPerRow * 8);
        }
    }
}
