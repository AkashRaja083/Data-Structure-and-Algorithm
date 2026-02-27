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
public class NextGreaterElement {
    /*
    public static ArrayList<Integer> nextGreater(int[] arr){
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Stack stack = new Stack();
        for(int i=0;i<n;i++){
            res.add(-1);
        }
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                res.set(i,stack.peek());
            }

            stack.push(arr[i]);
        }
        return res;
    }
*/
    public static int[] nextGreater(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        Stack stack = new Stack();

        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && stack.peek() < arr[i]){
                map.put(stack.pop(), arr[i]);
            }
            stack.push(arr[i]);
        }

        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        int[] result = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            result[i] = map.get(arr[i]);
        }
        return result;
    }

    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            for(int i : nextGreater(arr)){
                System.out.print(i + " ");
            }
        }
    }
}
