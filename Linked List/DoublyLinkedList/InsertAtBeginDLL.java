class Node{
    int data;
    Node prev,next;
    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class InsertAtBeginDLL{
    private Node head;
    private Node tail;
    public void insertAtBegin(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.next != null){
                System.out.print(" ");
            }
            temp = temp.next;
        }
    }
    public void rev_display(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.prev != null){
                System.out.print(" ");
            }
            temp = temp.prev;
        }
    }
    public static void main(String[] args){
            InsertAtBeginDLL DLL = new InsertAtBeginDLL();
            DLL.insertAtBegin(10);
            DLL.insertAtBegin(20);
            DLL.insertAtBegin(30);
            DLL.insertAtBegin(40);
            DLL.insertAtBegin(50);
            DLL.display();
            System.out.println();
            DLL.rev_display();
    }
}