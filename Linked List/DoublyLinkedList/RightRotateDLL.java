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

    public void rotate(int k){
        if(head == null || head.next == null ||k == 0){
            return;
        }
        Node temp = head;
        int len = 1;
        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        tail = temp;
        k = k%len;
        if(k == 0){
            return; 
        }
        tail.next = head;
        head.prev = tail;

        temp = head;
        for(int i=0;i<len-k-1;i++){
            temp = temp.next;
        }
        head = temp.next;
        head.prev = null;

        temp.next = null;
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
public class RightRotateDLL {
    public static void main(String[] args) {
        DoublyLinkedList DLL = new DoublyLinkedList();
        try(Scanner sc = new Scanner(System.in)){
            int val;
            do { 
                val = sc.nextInt();
                if(val != -1)
                    DLL.insertAtEnd(val);
            } while (val != -1);
            Integer k = sc.nextInt();
            DLL.rotate(k);
            DLL.display();
        }
    }
}
