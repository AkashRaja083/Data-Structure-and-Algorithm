import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next  = null;
    }
}
class SinglyinkedList{
    Node head;
    public void insert(int data){
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

    void swapNode(int x,int y){
        if(x == y){
            return;
        }
        Node currx = head;
        Node prevx = null;
        while(currx != null && currx.data != x){
            prevx = currx;
            currx = currx.next;
        }

        Node curry = head;
        Node prevy = null;
        while(curry != null && curry.data != y){
            prevy = curry;
            curry = curry.next;
        }

        if(curry == null || currx == null)
            return;

        if(prevx != null)
            prevx.next = curry;
        else
            head = curry;
        
        if(prevy != null)
            prevy.next = currx;
        else
            head = currx;

        Node temp = currx.next;
        currx.next = curry.next;
        curry.next = temp;
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
public class Swap2NodesSLL {
    public static void main(String[] args){
        SinglyinkedList list = new SinglyinkedList();
        Scanner sc = new Scanner(System.in);
        int val;
        do{
            val = sc.nextInt();
            if(val != -1)
                list.insert(val);
        }while(val != -1);

        int x = sc.nextInt();
        int y = sc.nextInt();

        list.swapNode(x,y);

        list.display();
    }
}
