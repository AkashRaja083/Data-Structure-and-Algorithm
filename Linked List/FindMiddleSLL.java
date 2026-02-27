
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

    int middle(){
        if(head == null){
            throw new NullPointerException("NULL");
        }
        HashSet<Integer> set = new HashSet<>();
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
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
public class FindMiddleSLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int val;
        do { 
            val = sc.nextInt();
            if(val != -1)
                list.insert(val);
        } while(val != -1);

    }
}
