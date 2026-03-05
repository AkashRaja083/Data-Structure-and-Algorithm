import Stack.Node;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
} 
public class CountNodeSLL{
    Node head;
    public void insertAtEnd(int data){
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
    public int countNode(){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
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
        CountNodeSLL SLL = new CountNodeSLL();
        SLL.insertAtEnd(10);
        SLL.insertAtEnd(20);;
        SLL.insertAtEnd(30);
        SLL.display();
        System.err.println();
        System.out.println(SLL.countNode());
    }
}