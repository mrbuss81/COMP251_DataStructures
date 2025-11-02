package Stack;

public interface ADTList<T> {
    void add(T element);
    void add(int index, T element);
    T get(int index);
    int size();
    boolean isEmpty();
    T remove(int index);
}

