# 🧠 COMP251 – Data Structures & Algorithms (UFV)

**Author:** Michael Buss  
**Course:** UFV COMP 251 – Data Structures & Algorithms  
**Purpose:** A clean, working Java portfolio demonstrating foundational data structure implementations from the course — refactored for readability, modularity, and real-world GitHub presentation.

> *“The best way to understand data structures is to build them from scratch.”*  
> — The CompSci RV Dad 🚐💻

---

## 🧩 Contents
- **Stack** – Push/pop operations, string reversal, balanced parentheses, infix→postfix conversion.
- **Queue** – FIFO structures, enqueue/dequeue, and circular queue simulation.
- **Linked List** – Node-based design with insert, delete, and concatenation methods.
- **Trees** – Binary tree creation, recursive traversals (preorder, inorder, postorder).
- **Recursion** – Factorial, Fibonacci, and sum-of-odds recursive examples.

---

## 🧱 Project Overview
This repository showcases reusable, well-structured implementations of core **data structures** written in Java — each organized under its own package:

| Package | Description |
|----------|--------------|
| **Stack/** | Abstract List Interface (`ADTList`) and `ArrayBasedList` implementation for array-based storage and dynamic resizing. |
| **LinkedList/** | Full suite of linked list types including `Node<T>`, `SinglyLinkedList<T>`, `DLLNode`, and `DoublyLinkedList`. |
| **Trees/** | Basic `BinaryTree` and `TestBinaryTree` implementation with traversal examples. |
| **Recursion/** | Reserved for future algorithm and recursion exercises. |
| **Queue/** | Reserved for upcoming queue and circular buffer examples. |

---

## 🧩 Example Run – Singly Linked List

```java
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
```

---

Output:

Initial List: [Alpha, Bravo, Charlie]
After Removal: [Alpha, Charlie]
Element at Index 1: Charlie
Is Empty? false
Size: 2

---

## 🧩 Example Run – Doubly Linked List

```java
DoublyLinkedList<String> list = new DoublyLinkedList<>();

list.add("Alpha");
list.add("Bravo");
list.add("Charlie");
System.out.println("Initial List (Forward): " + list);

list.add(1, "Delta");
System.out.println("After Insertion at index 1 (Forward): " + list);

System.out.println("Element at index 2: " + list.get(2));

list.remove(1);
System.out.println("After Removal at index 1 (Forward): " + list);

System.out.println("Backward Traversal: " + list.toReverseString());

System.out.println("Is Empty? " + list.isEmpty());
System.out.println("Size: " + list.size());

---

Output:

Initial List (Forward): [Alpha, Bravo, Charlie]
After Insertion at index 1 (Forward): [Alpha, Delta, Bravo, Charlie]
Element at index 2: Bravo
After Removal at index 1 (Forward): [Alpha, Bravo, Charlie]
Backward Traversal: [Charlie, Bravo, Alpha]
Is Empty? false
Size: 3

---

## 🧩 Example Run – Array-Based List

```java
ArrayBasedList<String> list = new ArrayBasedList<>(10);
list.add("Alpha");
list.add("Bravo");
list.add("Charlie");
System.out.println("Initial List: " + list);

list.add(1, "Delta");
System.out.println("After Insertion at index 1: " + list);

System.out.println("Element at index 2: " + list.get(2));

list.remove(1);
System.out.println("After Removal at index 1: " + list);

System.out.println("Is Empty? " + list.isEmpty());
System.out.println("Size: " + list.size());

---

Output:

Initial List: [Alpha, Bravo, Charlie], Size: 3, Capacity: 10
After Insertion at index 1: [Alpha, Delta, Bravo, Charlie], Size: 4, Capacity: 10
Element at index 2: Bravo
After Removal at index 1: [Alpha, Bravo, Charlie], Size: 3, Capacity: 10
Is Empty? false
Size: 3


---

## 🧠 Learning Goals
- Strengthen understanding of Big-O analysis and algorithmic efficiency.  
- Practice recursion and iterative design.  
- Reinforce OOP concepts using generics in Java.  
- Develop clean, modular, and reusable code.

---

⚙️ Tech Notes
Language: Java 17+
IDE/Editor: Visual Studio Code & Terminal
Structure: Multi-package organization under /src and /out
Compilation:

javac -d out src/Stack/*.java src/LinkedList/*.java
java -cp out LinkedList.TestSinglyList

---

## 🛠️ Tools
- **Language:** Java 17  
- **IDE:** VS Code  
- **Version Control:** Git + GitHub

---

🧭 Learning Reflection
This project was part of my hands-on journey through UFV’s COMP 251 course.
It helped me strengthen my understanding of:
Java package and classpath management
Generic data type design (Node<T>, ADTList<T>)
Algorithmic thinking through linked data structures
Building, testing, and debugging modular Java projects
Using Git for version control and portfolio presentation

---

🚀 Next Steps
Implement Queue and Recursion examples
Extend Tree package with traversal visualization
Add JUnit tests for automated validation
Document each data structure’s time complexity

---

👨‍💻 Maintained by Michael Buss — aka The CompSci RV Dad 🚐☕


---


> *“The best way to understand data structures is to build them from scratch.”*

## 📂 Folder Overview
- `src/Stack/` → push/pop, balanced parentheses, infix→postfix  
- `src/Queue/` → enqueue/dequeue, circular queue  
- `src/LinkedList/` → singly linked lists, concatenation  
- `src/Trees/` → binary tree insert/traversals  
- `src/Recursion/` → factorial, Fibonacci, sum odds

