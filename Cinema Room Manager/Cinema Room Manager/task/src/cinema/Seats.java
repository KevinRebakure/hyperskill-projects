package cinema;

public class Seats {
    public void printSeats() {
        System.out.println("Cinema: ");
        for (int i = 0; i < 8 ; i++) {
            if (i == 0) {
                System.out.print("  ");
                for (int j = 1; j < 9; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            } else {
                System.out.println(i + " " +"S ".repeat(8));
            }
        }
    }
}
