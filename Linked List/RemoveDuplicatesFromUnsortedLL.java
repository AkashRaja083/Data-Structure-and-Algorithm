
import java.util.Scanner;
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

    Node removeDuplicate(){
        if(head == null){
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        Node curr = head;
        Node prev = curr;
        while(curr != null){
            if(set.contains(curr.data)){
                prev.next = curr.next;
            }
            else{
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
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
public class RemoveDuplicatesFromUnsortedLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int val;
        do { 
            val = sc.nextInt();
            if(val != -1)
                list.insert(val);
        } while(val != -1);
        Node head = list.removeDuplicate();
        list.display(head);
    }
}
