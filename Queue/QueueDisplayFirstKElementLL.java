import java.util.*;
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

    void printFirstK(int k){
        Node temp = front;
        int count = 0;
        while(temp != null && count < k){
            System.out.print(temp.data+" ");
            temp = temp.next;
            count++;
        }
    }

    int dequeue(){
        int val = front.data;
        front = front.next;
        return val;
    }
}
public class QueueDisplayFirstKElementLL {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();
        int val;
        do{
            val = sc.nextInt();
            if(val != -1)
                queue.enqueue(val);
        }while(val != -1);

        int k = sc.nextInt();

        queue.printFirstK(k);
    }
}
