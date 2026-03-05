import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class LeftRotateListSLL {
    Node head;
    public void InsertAtEnd(int data){
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

    Node rotate(int key){
        if(head == null || head.next == null || key == 0){
            return head;
        }
        Node temp = head;
        int n = 1;
        while(temp.next != null){
            temp = temp.next;
            n++;
        }
        key %= n;
        if(key == 0){
            // temp.next = null;
            return head;
        } 
        temp.next = head;

        temp = head;
        for(int i=1;i<key;i++){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
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
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            LeftRotateListSLL SLL = new LeftRotateListSLL();
            int val;
            do { 
                val = sc.nextInt();
                if(val != -1){
                    SLL.InsertAtEnd(val);
                }
            } while(val != -1);
            SLL.display();
            int key = sc.nextInt();
            SLL.rotate(key);
            System.out.println();
            System.out.println("-------------------------------------");
            SLL.display();
        }
    }
}