import java.util.Scanner;

public class RecursiveTraverseQueue {
    private Node front;
    private Node rear;

    public RecursiveTraverseQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    public void recursiveDisplay() {
        if (isEmpty()) {
            return;
        }

        int value = dequeue();
        System.out.print(value + " ");

        recursiveDisplay();

        enqueue(value);
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        RecursiveTraverseQueue queue = new RecursiveTraverseQueue();
        int val;
        do {
            val = sc.nextInt();
            if(val != -1)
                queue.enqueue(val);
        }while(val != -1);

        queue.recursiveDisplay();
    }
}
