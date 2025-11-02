package LinkedList;

/**
 * Generic Doubly Linked List Implementation
 * Author: Michael Buss (CompSci RV Dad)
 */
public class DoublyLinkedList<T> {
    private DLLNode<T> head;
    private DLLNode<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T element) {
        add(size, element);
    }

    public void add(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);

        DLLNode<T> newNode = new DLLNode<>(element);

        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        } else if (index == size) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } else {
            DLLNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            DLLNode<T> prev = current.getPrev();
            prev.setNext(newNode);
            newNode.setPrev(prev);
            newNode.setNext(current);
            current.setPrev(newNode);
        }

        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);

        DLLNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);

        T removed;
        if (size == 1) {
            removed = head.getData();
            head = tail = null;
        } else if (index == 0) {
            removed = head.getData();
            head = head.getNext();
            head.setPrev(null);
        } else if (index == size - 1) {
            removed = tail.getData();
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            DLLNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            removed = current.getData();
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }

        size--;
        return removed;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        DLLNode<T> current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) sb.append(", ");
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    /** Returns a string representing the list in reverse order. */
    public String toReverseString() {
        StringBuilder sb = new StringBuilder("[");
        DLLNode<T> current = tail;
        while (current != null) {
            sb.append(current.getData());
            if (current.getPrev() != null) sb.append(", ");
            current = current.getPrev();
        }
        sb.append("]");
        return sb.toString();
    }
}

