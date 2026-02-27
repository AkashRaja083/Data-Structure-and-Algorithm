import java.util.*;
class Stack{
    char[] stack;
    int top;
    Stack(int size){
        top = -1;
        stack = new char[size];
    }

    public void push(char val){
        if(top == stack.length - 1){
            System.out.println("Stack is Overflow");
            return;
        }
        stack[++top] = val;
    }

    public char pop(){
        if(top == -1){
            System.out.println("Stack is Underflow");
            return '#';
        }
        return stack[top--];
    }

    public char peek(){
        if(top == -1){
            System.out.println("Stack is Empty");
            return '#';
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isValid(String str){
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                push(ch);
            }
            else if(ch == ')' || ch == '}' || ch == ']'){
                
                if(isEmpty()){
                    return false;
                }
                char open = pop();
                if (ch == ')' && open != '(' || ch == '}' && open != '{' || ch == ']' && open != '[') {
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return isEmpty();
    }

}
public class ValidParenthesis{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack stack = new Stack(str.length());
        if(stack.isValid(str)){
            System.out.println("Valid parenthesis");
        }
        else{
            System.out.println("Not valid parenthesis");
        }
        sc.close();
    }
}