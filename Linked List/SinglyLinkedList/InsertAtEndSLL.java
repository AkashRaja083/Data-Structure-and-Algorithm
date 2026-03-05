class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class InsertAtEndSLL {
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
    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(" "+temp.data);
            if(temp.next != null){
                System.out.println(" -> ");
            }
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        InsertAtEndSLL SLL = new InsertAtEndSLL();
        SLL.InsertAtEnd(10);
        SLL.InsertAtEnd(20);
        SLL.InsertAtEnd(30);
        SLL.display();
    }
}
