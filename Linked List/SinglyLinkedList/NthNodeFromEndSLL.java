import java.util.*;
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
    int count;
    void insert(int data){
        Node newNode = new Node(data);
        count++;
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

    Node findNthfromEnd(int k){
        if(head == null){
            return null;
        }

        Node fast = head;
        Node slow = head;

        for(int i=0;i<k;i++){
            if(fast == null)
                return null;
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
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
public class NthNodeFromEndSLL{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int val;
        do { 
            val = sc.nextInt();
            if(val != -1)
                list.insert(val);
        } while(val != -1);
        int k = sc.nextInt();
        Node head = list.findNthfromEnd(k);
        System.out.print(head.data);
    }
}