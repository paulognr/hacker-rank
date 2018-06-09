import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueStacks {

    public static void main(String[] args) {
        List<MyQuery> queries = Arrays.asList(
                new MyQuery(MyQuery.ENQUEUE, 42),
                new MyQuery(MyQuery.DEQUEUE),
                new MyQuery(MyQuery.ENQUEUE, 14),
                new MyQuery(MyQuery.PRINT),
                new MyQuery(MyQuery.ENQUEUE, 28),
                new MyQuery(MyQuery.PRINT),
                new MyQuery(MyQuery.ENQUEUE, 60),
                new MyQuery(MyQuery.ENQUEUE, 78),
                new MyQuery(MyQuery.DEQUEUE),
                new MyQuery(MyQuery.DEQUEUE));

        MyQueue<Integer> queue = new MyQueue<Integer>();

        for (int i = 0; i < queries.size(); i++) {
            int operation = queries.get(i).action;
            if (operation == 1) { // enqueue
                queue.enqueue(queries.get(i).number);
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
    }
}

class MyQueue<T> {
    private Queue<T> queue = new LinkedList<>();

    public void enqueue(T object) {
        queue.add(object);
    }

    public void dequeue() {
        queue.remove();
    }

    public T peek() {
        return queue.peek();
    }
}

class MyQuery {
    public static final int ENQUEUE = 1;
    public static final int DEQUEUE = 2;
    public static final int PRINT = 3;

    int action;
    int number;

    MyQuery(int action){
        this.action = action;
    }

    MyQuery(int action, int number){
        this.action = action;
        this.number = number;
    }
}