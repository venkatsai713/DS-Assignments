class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SortedLinkedList {

    Node head;

    public void insertSorted(int data) {
        Node newNode = new Node(data);

        // If the list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        // If the new node is to be inserted at the beginning
        if (head.data >= data) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Find the appropriate position to insert the node
        Node current = head;
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }

        // Insert the node at the found position
        newNode.next = current.next;
        current.next = newNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.insertSorted(98);
        list.insertSorted(75);
        list.insertSorted(46);
        list.insertSorted(87);
        list.insertSorted(6);

        list.printList(); // Expected output: 6 46 75 87 98
    }
}
