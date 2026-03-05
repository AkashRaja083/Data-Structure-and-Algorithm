class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class SearchNodeSLL{
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
    public int searchValue(int target){
        Node temp = head;
        int pos = 1;
        while(temp != null){
            if(temp.data == target){
                return pos;
            }
            pos++;
            temp = temp.next;
        }
        return -1;
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
        SearchNodeSLL SLL = new SearchNodeSLL();
        SLL.insertAtEnd(10);
        SLL.insertAtEnd(20);;
        SLL.insertAtEnd(30);
        SLL.display();
        System.out.println();
        System.out.println(SLL.searchValue(20));
    }
}