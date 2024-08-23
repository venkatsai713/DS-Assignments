import java.util.Arrays;

public class DynamicArrayStack {

    private int[] stack;
    private int size;
    private int capacity;

    // Constructor to initialize the stack
    public DynamicArrayStack(int initialCapacity) {
        this.capacity = initialCapacity;
        this.stack = new int[initialCapacity];
        this.size = 0;
    }

    // Push operation to add an element to the stack
    public void push(int value) {
        // Double the array size if it's full
        if (size == capacity) {
            resize();
        }
        stack[size] = value;
        size++;
    }

    // Pop operation to remove and return the top element
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        int value = stack[size - 1];
        size--;
        return value;
    }

    // Peek operation to return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return stack[size - 1];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to return the current size of the stack
    public int getSize() {
        return size;
    }

    // Private method to resize the stack when it gets full
    private void resize() {
        capacity = capacity * 2;
        stack = Arrays.copyOf(stack, capacity);
    }

    // Method to print the elements of the stack
    public void printStack() {
        for (int i = 0; i < size; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArrayStack stack = new DynamicArrayStack(3); // Initial capacity of 3
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40); // Stack will resize here
        System.out.println("Stack after pushing 4 elements:");
        stack.printStack(); // Output: 10 20 30 40
        System.out.println("Top element (peek): " + stack.peek()); // Output: 40
        System.out.println("Popped element: " + stack.pop()); // Output: 40
        System.out.println("Stack after popping the top element:");
        stack.printStack(); // Output: 10 20 30
        System.out.println("Current stack size: " + stack.getSize()); // Output: 3
    }
}
