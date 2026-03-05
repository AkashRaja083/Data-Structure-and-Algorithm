class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class InserAtFirstSLL {
    Node head;
    void InsertAtBegin(int data){
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
    }
    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
    }
    public static void main(String[] args){
        InserAtFirstSLL SLL = new InserAtFirstSLL();
        SLL.InsertAtBegin(10);
        SLL.InsertAtBegin(20);
        SLL.InsertAtBegin(30);
        SLL.display();
    }
}
