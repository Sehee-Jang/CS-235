package edu.ensign.cs235.bst;

public class BinaryTreeOnLinkedList {

	class Node {
		public Node root;

		int data;
		Node left;
		Node right;

		// Constructor
		public Node(int data) {
			this.setData(data);
			setLeft(null);
			setRight(null);
		}

		public int get_value() {
			return data;
		}

		public void set_value(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	} // end of class Node

	public Node root = null;

	public Node get_root() {
		return root;
	}

	public void put(int i) {
		if (root == null) {
			root = new Node(i);
		} else {
			Node head = root;
			Node currentNode;

			while (true) {
				currentNode = head;

				/*
				 * If it is smaller than the current route, search to the left
				 */
				if (head.data > i) {
					head = head.left;

					/*
					 * If the left child node is empty, insert the node to be added at that location.
					 */
					if (head == null) {
						currentNode.left = new Node(i);
						break;
					}
				} else {
					/*
					 * If it is larger than the current route, search to the right.
					 */
					head = head.right;

					/*
					 * If the right child node is empty, insert the node to be added at that location.
					 */
					if (head == null) {
						currentNode.right = new Node(i);
						break;
					}
				} // end of else

			} // end of while loop

		}
	}

	public boolean remove(int i) {
		if(root == null) {
			System.out.println("No Data");
		}else {
			Node tempNode = root;
			Node preNode = null;
			
			// Searching Node
			while(true) {
				// Duplicate values cannot exist within the node.
				if(tempNode.get_value() == i) {
					break;
				}else if(tempNode.get_value() > i) {
					// Case : Go to the left because the value is small
					if(tempNode.getLeft() == null) {
						System.out.println("No Data");
						break;
					}else {
						preNode = tempNode;
						tempNode = tempNode.getLeft();
					}
				}else {
					// Case : Go to the right because the value is large
					if(tempNode.getRight() == null) {
						System.out.println("No Data");
						break;
					}else {
						preNode = tempNode;
						tempNode = tempNode.getRight();
					}
				}
			}
			
			
			// node to be deleted = tempNode, parent of the node to be deleted = preNode
			if(tempNode.getLeft() == null && tempNode.getRight() == null) {
				// Case : If there are no children on the node to be deleted
				if(preNode.get_value() > tempNode.get_value()) {
					preNode.setLeft(null);
				} else {
					preNode.setRight(null);
				}
			} else if(tempNode.getLeft() != null && tempNode.getRight() != null) {
				// Case : If there're two children on the node to be deleted 
				// The minimum value on the left is to be raised to that value.
				
				Node rightNode = tempNode.getLeft();
				preNode = tempNode;
				while(true) {
					if(rightNode.getRight() ==null) {
						break;
					}
					preNode = rightNode;
					rightNode = rightNode.getRight();
					
				}
				
				tempNode.set_value(rightNode.get_value());
				preNode.setRight(null);
			}else {
				// If there's one child in the node to be deleted, add a value to the node and delete the bottom.
				if(tempNode.getLeft() !=null) {
					tempNode = tempNode.getLeft();
				}else {
					tempNode = tempNode.getRight();
				}
			}	
		}
		return false;

	}

	Node getMinumun(Node deleteNode) {
		Node minimum = null;
		Node minimumParent = null;
		Node currentNode = deleteNode.getRight();
		while (currentNode != null) {
			minimumParent = minimum;
			minimum = minimumParent;
			currentNode = currentNode.getLeft();
		}
		if (minimum != deleteNode.getRight()) {
			minimumParent.setLeft(minimum.getRight());
			minimum.setRight(deleteNode.getRight());
		}
		return minimum;
	}

	public Node find(int i) {
		Node current = this.root;
		while (current.data != i) {
			if (i < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	// root-left-right
	public void pre_order(Node node) {
		// Call resurcive func until node is not null
		if (node != null) {
			// Print itself first
			System.out.print(node.data + " ");
			pre_order(node.left);
			pre_order(node.right);
		}

	}

	// left-root-right
	public void in_order(Node node) {
		// Call recursive func until node is not null
		if (node != null) {
			in_order(node.left);
			// After calling left node, print itself
			System.out.print(node.data + " ");
			// Then, call right node
			in_order(node.right);
		}

	}

	// left-right-root
	public void post_order(Node node) {
		if (node != null) {
			post_order(node.left);
			post_order(node.right);
			System.out.print(node.data + " ");
		}

	}

}
