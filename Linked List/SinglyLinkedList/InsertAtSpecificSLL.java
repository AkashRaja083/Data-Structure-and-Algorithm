class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class InsertAtSpecificSLL{
    Node head;
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
        InsertAtSpecificSLL SLL = new InsertAtSpecificSLL();
        SLL.InsertATRandom(10, 1);
        SLL.InsertATRandom(20, 2);
        SLL.InsertATRandom(40, 3);
        SLL.InsertATRandom(30, 3);
        SLL.Display();
    }
}
