import java.util.*;
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

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    public void deleteAtFirst(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        if(head.next == null){
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void reverse(){
        Node current = head;
        Node temp;
        while(current != null){
            temp  = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        temp = head;
        head = tail;
        tail = temp;
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
public class ReverseDLL {
    public static void main(String[] args) {
        DoublyLinkedList DLL = new DoublyLinkedList();
        try(Scanner sc = new Scanner(System.in)){
            int val;
            do { 
                val = sc.nextInt();
                if(val != -1)
                    DLL.insertAtEnd(val);
            } while (val != -1);
            System.out.println("Before Reverse");
            DLL.display();
            System.out.println("");
            DLL.reverse();
            System.out.println("After reverse");
            DLL.display();
        }
    }
}
