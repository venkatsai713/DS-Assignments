public class ArrayOperations {

    private int[] arr;
    private int size;

    public ArrayOperations(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = value;
    }

    private void resize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resize'");
    }

    public void remove() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("Array is empty");
        }
        arr[--size] = 0; // Optional: Clear the last element
    }

    public void insertAt(int index, int value) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        if (size == arr.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = 0; // Optional: Clear the last element
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayOperations arrayOps = new ArrayOperations(5);
        arrayOps.insert(1);
        arrayOps.insert(2);
        arrayOps.insert(3);
        arrayOps.insertAt(1, 4);
        arrayOps.print(); // Output: 1 4 2 3

        arrayOps.removeAt(2);
        arrayOps.print(); // Output: 1 4 3

        arrayOps.remove();
        arrayOps.print(); // Output: 1 4
    }
}
