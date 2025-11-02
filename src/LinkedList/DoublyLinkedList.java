// package com.Mike.linkedlists;

public class DoublyLinkedList {
	
	private DLLNode header;					// header object
	private DLLNode trailer;				// or instance if you prefer
	private int size;						// size attribute or field...
	
	
	public DoublyLinkedList() {							
		header = new DLLNode( null, null, null);		// creation of the DLL header, that is a sentinel
		trailer = new DLLNode( null, header, null);		// creation of the DLL trailer, also a sentinel 
		header.setNext(trailer);
	}
	
	public int size() {						// method to return size
		return size;
	}
	
	public boolean isEmpty() {				// method returns true if empty
		return size == 0;
	}
	
	public Integer first() {				// retrieve the value of the first node in the list
		if (isEmpty()) {
			return null;
		}
		
		return header.getNext().getValue();
	}
	
		
	// method used to add between 2 nodes
	public void addBetween(Integer value, DLLNode predecessor, DLLNode successor){
		DLLNode newest =  new DLLNode(value, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;								
		
	}
	
	public Integer last() {							// retrieve the value of the last node in the list
		if (isEmpty()) {
			return null;
		}
		
		return trailer.getPrev().getValue();
	}
	
	public void addFirst(Integer value) {					// add first node, after the sentinel 
		addBetween(value, header, header.getNext());
	}
	
	public void addLast(Integer value) {					// add last node before the trailer sentinel
		addBetween(value, trailer.getPrev(), trailer); 	
		
	}
	
	public Integer removeFirst() {							// remove first node
		if (isEmpty()) {
			return null;
		}
		
		return remove(header.getNext());
	}
	
	public Integer removeLast() {							// remove last node 
		if (isEmpty() ) {
			return null;
		}
		
		return remove(trailer.getPrev());					// calls the remove method on the node before the trailer
	}
	
	private Integer remove(DLLNode node) {					// removes and gets node value
		DLLNode predecessor = node.getPrev();
		DLLNode successor = node.getNext();
		
		predecessor.setNext(successor);		// Set the next pointer of the predecessor to skip the node being removed and point to the successor
		successor.setPrev(predecessor);		// Set the previous pointer of the successor to link back to the predecessor
		size--;
		
		return node.getValue();
	}
					
	public void printList() {							// prints list
		if (isEmpty()) {								// empty check
			System.out.println("The List is Empty!");		
		} else {
			System.out.println("Traversing the list: ");	
			
			DLLNode start = header.getNext();			// access the first actual node
			
			while(start != trailer) {
				System.out.print(start.getValue() + " ");
					
				start = start.getNext();					// executes while start is not the trailer 	
			}	
			
			System.out.println("\nThe size of the list: " + size);
		}
	}
	
	public void swapNodes(DLLNode node1, DLLNode node2) {
		if (node1 == node2) {
			return; 						// check to see if the nodes are the same, and if they then there is no need to swap
		}	
		
		DLLNode predecessor1 = node1.getPrev();				// get the predecessors and successors for node 1
		DLLNode successor1 = node1.getNext();
		DLLNode predecessor2 = node2.getPrev();				// get the predecessors and successors for node 2
		DLLNode successor2 = node2.getNext();
		
		if (successor1 == node2) {
			predecessor1.setNext(node2);					// swap the nodes in the list if node 1 is immediately before node2
			node2.setPrev(predecessor1);					// link predecessor 1 to node2
			
			node2.setNext(node1);							//link node 2 to successor
			node1.setPrev(node2);
			
			node1.setNext(successor2);						//link node 1 to successor2
			
			if (successor2 != null) {						// check to see that successor 2 is not null
				successor2.setPrev(node1);
			}
			
			if (node2 == trailer.getPrev()) {				// update trailer if necessary 
				trailer.setPrev(node1);
			}
			
		} else if (successor2 == node1) {					// if node2 is immediately before node1
			predecessor2.setNext(node1);
			node1.setPrev(predecessor2);
			node1.setNext(node2);
			node2.setPrev(node1);
			node2.setNext(successor1);
			
			if (successor1 != null) {						// check that successor1 isnt null
				successor1.setPrev(node2);				
			}
			
			if (node1 == trailer.getPrev()) {
				trailer.setPrev(node2);
			}
		} else {
			predecessor1.setNext(node2);			// linking nodes 
			node2.setPrev(predecessor1);
			predecessor2.setNext(node1);
			node1.setPrev(predecessor2);
			node1.setNext(successor2);
			
			if (successor2 != null) {				
				successor2.setPrev(node1);
			}
			
			node2.setNext(successor1);
			
			if (successor1 != null) {
				successor1.setPrev(node2);
			}
		}	
	}
	
	public DLLNode findNode(Integer value) {			// method to find node (traverse)
		DLLNode current = header.getNext();
	
		while (current != trailer) {
			if (current.getValue().equals(value)) {
				return current;							// return node if value matches
			}
			current = current.getNext();
		}
		return null;
	}
}
