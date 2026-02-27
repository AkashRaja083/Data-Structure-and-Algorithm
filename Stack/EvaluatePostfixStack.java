import java.util.Scanner;

class Stack {
    int[] arr;
    int top;

    Stack(int size) {
        arr = new int[size];
        top = -1;
    }

    void push(int val) {
        if (top == arr.length - 1)
            throw new RuntimeException("Stack Overflow");
        arr[++top] = val;
    }

    int pop() {
        if (top == -1)
            throw new RuntimeException("Stack Underflow");
        return arr[top--];
    }

    int peek() {
        if (top == -1)
            throw new RuntimeException("Stack Empty");
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    int evaluatePostfix(String str) {
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(Character.isDigit(ch)){
                push(ch - '0');
            } 
            else{
                int b = pop();
                int a = pop();
                switch (ch) {
                    case '+': push(a + b); break;
                    case '-': push(a - b); break;
                    case '*': push(a * b); break;
                    case '/': push(a / b); break;
                }
            }
        }
        return peek();
    }
}

public class EvaluatePostfixStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String postfix = sc.nextLine(); // "23*54*+9-"
        Stack s = new Stack(postfix.length());
        System.out.println(s.evaluatePostfix(postfix));
    }
}
