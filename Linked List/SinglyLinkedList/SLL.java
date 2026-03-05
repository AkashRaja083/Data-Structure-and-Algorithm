class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class SLL {
    Node head;
    void InsertAtBegin(int data){
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
    }

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

    public void InsertATRandom(int data,int pos){
        if(pos <= 0){
            System.out.println("Invalid Position");
            return;
        }
        Node newnNode = new Node(data);
        if(pos==1){
            newnNode.next = head;
            head = newnNode;
            return;
        }
        Node temp = head;
        for(int i=1;i<pos-1 && temp != null;i++){ 
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Out of Bound");
            return;
        }
        newnNode.next = temp.next;
        temp.next = newnNode;
    }

    public void DeleteATFirst(){
        if(head == null){
            System.out.println("List is Empty.");
            return;
        }
        head = head.next;
    }

    public void deleteAtEnd(){
            if(head == null){
                System.out.println("List is Empty");
                return;
            }
            if(head.next == null){ 
                head = null;
                return;
            }
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
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

    public void Display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.next != null)
                    System.out.print(" -> ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        SLL Sll = new SLL();
        Sll.InsertATRandom(10, 1);
        Sll.InsertATRandom(20, 2);
        Sll.InsertAtEnd(10);
        Sll.InsertAtEnd(20);
        Sll.InsertATRandom(40, 3);
        Sll.InsertATRandom(30, 3);
        Sll.Display();
    } 
}
