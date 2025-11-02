package LinkedList;

public class TestSinglyList {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("Alpha");
        list.add("Bravo");
        list.add("Charlie");

        System.out.println("Initial List: " + list);
        list.remove(1);
        System.out.println("After Removal: " + list);
        System.out.println("Element at Index 1: " + list.get(1));
        System.out.println("Is Empty? " + list.isEmpty());
        System.out.println("Size: " + list.size());
    }
}

