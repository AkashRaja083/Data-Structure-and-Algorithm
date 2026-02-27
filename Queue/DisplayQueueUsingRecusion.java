import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}

class Queue{
    Node front;
    Node rear;

    void enqueue(int data){
        Node newNode = new Node(data);
        if(front == null){
            front = rear = newNode;
        }
        rear.next = newNode;
        rear = newNode;
    }


    void displayRecursive(int size) {
        if (size == 0) return;

        int val = dequeue();
        System.out.print(val + " ");

        displayRecursive(size - 1);
        enqueue(val);
    }

    int size(){
        Node temp = front;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    int dequeue(){
        int val = front.data;
        front = front.next;
        return val;
    }
}
public class DisplayQueueUsingRecusion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();
        int val;
        do{
            val = sc.nextInt();
            if(val != -1)
                queue.enqueue(val);
        }while(val != -1);
        int n = queue.size();
        queue.displayRecursive(n);
    }
}
