import  java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class MiddleElementSLL {
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

    int middleElement(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    
    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(" "+temp.data);
            if(temp.next != null){
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int val;
        MiddleElementSLL SLL = new MiddleElementSLL();
        do { 
            val = sc.nextInt();
            if(val != -1){
                SLL.InsertAtEnd(val);
            }
        } while (val != -1);
        SLL.display();
        System.out.println("\nMiddle Value is : " + SLL.middleElement());
        sc.close();
    }
}
