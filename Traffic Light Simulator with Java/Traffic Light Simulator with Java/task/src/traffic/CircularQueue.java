package traffic;

import java.util.ArrayList;
import java.util.List;

public class CircularQueue {
    private List<String> roads;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.roads = new ArrayList<>();
    }

    public void add(String roadName) {
        if (!isFull()) {
            roads.add(roadName);
        }
    }

    public int removeIndex() {
        return 0; // Always remove from front
    }

    public String removeAt(int index) {
        if (!isEmpty() && index >= 0 && index < roads.size()) {
            return roads.remove(index);
        }
        return null;
    }

    public boolean isEmpty() {
        return roads.isEmpty();
    }

    public boolean isFull() {
        return roads.size() >= capacity;
    }

    public int size() {
        return roads.size();
    }

    public String[] getRoads() {
        return roads.toArray(new String[0]);
    }

    public void printRoads() {
        for (String road : roads) {
            System.out.println(road);
        }
    }
}