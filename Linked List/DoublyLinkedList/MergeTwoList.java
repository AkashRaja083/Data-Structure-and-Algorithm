import java.util.Scanner;

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

    public static DoublyLinkedList mergeTwoList(DoublyLinkedList list1, DoublyLinkedList list2) {
        if (list1.head == null) return list2;
        if (list2.head == null) return list1;

        list1.tail.next = list2.head;
        list2.head.prev = list1.tail;
        list1.tail = list2.tail;

        return list1;
    }

}
public class MergeTwoList{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            DoublyLinkedList list1 = new DoublyLinkedList();
            DoublyLinkedList list2 = new DoublyLinkedList();

            System.out.println("Enter elements for List1 (end with -1):");
            int val;
            while ((val = sc.nextInt()) != -1) {
                list1.insertAtEnd(val);
            }

            System.out.println("Enter elements for List2 (end with -1):");
            int head;
            while ((head = sc.nextInt()) != -1) {
                list2.insertAtEnd(head);
            }

            DoublyLinkedList mergedList = DoublyLinkedList.mergeTwoList(list1, list2);

            System.out.println("Merged List:");
            mergedList.display();
        }
    }
}
