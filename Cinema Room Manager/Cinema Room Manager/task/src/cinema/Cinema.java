package cinema;

// read: number of rows
// read: number of seats in each roq
// determine the ticket price
// if number of seats is not >60 - each seat $10
// in a larger room, 1st front half - each seat $10
//                   2nd back half - each seat $8
// if number of rows is odd like 9, the first half is 4, second 5
// number of rows and seats won't be greater than 9


public class Cinema {

    public static void main(String[] args) {
        // log all rows
        Seats seats = new Seats();
        ReadInput input = new ReadInput();

        input.setSeatsPerRow();
        System.out.println(input.getSeatsPerRow());

//        seats.printSeats();
    }
}