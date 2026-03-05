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
    
    public void deleteAtEnd(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        if(head.next == null){
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
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

    public void doublyToCircularly(){
        if(head == null){
            return;
        }
        tail.next = head;
        head.prev = tail;
    }

    public void RemoveLoop(){
        if(head == null) return;
        
        Node fast = head;
        Node slow = head;
        boolean isloop = false;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                isloop = true;
                break;
            }
        }
        
        if(!isloop) return;
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        Node curr = slow;
        while(curr.next != slow){
            curr = curr.next;
        }
        curr.next = null;
        tail = curr;
    }
   
}

public class RemoveLoopDLL {
    public static void main(String[] args){
        DoublyLinkedList  DLL = new DoublyLinkedList();
        try(Scanner sc = new Scanner(System.in)){
            int val;
            do{
                val = sc.nextInt();
                if(val != -1)
                    DLL.insertAtEnd(val);
            }while(val != -1);
            
            DLL.doublyToCircularly();
            
            DLL.RemoveLoop();
            DLL.display();
        }
    }
}
