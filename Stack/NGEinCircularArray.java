import java.util.*;
class Stack{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    Node head;

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop(){
        int val = head.data;
        head = head.next;
        return val;
    }

    public int peek(){
        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }
}

public class NGEinCircularArray {
    public static int[] ngeCircular(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack stack = new Stack();
        for (int i=0;i<2*n;i++) {
            int curr = arr[i % n];
            while(!stack.isEmpty() && arr[stack.peek()] < curr) {
                res[stack.pop()] = curr;
            }
            if(i<n){
                stack.push(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int[] result = ngeCircular(arr);
            for(int i : result){
                System.out.print(i+" ");
            }
        }
    }
}
