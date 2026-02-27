import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next  = null;
    }
}
class StackLL{
    Node head;
    public void push(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    int pop(){
        int value = head.data;
        head = head.next;
        return value;
    }

    int peek(){
        return head.data;
    }

    boolean isEmpty(){
        return head == null;
    }

    void sortedInsert(int x){
        if(isEmpty() || peek() <= x){
            push(x);
            return;
        }
        int top = pop();
        sortedInsert(x);
        push(top);
    }

    void sortStack(){
        if(isEmpty()){
            return;
        }
        int top = pop();
        sortStack();
        sortedInsert(top);
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            if(temp.next != null)
                System.out.print(" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class SortStackRecursion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StackLL stack = new StackLL();
        int val;
        do{
            val = sc.nextInt();
            if(val != -1)
                stack.push(val);
        }while(val != -1);

        stack.sortStack();

        stack.display();
    }
}
