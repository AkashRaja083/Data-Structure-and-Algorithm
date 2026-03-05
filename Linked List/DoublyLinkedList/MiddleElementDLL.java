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
    
    public int middle(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
    }
}
public class MiddleElementDLL {
    public static void main(String[] args){
        DoublyLinkedList DLL = new DoublyLinkedList();
        try(Scanner sc = new Scanner(System.in)){
            int val;
            do{
                val = sc.nextInt();
                if(val != -1)
                    DLL.insertAtEnd(val);
            }while(val != -1);
            System.out.println("Middle -> "+DLL.middle());
        }
    }
}
