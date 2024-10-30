import java.util.*;

class CircularDoublyLinkedList {

    // Node structure
    private class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;

    // Insert at the front of the list
    public void insertFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at the end of the list
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
        }
    }

    // Delete a node from the front of the list
    public void deleteFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {  // Only one element
            head = null;
        } else {
            Node last = head.prev;
            head = head.next;
            head.prev = last;
            last.next = head;
        }
    }

    // Delete a node from the end of the list
    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {  // Only one element
            head = null;
        } else {
            Node last = head.prev;
            Node secondLast = last.prev;
            secondLast.next = head;
            head.prev = secondLast;
        }
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Display the list in reverse order
    public void displayReverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node last = head.prev;
        Node temp = last;
        do {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        } while (temp != last);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        
        list.insertFront(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertFront(5);

        System.out.println("Circular doubly linked list: ");
        list.display();
        
        System.out.println("Circular doubly linked list traversed backward: ");
        list.displayReverse();
        
        list.deleteFront();
        System.out.println("After deleting from front:");
        list.display();

        list.deleteEnd();
        System.out.println("After deleting from end:");
        list.display();
    }
}
