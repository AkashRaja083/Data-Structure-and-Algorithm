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

    public boolean isPalindrome(){
        Node left = head;
        Node right = tail;
        while(left != right && left.prev != right){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.prev;
        }
        return true;
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
public class PalindromeDLL {
    public static void main(String[] args){
        DoublyLinkedList DLL = new DoublyLinkedList();
        try(Scanner sc = new Scanner(System.in)){
            int val;
            do { 
                val = sc.nextInt();
                if(val != -1)
                    DLL.insertAtEnd(val);
            }while (val != -1);
            if(DLL.isPalindrome()){
                System.out.println("Palindrome");
            }
            else{
                System.out.println("Not a palindrome");
            }
        }
    }
}
