package edu.ensign.cs235.singlelinkedlist;

import java.util.NoSuchElementException;

public class SinglyLinkedList {
	
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		// 데이터가 저장될 필드
		private int data;
		
		// 다음 노드를 가르키는 필드
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public String toString() {
			return String.valueOf(this.data);
		}
		
	} // End of class Node
	
	public int get_size() {
		// Return the # of elements being stored in the list, using a data member as a counter
		return size;
	} // End of get_size()
	

	public int get_count() {
		// Return the # of elements being stored in the list, counting the elements in the list manually
		// Traversing all the nodes

		Node temp = head;
		int count = 0;
		
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		
		return count;
	} // End of get_count()

	public boolean is_empty() {
		// LinkedList가 비어있는지를 판단하는 메소드
		// 사이즈가 0이면 true, 아니라면 false 반환
		return size == 0;
	} // End of is_empty()
 	
	public void insert(int i) {
	
		Node newNode = new Node(i);
		
		if(size == 0) {
			insert_head(i);
		}
		
		tail.next = newNode;
		tail = newNode;
		size++;
	} // End of insert(int i)
	
	public void insert_head(int i) {
		// Create Node
		Node newNode = new Node(i);
		
		// Specify the next node of the newNode as the head
		newNode.next = head;
		
		// Specify the newNode for the head.
		head = newNode;
		
		size++;
		
		if(head.next == null) {
			tail = head;
		}
	} // End of insert_head(int i)
	
	public void insert_nth(int input, int index) {

		if (index == 0) {
			insert_head(input);
		} else {
			Node temp1 = node(index -1);
			
			// Specify the i-th node as temp2
			Node temp2 = temp1.next;
			
			// Create newNode
			Node newNode = new Node(input);
			
			// Specify the newNode as the next node in temp1
			temp1.next = newNode;
			
			// Specify temp2 as the next node of the newNode.
			newNode.next = temp2;
			
			size++;
			
			// If there is no next node of the newNode, the newNode is the last node
			if(newNode.next == null) {
				tail = newNode;
			}
		} // End of if/else
		
	} // End of insert_nth(int input, int index)
	
	// Return Node
	Node node (int index) {
		Node x = head;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	} // End of node (int index)
	
	public boolean search(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node newNode = head;
		
		for (int i = 0; i < index; i++) {
			newNode = newNode.next;
		}
		return true;
	} // End of search(int index)

	public int get_nth(int i) {
		Node newNode = head;
		int count = 0;
		
		while (newNode != null) {
			return newNode.data;
		}
		count++;
		newNode = newNode.next;
		assert(false);
		return 0;
	} // End of get_nth(int i)

	public void delete() {
		// Find the second last node
		Node newNode = head;
		
		while (newNode.next.next != null) {
			newNode = newNode.next;
		}
		
		newNode.next = null;
		
		size--;
		
	}
	
	public void delete_head() {
		// Designate the first node as temp and change the value of head to the second node.
		Node temp = head;
		head = temp.next;
		
		// Before deleting data, store the value to be returned in a temporary variable
		Object returnData = temp.data;
		temp = null;
		
		size--;

	} // End of delete_head()

	public void delete_nth(int i) {		
		
		Node temp = node(i-1);
		
		Node todoDeleted = temp.next;
		
		temp.next = temp.next.next;
		
		Object returnData = todoDeleted.data;
		
		if(todoDeleted == tail) {
			tail = temp;
		}
		
		todoDeleted = null;
		size--;
		
		
	} // End of delete_nth(int i)

	public void clear() {
		head = null;
		tail = null;
		size = 0;
	} // End of clear()
	
	public String toString() {
		// If there's no node, return []
		if (head == null) {
			return "[]";
		}
		
		// Searching
		Node temp = head;
		String str = "[";
		
		// Run repeat statements until there is no next node
		// Since the last node does not have the next node, the syntax below excludes the last node
		while(temp.next != null) {
			str += temp.data + " -> ";
			temp = temp.next;
		}
		
		// Include the last node in the output result
		str += temp.data;
		return str + "]";
		
	} // End of toString()


} // End of class SinglyLinkedList
