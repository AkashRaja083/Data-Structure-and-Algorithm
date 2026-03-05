import java.util.Scanner;

class Node{
    Node prev;
    int data;
    Node next;
    Node(int data){
        prev = null;
        this.data = data;
        next = null;
    }
}
class DoublyLinkedList{
    Node head;
    Node tail;

    public DoublyLinkedList(){
        head = null;
        tail = null;
    }
    
    public void insertAtSpecific(int data,int pos){
        Node newNode = new Node(data);
        if(pos == 1){
            if(head == null){
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        Node temp = head;
        for(int i=0;i<pos-1 && temp != null;i++){
            temp = temp.next;
        }

        if(temp == null){
            return;
        }

        if(temp.next == null){
            temp.next = newNode;
            newNode.prev = temp;
            tail = newNode;
            return;
        }
    
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.next != null){
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }
}
public class InsertAtSpecificDLL {
    public static void main(String[] args) {
        DoublyLinkedList DLL = new DoublyLinkedList();
        try(Scanner sc= new Scanner(System.in)) {
            int val;
            do{ 
                val = sc.nextInt();
                if(val != -1)
                    DLL.insertAtEnd(val);
            } while (val != -1);

            System.out.println("Before inserting element in position");
            DLL.display();
            DLL.insertAtSpecific(100, 1);
            System.out.println();
            System.out.println("After inserting element in position");
            DLL.display();
        }
    }
}
