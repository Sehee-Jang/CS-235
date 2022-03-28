package edu.ensign.cs235.stack;

import java.util.NoSuchElementException;

public class StackOnLinkedList<T> {

	class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}

		public String toString() {
			return String.valueOf(this.data);
		}
	}

	private Node<T> top;
	private int size;

	public int get_size() {
		return size;
	}

	public T pop() {
		if (top == null) {
			throw new NoSuchElementException();
		}

		// Back up the data
		T item = top.data;

		// Make the next data as top
		top = top.next;

		size--;

		return item;
	}

	// Receive a value of type T
	public void push(T value) {
		// Create a node with that value
		Node<T> t = new Node<T>(value);
		// Place the node in front of the top
		t.next = top;
		// t becomes top
		top = t;
		size++;
	}

	public T peek() {
		if (top == null) {
			throw new NoSuchElementException();
		}
		return top.data;
	}

	public boolean is_empty() {
		return top == null;
	}

	public String toString() {
		// If there's no node, return []
		if (top == null) {
			return "[]";
		}

		// Searching
		Node temp = top;
		String str = "[";

		// Run repeat statements until there is no next node
		// Since the last node does not have the next node, the syntax below excludes
		// the last node
		while (temp.next != null) {
			str += temp.data + "-> ";
			temp = temp.next;
		}

		// Include the last node in the output result
		str += temp.data;
		return str + "]";

	} // End of toString()

}
