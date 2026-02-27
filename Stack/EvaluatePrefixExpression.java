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

    public int evaluatePrefix(String exp) {

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if (ch == ' ') continue;

            // If digit
            if (Character.isDigit(ch)) {
                push(ch - '0');
            } 
            else {
                int a = pop();
                int b = pop();

                int result = 0;

                switch (ch) {
                    case '+': result = a + b; break;
                    case '-': result = a - b; break;
                    case '*': result = a * b; break;
                    case '/': result = a / b; break;
                }

                push(result);
            }
        }

        return pop();
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

public class EvaluatePrefixExpression {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StackLL stack = new StackLL();
        String str = sc.nextLine();
        System.out.println(stack.evaluatePrefix(str));
    }
}
