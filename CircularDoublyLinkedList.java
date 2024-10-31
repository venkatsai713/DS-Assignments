public class CircularDoublyLinkedList {

    class Node {

        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    // Add a node to the beginning of the list
    public void addFirst(int item) {
        Node newNode = new Node(item);

        if (head == null) {
            // For the first node, point both next and previous to itself
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
        } else {
            newNode.next = head;
            newNode.previous = tail;
            head.previous = newNode;
            tail.next = newNode;
            head = newNode;
        }
    }

    // Add a node to the end of the list
    public void addLast(int item) {
        Node newNode = new Node(item);

        if (head == null) {
            // If the list is empty, set this node as head and tail, with self-references
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
        } else {
            newNode.next = head;
            newNode.previous = tail;
            tail.next = newNode;
            head.previous = newNode;
            tail = newNode;
        }
    }

    // Display list in forward direction
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        System.out.print("Forward: ");
        do {
            System.out.print(current.value + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }

    // Display list in backward direction
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = tail;
        System.out.print("Backward: ");
        do {
            System.out.print(current.value + " <-> ");
            current = current.previous;
        } while (current != tail);
        System.out.println("(back to tail)");
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

        cdll.addFirst(1);
        cdll.addFirst(2);
        cdll.addFirst(3);
        cdll.displayForward();
        cdll.displayBackward();

        cdll.addLast(4);
        cdll.addLast(5);
        cdll.addLast(6);
        cdll.displayForward();
        cdll.displayBackward();
    }
}
