package LinkedList;

/**
 * Generic node for doubly linked lists.
 * Author: Michael Buss (CompSci RV Dad)
 */
public class DLLNode<T> {
    private T data;
    private DLLNode<T> next;
    private DLLNode<T> prev;

    public DLLNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public DLLNode<T> getNext() { return next; }
    public void setNext(DLLNode<T> next) { this.next = next; }

    public DLLNode<T> getPrev() { return prev; }
    public void setPrev(DLLNode<T> prev) { this.prev = prev; }
}

