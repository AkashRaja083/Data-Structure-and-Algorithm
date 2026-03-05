class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class DeleteAtSpecificSLL {
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
    public void deleteAtSpecific(int pos){
        if(head == null){
            System.out.println("List is Empty.");
            return;
        }
        if(pos <= 0){
            System.out.println("Invalid Position.");
            return;
        }
        if(pos == 1){
            head = head.next;
            return;
        }
        Node temp = head;
        for(int i=1;i<pos-1 && temp.next != null;i++){
            temp = temp.next;
        }
        if(temp.next == null){
            System.out.println("Out of Bound");
            return;
        }
        temp.next = temp.next.next;
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
        DeleteAtSpecificSLL SLL = new DeleteAtSpecificSLL();
        SLL.insertAtEnd(10);
        SLL.insertAtEnd(20);
        SLL.insertAtEnd(30);
        SLL.insertAtEnd(40);
        SLL.deleteAtSpecific(2);
        SLL.display();
    }
}
