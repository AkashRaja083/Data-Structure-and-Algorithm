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
    boolean cycleCheck(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
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
public class CycleCheckSLL{
    public static void main(String[] args) {
        try(Scanner sc =new Scanner(System.in)){
            SinglyLinkedList SLL = new SinglyLinkedList();
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                int val = sc.nextInt();
                SLL.InsertAtEnd(val);
            }
            System.out.println((SLL.cycleCheck())?"Cycle":"No Cycle");
            SLL.display();
        }
    }
}