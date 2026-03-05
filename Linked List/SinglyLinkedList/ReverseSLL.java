import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class SinglyLinkedList{
    Node head;
    void InsertAtEnd(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newnode;
    }
    void reverse(){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.next !=  null){
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }
}
public class ReverseSLL {
    public static void main(String[] args) {
        SinglyLinkedList SLL = new SinglyLinkedList();
        SLL.InsertAtEnd(10);
        SLL.InsertAtEnd(20);
        SLL.InsertAtEnd(30);
        SLL.display();
        System.out.println();
        SLL.reverse();
        SLL.display();
    }
}
