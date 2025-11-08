package traffic;

import java.util.Scanner;

public class Main {
    private static volatile boolean systemOpen = false;
    private static int numRoads;
    private static int interval;
    private static int secondsPassed = 0;
    private static CircularQueue queue;
    private static int timeRemaining = 0;
    private static int currentOpenRoadIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);

        Messages.welcome();
        numRoads = input.readValue("Input the number of roads: ");
        interval = input.readValue("Input the interval: ");

        queue = new CircularQueue(numRoads);

        // Create and start QueueThread
        Thread queueThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    secondsPassed++;

                    if (systemOpen) {
                        printSystemInfo();
                    }

                    // Decrease timer AFTER displaying if there are roads
                    if (!queue.isEmpty() && timeRemaining > 0) {
                        timeRemaining--;

                        // Switch to next road when timer expires
                        if (timeRemaining == 0) {
                            if (queue.size() > 1) {
                                currentOpenRoadIndex = (currentOpenRoadIndex + 1) % queue.size();
                            }
                            timeRemaining = interval;
                        }
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
                        boolean wasEmpty = queue.isEmpty();
                        queue.add(roadName);
                        if (wasEmpty) {
                            timeRemaining = interval;
                            currentOpenRoadIndex = 0;
                        }
                        System.out.println(roadName + " Added!");
                    }
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty");
                    } else {
                        int removedIndex = queue.removeIndex();
                        String deleted = queue.removeAt(removedIndex);
                        System.out.println(deleted + " deleted!");

                        // Adjust currentOpenRoadIndex if necessary
                        if (currentOpenRoadIndex == removedIndex) {
                            // The open road was deleted
                            currentOpenRoadIndex = -1; // No road is open until timer expires
                        } else if (currentOpenRoadIndex > removedIndex) {
                            currentOpenRoadIndex--;
                        }

                        // Ensure currentOpenRoadIndex is valid
                        if (queue.isEmpty()) {
                            timeRemaining = 0;
                            currentOpenRoadIndex = 0;
                        } else if (currentOpenRoadIndex >= queue.size()) {
                            currentOpenRoadIndex = currentOpenRoadIndex % queue.size();
                        }
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
        System.out.println("! Number of roads: " + numRoads + " !");
        System.out.println("! Interval: " + interval + " !");

        if (!queue.isEmpty()) {
            System.out.println();

            int size = queue.size();
            String[] roads = queue.getRoads();

            for (int i = 0; i < size; i++) {
                if (i == currentOpenRoadIndex && currentOpenRoadIndex != -1) {
                    // This road is open
                    System.out.println("Road \"" + roads[i] + "\" will be open for " + timeRemaining + "s.");
                } else {
                    // Calculate time until this road opens
                    int timeUntilOpen;
                    if (size == 1) {
                        timeUntilOpen = timeRemaining;
                    } else if (currentOpenRoadIndex == -1) {
                        // No road is currently open
                        if (i == 0) {
                            timeUntilOpen = timeRemaining;
                        } else {
                            timeUntilOpen = timeRemaining + (i - 1) * interval;
                        }
                    } else {
                        int stepsAhead;
                        if (i > currentOpenRoadIndex) {
                            stepsAhead = i - currentOpenRoadIndex;
                        } else {
                            stepsAhead = (size - currentOpenRoadIndex) + i;
                        }
                        timeUntilOpen = timeRemaining + (stepsAhead - 1) * interval;
                    }
                    System.out.println("Road \"" + roads[i] + "\" will be closed for " + timeUntilOpen + "s.");
                }
            }

            System.out.println();
        }

        System.out.println("! Press \"Enter\" to open menu !");
    }
}