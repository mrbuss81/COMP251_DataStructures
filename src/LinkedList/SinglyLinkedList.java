// package week_3;
// Cleaned and updated by Michael Buss (CompSci RV Dad)

// package LinkedList;
package LinkedList;

import Stack.ADTList;
import java.util.NoSuchElementException;

/**
 * A simple generic singly linked list implementing the ADTList interface.
 * Supports insert, get, remove, and basic list operations.
 *
 * @param <T> the type of elements stored in the list
 */
public class SinglyLinkedList<T> implements ADTList<T> {

    /** Node representing the start of the list */
    private Node<T> head;

    /** Number of elements in the list */
    private int size;

    /** Constructs an empty linked list. */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        add(size, element); // append at end
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node<T> newNode = new Node<>(element);

        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.getNext();
            }
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
        }

        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        T removedData;

        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.getNext();
            }

            Node<T> toRemove = prev.getNext();
            removedData = toRemove.getData();
            prev.setNext(toRemove.getNext());
        }

        size--;
        return removedData;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /** Returns a string representation of the list. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) sb.append(", ");
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
