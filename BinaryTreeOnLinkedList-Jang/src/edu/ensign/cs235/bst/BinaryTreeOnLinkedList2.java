package edu.ensign.cs235.bst;

public class BinaryTreeOnLinkedList2 {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public int get_value() {
			return data;
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
				 * ������ ��Ʈ���� ���� ���, �������� Ž���� �Ѵ�.
				 */
				if (head.data > i) {
					head = head.left;

					/*
					 * ���� �ڽ� ��尡 ����ִ� ���, �ش� ��ġ�� �߰��� ��带 �����Ѵ�. ���� currenNode head�� ����Ű�� �ִ�.
					 */
					if (head == null) {
						currentNode.left = new Node(i);
						break;
					}
				} else {
					/*
					 * ������ ��Ʈ���� ū ���, ���������� Ž���� �Ѵ�.
					 */
					head = head.right;

					/*
					 * ������ �ڽ� ��尡 ����ִ� ���, �ش� ��ġ�� �߰��� ��带 �����Ѵ�. ���� currenNode head�� ����Ű�� �ִ�.
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
		Node removeNode = root;
		Node parentOfRemoveNode = null;

		while (removeNode.data != i) {
			parentOfRemoveNode = removeNode;

			/* ������ ���� ���� ��庸�� ������ ������ Ž���Ѵ�. */
			if (removeNode.data > i) {
				removeNode = removeNode.left;
			} else {
				removeNode = removeNode.right;
			}

			/*
			 * �� ��Ҹ� ���ϸ� Ž������ �� �� ���(Leaf node)�� ��� ������ ���� Ž�� ����
			 */
			if (removeNode == null)
				return false;

		} // end of while

		/* �ڽ� ��尡 ��� ���� �� */
		if (removeNode.left == null && removeNode.right == null) {
			/* ���� ����� Ʈ���� ��Ʈ�� �� */
			if (removeNode == root) {
				root = null;
			} else if (removeNode == parentOfRemoveNode.right) {
				parentOfRemoveNode.right = null;
			} else {
				parentOfRemoveNode.left = null;
			}
		} // end of if

		/* ������ �ڽ� ��常 �����ϴ� ��� */
		else if (removeNode.left == null) {
			if (removeNode == root) {
				root = removeNode.right;
			} else if (removeNode == parentOfRemoveNode.right) {
				/*
				 * ���� ����� ������ �ڽ� ��带 ���� ��� ��ġ�� �д�.
				 */
				parentOfRemoveNode.right = removeNode.right;
			} else {
				parentOfRemoveNode.left = removeNode.right;
			}
		} // end of else if

		/* ���� �ڽ� ��常 �����ϴ� ��� */
		else if (removeNode.right == null) {
			if (removeNode == root) {
				root = removeNode.left;
			} else if (removeNode == parentOfRemoveNode.right) {
				parentOfRemoveNode.right = removeNode.left;
			} else {
				/*
				 * ���� ����� ���� �ڽ��� ���� ��� ��ġ�� �д�.
				 */
				parentOfRemoveNode.left = removeNode.left;
			}
		} // end of else if

		/*
		 * �� ���� �ڽ� ��尡 �����ϴ� ��� ������ ����� ���� ���� Ʈ���� �ִ� ���� ū �� ��带 �ø��ų� ������ ���� Ʈ���� �ִ� ���� ����
		 * �� ��带 �ø��� �ȴ�. ���� �ڵ�� 2��° ����� ����Ѵ�.
		 */
		else {
			/* ���� ��� ����� �ڽ� ��� �߿��� ��ü�� ���(replaceNode)�� ã�´�. */
			Node parentOfReplaceNode = removeNode;

			/* ���� ����� ������ ���� Ʈ�� Ž�� ���� */
			Node replaceNode = parentOfReplaceNode.right;

			while (replaceNode.left != null) {
				/* ���� ���� ���� ã�� ���� ���� �ڽ� ���� Ž���Ѵ�. */
				parentOfReplaceNode = replaceNode;
				replaceNode = replaceNode.left;
			} // end of while

			if (replaceNode != removeNode.right) {
				/* ���� ���� ���� �����ϱ� ������ ��ü ����� ���� �ڽ��� �� ��尡 �ȴ�. */
				parentOfReplaceNode.left = replaceNode.right;

				/* ��ü�� ����� ������ �ڽ� ��带 ������ ����� ���������� �����Ѵ�. */
				replaceNode.right = removeNode.right;
			} // end of if

			/* ������ ��尡 ��Ʈ ����� ��� ��ü�� ���� �ٲ۴�. */
			if (removeNode == root) {
				root = replaceNode;
			} else if (removeNode == parentOfRemoveNode.right) {
				parentOfRemoveNode.right = replaceNode;
			} else {
				parentOfRemoveNode.left = replaceNode;
			} // end of if

			/* ���� ��� ����� ���� �ڽ��� �մ´�. */
			replaceNode.left = removeNode.left;
		} // end of else
		return true;
	}

	public Node find(int i) {
		Node current = this.root;
	    while(current.data != i){
	      if(i < current.data){
	        current = current.left;
	      }
	      else{
	        current = current.right;
	      }
	      if(current == null){
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
