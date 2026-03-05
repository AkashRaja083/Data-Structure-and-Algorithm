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

    public void doublyToCircularly(){
        if(head == null){
            return;
        }
        tail.next = head;
        head.prev = tail;
    }

    public void displayCircularly(){
        if(head == null){
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.data);
            temp = temp.next;
            if(temp != head){
                System.out.print("->");
            }
        }while(temp != head);
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
        System.out.println();
    }
}
public class DoublyToCircularly {
    public static void main(String[] args){
        DoublyLinkedList DLL = new DoublyLinkedList();
        try(Scanner sc= new Scanner(System.in)){
            int val;
            do{
                val = sc.nextInt();
                if(val != -1)
                    DLL.insertAtEnd(val);
            }while(val != -1);
            DLL.doublyToCircularly();
            DLL.displayCircularly();
        }
    }
}
