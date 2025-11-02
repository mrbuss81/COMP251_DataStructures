package LinkedList;

/**
 * Test driver for DoublyLinkedList
 * Demonstrates add, remove, forward, and backward traversals.
 *
 * Author: Michael Buss (CompSci RV Dad)
 */
public class TestDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // Add elements
        list.add("Alpha");
        list.add("Bravo");
        list.add("Charlie");
        System.out.println("Initial List (Forward): " + list);

        // Insert in the middle
        list.add(1, "Delta");
        System.out.println("After Insertion at index 1 (Forward): " + list);

        // Get element
        System.out.println("Element at index 2: " + list.get(2));

        // Remove an element
        list.remove(1);
        System.out.println("After Removal at index 1 (Forward): " + list);

        // Traverse backward
        System.out.println("Backward Traversal: " + list.toReverseString());

        // Check status
        System.out.println("Is Empty? " + list.isEmpty());
        System.out.println("Size: " + list.size());
    }
}

