import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        next = prev = null;
    }
}
class StackMiddle{
    Node head;
    Node mid;
    int size;
    StackMiddle(){
        this.head = null;
        mid = null;
        size = 0;
    }
    
    void push(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
        
        size++;
        
        if(size == 1)
            mid = head;
        else if(size % 2 != 0)
            mid = mid.prev;
    }
    
    int pop(){
        int val = head.data;
        head = head.next;
        if(head != null){
            head.prev = null;
        }
        size--;
        if(size == 0){
            mid = null;
        }
        else if(size % 2 == 0){
            mid = mid.next;
        }
        return val;
    }
    
    int getMiddle(){
        return mid.data;
    }
    
    int deleteMiddle(){
        int val = mid.data;
        if(size == 1){
            head = null;
            mid = null;
        }
        else{
            if(mid.prev != null){
                mid.prev.next = mid.next;
            }
            
            if(mid.next != null){
                mid.next.prev = mid.prev;
            }
            
            if(size % 2 == 0){
                mid = mid.prev;
            }
            else{
                mid = mid.next;
            }
        }
        size--;
        return val;
    }
    
    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
public class Main{
    public static void main(String[] args){
        StackMiddle stack = new StackMiddle();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
           int val = sc.nextInt();
           stack.push(val);
        }
        stack.display();
        System.out.println();
        System.out.println(stack.getMiddle());
        System.out.println(stack.deleteMiddle());
        stack.display();
        System.out.println();
        
        System.out.println(stack.getMiddle());
    }
}