import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        //node3.next = node2;

        System.out.println(hasCycle(node1));
    }

    static boolean hasCycle(Node head) {
        if(head == null) return false;

        List<Node> nodes = new ArrayList<>();
        Node current = head;

        while (current.next != null) {
            if(nodes.contains(current)){
                return true;
            }

            nodes.add(current);
            current = current.next;
        }

        return false;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
