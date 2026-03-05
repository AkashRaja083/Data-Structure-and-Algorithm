class Node{
    int data;
    Node prev,next;
    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class InsertAtEndDLL{
    private Node head;
    private Node tail;
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
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
    public static void main(String[] args) {
        InsertAtEndDLL DLL = new InsertAtEndDLL();
        DLL.insertAtEnd(10);
        DLL.insertAtEnd(20);
        DLL.insertAtEnd(30);
        DLL.display();
    }
}