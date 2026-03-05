class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class RecursiveTraversalSLL {
    public static void Traversal(Node head){
        Node temp = head;
        if(temp == null){
            System.out.println();
            return;
        }
        System.out.print(temp.data);
        if(temp.next != null){
            System.out.print(" -> ");
        }
        Traversal(temp.next);
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        Traversal(head);
    }
}
