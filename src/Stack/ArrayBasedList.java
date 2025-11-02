package Stack;

// package week_3;
class ArrayBasedList<T> implements ADTList<T> {
    private T[] items;
    private int capacity;
    private int size;
    public static final int INCREMENT = 5;

    public ArrayBasedList() {
        capacity = INCREMENT;
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public ArrayBasedList(int initialCapacity) {
        capacity = initialCapacity;
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public ArrayBasedList(T[] items) {
        this.capacity = items.length;
        this.items = (T[]) new Object[capacity];
        for (T item : items) {
            if (item != null) {
                this.items[size++] = item;
            }
        }
    }

    public void add(T value) {
        if (size == capacity) {
            resize();
        }
        items[size++] = value;
    }

    private void resize() {
        capacity += INCREMENT;
        T[] temp = (T[]) new Object[capacity];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            System.out.println("Error: " + index + " is out of bound!!");
            return;
        }
        if (size == capacity) {
            resize();
        }
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = value;
        size++;
    }

    public void clear() {
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Error: " + index + " is out of bound!!");
            return null;
        }
        return items[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Error: " + index + " is out of bound!!");
            return null;
        }
        T removedItem = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        size--;
        return removedItem;
    }

    public boolean set(int index, T value) {
        if (index < 0 || index >= size) {
            System.out.println("Error: " + index + " is out of bound!!");
            return false;
        }
        items[index] = value;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            str.append(items[i]);
            if (i < size - 1) str.append(", ");
        }
        str.append("], Size: ").append(size).append(", Capacity: ").append(capacity);
        return str.toString();
    }
}
