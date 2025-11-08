package traffic;

public class CircularQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void add(String roadName) {
        if (!isFull()) {
            rear = (rear + 1) % capacity;
            queue[rear] = roadName;
            size++;
        }
    }

    public String remove() {
        if (!isEmpty()) {
            String removed = queue[front];
            front = (front + 1) % capacity;
            size--;
            return removed;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void printRoads() {
        if (!isEmpty()) {
            int index = front;
            for (int i = 0; i < size; i++) {
                System.out.println(queue[index]);
                index = (index + 1) % capacity;
            }
        }
    }
}