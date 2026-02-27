/*
Merge Two Sorted Linked List into a Single Sorted Linked List
*/
import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class SinglyLinkedList{
    Node head;

    void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    Node merge(Node head1,Node head2){
        Node dummy = new Node(0);
        Node tail = dummy;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                tail.next = head1;
                head1 = head1.next;
            }
            else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if(head1 != null){
            tail.next = head1;
        }
        else{
            tail.next = head2;
        }

        return dummy.next;
    }

    void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.next != null){
                System.out.print(" ");
            }
            temp = temp.next;
        }
    }

}
public class Merge2SortedSLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list1 = new SinglyLinkedList();
        int val;
        do { 
            val = sc.nextInt();
            if(val != -1)
                list1.insert(val);
        } while(val != -1);

        SinglyLinkedList list2 = new SinglyLinkedList();
        do { 
            val = sc.nextInt();
            if(val != -1)
                list2.insert(val);
        } while(val != -1);

        SinglyLinkedList list = new SinglyLinkedList();
        Node head = list.merge(list1.head ,list2.head);
        list.display(head);
    }
}
