import java.util.*;
class PriorityQueue{
    int[] data;
    int[] priority;
    int size;
    int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        priority = new int[capacity];
        size = 0;
    }

    void enqueue(int val,int p){
        if(size == capacity){
            System.out.println("Queue OverFlow");
            return;
        }

        data[size] = val;
        priority[size] = p;
        size++;

        sort();
    }

     void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (priority[j] > priority[j + 1]) {
                    
                    int tempP = priority[j];
                    priority[j] = priority[j + 1];
                    priority[j + 1] = tempP;

                    int tempD = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tempD;
                }
            }
        }
    }

    int dequeue(){
        if (size == 0) {
            throw new RuntimeException("Empty Priority Queue");
        }
        int val = data[0];

        for(int i=0;i<size;i++){
            data[i] = data[i+1];
            priority[i] = priority[i+1];
        }
        size--;
        return val;
    }

    void display(){
        for(int i=0;i<size;i++){
            System.out.println("(" + data[i] + "," + priority[i] + ")");
        }
        System.out.println("");
    }
}
public class PriorityQueueUisngArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();
        PriorityQueue queue = new PriorityQueue(cap);
        int val;
        for(int i=0;i<cap;i++){
            val =sc.nextInt();
            int p =sc.nextInt();
            queue.enqueue(val, p);
        }

        queue.display();
    }
}
