import java.util.*;

class BinaryTree<T> {
	public class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;
		
		public Node( T data ) { this( data, null, null); }
		public Node( T data, Node<T> left, Node<T> right ) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
		

		public Node<T> add( T data ) {
			Node<T> newNode = new Node( data, null, null );
			if( left == null ) { left = newNode; return left; } 
			else if( right == null ){ right = newNode; return right; }
			return null;
		}

// ============================================================================
// STUDENT-IMPLEMENTED ITERATIVE TRAVERSALS
// Author: Michael Buss (300066231)
// Course: COMP 251 - Data Structures and Algorithms
// Description: Implementations of four iterative traversal algorithms 
// (Preorder, Inorder, Postorder, and Level Order) added to the 
// professor-provided BinaryTree.Node<T> class.
// ============================================================================

/**
 * Performs an iterative Preorder traversal (Root → Left → Right).
 * Uses a stack to simulate recursion.
 * Pushes the right child first so the left child is processed first (LIFO order).
 * This traversal visits each node as soon as it’s encountered.
 * 
 * @param result A list to store the traversal order of node data.
 */
public void iterativePreOrder(List<T> result) {
    Stack<Node<T>> stack = new Stack<>();
    stack.push(this); 

    while (!stack.isEmpty()) {
        Node<T> current = stack.pop();
        result.add(current.data); 

        if (current.right != null)
            stack.push(current.right); 
        if (current.left != null)
            stack.push(current.left);
    }
}

/**
 * Performs an iterative Postorder traversal (Left → Right → Root).
 * Uses two stacks to reverse a modified Preorder traversal.
 * Ensures children are processed before their parent.
 * Slightly more memory-intensive but simple and reliable.
 * 
 * @param result A list to store the traversal order of node data.
 */
public void iterativePostOrder(List<T> result) {
    if (this == null) return;

    Stack<Node<T>> s1 = new Stack<>();
    Stack<Node<T>> s2 = new Stack<>();
    s1.push(this);

    while (!s1.isEmpty()) {
        Node<T> current = s1.pop();
        s2.push(current);

        if (current.left != null)
            s1.push(current.left);
        if (current.right != null)
            s1.push(current.right);
    }

    while (!s2.isEmpty()) {
        result.add(s2.pop().data);
    }
}

/**
 * Performs an iterative Inorder traversal (Left → Root → Right).
 * Uses a single stack to reach the leftmost node,
 * processes the node, then explores its right subtree.
 * Produces sorted output for BSTs.
 * 
 * @param result A list to store the traversal order of node data.
 */
public void iterativeInOrder(List<T> result) {
    Stack<Node<T>> stack = new Stack<>();
    Node<T> current = this;

    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        result.add(current.data);
        current = current.right;
    }
}

/**
 * Performs an iterative Level Order (Breadth-First Search) traversal.
 * Uses a queue to visit nodes level by level, top to bottom, left to right.
 * Demonstrates BFS behavior by processing nodes in FIFO order.
 * 
 * @param result A list to store the traversal order of node data.
 */
public void iterativeLevelOrder(List<T> result) {
    if (this == null) return;

    Queue<Node<T>> queue = new LinkedList<>();
    queue.add(this);

    while (!queue.isEmpty()) {
        Node<T> current = queue.remove();
        result.add(current.data);

        if (current.left != null)
            queue.add(current.left);
        if (current.right != null)
            queue.add(current.right);
    }
}

		
		public boolean find( Node<T> node ) {
			if( this == null || node == null ) { return false; }
			else {
				if( node.equals( this ) ) { return true; }
				else if( left != null && left.find(node) ) { return true; } 
				else if( right != null && right.find(node) ) { return true; }
			}
			return false;
		}
	}
	
	private Node<T> root;
	private int size = 0;
	private ArrayList<T> elements = new ArrayList<>();
	
	//constructors
	public BinaryTree() { root = null; }
	public BinaryTree( T data ) { root = new Node(data); }
	
	//accessor methods
	public Node<T> getRoot() { return root; }
	public boolean find( Node<T> node ) { return root.find( node ); }
	
	//modifier methods
	public void setRoot( Node<T> node ) { root = node; }
	public Node<T> add( T data, Node<T> parent ) {
		if( parent == null ) { System.out.println("Parent node cannot be null!!!"); }
		else if( !root.find( parent ) ) { System.out.println("Parent node does not exist on the tree!!!"); } 
		else { 
			Node<T> node = parent.add( data );
			size++; 
			return node;
		}
		return null;
	}
	public void add( T data ) {
		if( root == null ) { root = new Node( data, null, null ); } 
		else { root.add( data ); }
		size++;
	}	
	public String toString() { 
		root.iterativeInOrder(elements);
		return elements.toString();
	}
}