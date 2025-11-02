// package com.Mike.linkedlists;

public class DLLNode {					// DLLNode class	
	
	private Integer value;				// fields for value, prev and next
	private DLLNode prev;				
	private DLLNode next;
	
	public DLLNode(Integer value, DLLNode prev, DLLNode next) {		// constructor with 3 parameters
		
		this.value = value;
		this.prev = prev;
		this.next = next;
		
	}
	

	public Integer getValue() {					// getters and setters for DLLNode
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public DLLNode getPrev() {
		return prev;
	}

	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}
	
}
