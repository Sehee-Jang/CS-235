package edu.ensign.cs235.queue;

import java.util.NoSuchElementException;

public class QueueOnLinkedList<T> {

	class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		} // end of public Node(T data)

		public String toString() {
			return String.valueOf(this.data);
		}
	} // end of class Node<T>

	private Node<T> first;
	private Node<T> last;
	private int size;

	// Methods

	public void enqueue(T item) {
		Node<T> t = new Node<T>(item);

		// if there is the last node, then add a new node
		if (last != null) {
			last.next = t;
		}

		// Now 't' is the last node
		last = t;

		// if there is no data, assign the same value
		if (first == null) {
			first = last;
		}

		// Increase size
		size++;
	} // end of public void enqueue (T item)

	public T dequeue() {
		if (first == null) {
			throw new NoSuchElementException();
		}

		// Back up data, then make the next one as the first
		T data = first.data;
		first = first.next;

		// if the first is null, assign the last is null
		if (first == null) {
			last = null;
		}
		size--;
		return data;
	}// end of public T dequeue()

	public T peek_front() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}// end of public T peek_front()

	public T peek_rear() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return last.data;
	}// end of public T peek()

	public boolean is_empty() {
		return first == null;
	}

	public void clear() {
		first = null;
		last = null;
		size = 0;

	}

	public int get_size() {
		return size;
	}

	public String toString() {
		// If there's no node, return []
		if (first == null) {
			return "[]";
		}

		// Searching
		Node temp = first;
		String str = "[";

		// Run repeat statements until there is no next node
		// Since the last node does not have the next node, the syntax below excludes
		// the last node
		while (temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}

		// Include the last node in the output result
		str += temp.data;
		return str + "]";

	} // End of toString()

}
