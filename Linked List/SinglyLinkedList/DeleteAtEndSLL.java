class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
    public class DeleteAtEndSLL {
        Node head;
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

        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
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
        DeleteAtEndSLL SLL = new DeleteAtEndSLL();
        SLL.insertAtEnd(10);
        SLL.insertAtEnd(20);
        SLL.insertAtEnd(30);
        SLL.insertAtEnd(40);
        SLL.insertAtEnd(50);
        SLL.deleteAtEnd();
        SLL.display();
    }
}
