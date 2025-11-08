package traffic;

import java.util.Scanner;

public class Main {
    private static volatile boolean systemOpen = false;
    private static int roads;
    private static int interval;
    private static int secondsPassed = 0;
    private static CircularQueue queue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);

        Messages.welcome();
        roads = input.readValue("Input the number of roads: ");
        interval = input.readValue("Input the interval: ");

        queue = new CircularQueue(roads);

        // Create and start QueueThread
        Thread queueThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    secondsPassed++;

                    if (systemOpen) {
                        printSystemInfo();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        queueThread.setName("QueueThread");
        queueThread.start();

        input.clear();
        Messages.displayMenu();
        int option = input.readOption("");

        while (option != 0) {
            switch (option) {
                case 1:
                    System.out.print("Input road name: ");
                    String roadName = scanner.nextLine();
                    if (queue.isFull()) {
                        System.out.println("Queue is full");
                    } else {
                        queue.add(roadName);
                        System.out.println(roadName + " Added!");
                    }
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty");
                    } else {
                        String deleted = queue.remove();
                        System.out.println(deleted + " deleted!");
                    }
                    break;
                case 3:
                    systemOpen = true;
                    scanner.nextLine(); // Wait for Enter
                    systemOpen = false;
                    input.clear();
                    break;
                default:
                    System.out.println("Incorrect option. Try again.");
            }

            if (option != 3) {
                scanner.nextLine();
                input.clear();
            }
            Messages.displayMenu();
            option = input.readOption("");
        }

        queueThread.interrupt();
        System.out.print("Bye!");
    }

    private static void printSystemInfo() {
        System.out.println("! " + secondsPassed + "s. have passed since system startup !");
        System.out.println("! Number of roads: " + roads + " !");
        System.out.println("! Interval: " + interval + " !");

        if (!queue.isEmpty()) {
            System.out.println();
            queue.printRoads();
            System.out.println();
        }

        System.out.println("! Press \"Enter\" to open menu !");
    }
}