class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeLinkedLists {

    public static Node mergeLists(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node mergedHead = null;
        Node tail = null;

        while (head1 != null && head2 != null) {
            Node newNode;
            if (head1.data <= head2.data) {
                newNode = head1;
                head1 = head1.next;
            } else {
                newNode = head2;
                head2 = head2.next;
            }

            if (mergedHead == null) {
                mergedHead = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Append remaining nodes from head1 or head2
        tail.next = (head1 != null) ? head1 : head2;

        return mergedHead;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create two linked lists
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = new Node(9);

        // Print the original lists
        System.out.print("Linked List 1: ");
        printList(head1);

        System.out.print("Linked List 2: ");
        printList(head2);

        // Merge and print the merged list
        Node mergedHead = mergeLists(head1, head2);
        System.out.print("Merged Linked List: ");
        printList(mergedHead);
    }
}
