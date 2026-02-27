import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        next = null;
        prev = null;
    }
}

class DequeLL{
    Node front;
    Node rear;

    void insertFront(int data){
        Node newNode = new Node(data);
        if(front == null){
            front = rear = newNode;
        }
        else{
            front.prev = newNode;
            newNode.next = front;
            front  = newNode;
        }
    }

    void insertRear(int data){
        Node newNode = new Node(data);
        if(front == null){
            front = rear = newNode;
        }
        else{
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    void deleteFront(){
        if(front == null){
            throw new RuntimeException("Deque is empty");
        }

        if(front == rear){
            front = rear = null;
            return;
        }

        front = front.next;
        front.prev = null;
    }

    void deleteRear(){
        if(front == null){
            throw new RuntimeException("Deque is empty");
        }

        if(front == rear){
            front = rear = null;
            return;
        }

        rear = rear.prev;
        rear.next = null;
    }

    int getFront(){
        if(front == null){
            throw new RuntimeException("Deque is empty");
        }
        return front.data;
    }

    int getRear(){
        if(front == null){
            throw new RuntimeException("Deque is empty");
        }
        return rear.data;
    }

    void displayFront(){
        Node temp = front;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.next != null)
                System.out.print(" ");
            temp = temp.next;
        }
    }

    void displayRear(){
        Node temp = rear;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.prev != null)
                System.out.print(" ");
            temp = temp.prev;
        }
    }

}

public class DequeLinkedList{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.err.println("1.Inser at Front\n2.Insert At Rear\n3.Delete At Front\n4.Delete At Rear\n5.Front Element \n 6.Rear Element \n7.Front Displat \n8.Rear Display ");
        System.out.println("Enter the count of the operation");
        int n = sc.nextInt();
        DequeLL queue = new DequeLL();
        for(int i=0;i<n;i++){
            System.out.println("Enter the Choice");
            int ch = sc.nextInt();
            switch(ch){
                case 1 -> {
                    int val = sc.nextInt();
                    queue.insertFront(val);
                }
                case 2 -> {
                    int value = sc.nextInt();
                    queue.insertRear(value);
                }
                case 3 -> queue.deleteFront();
                case 4 -> queue.deleteRear();
                case 5 -> System.out.println(queue.getFront());
                case 6 -> System.out.println(queue.getRear());
                case 7 -> queue.displayFront();
                case 8 -> queue.displayRear();
            }
        }
        sc.close();
    }
}