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
				 * 현재의 루트보다 작은 경우, 왼쪽으로 탐색을 한다.
				 */
				if (head.data > i) {
					head = head.left;

					/*
					 * 왼쪽 자식 노드가 비어있는 경우, 해당 위치에 추가할 노드를 삽입한다. 현재 currenNode head를 가리키고 있다.
					 */
					if (head == null) {
						currentNode.left = new Node(i);
						break;
					}
				} else {
					/*
					 * 현재의 루트보다 큰 경우, 오른쪽으로 탐색을 한다.
					 */
					head = head.right;

					/*
					 * 오른쪽 자식 노드가 비어있는 경우, 해당 위치에 추가할 노드를 삽입한다. 현재 currenNode head를 가리키고 있다.
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

			/* 삭제할 값이 현재 노드보다 작으면 왼쪽을 탐색한다. */
			if (removeNode.data > i) {
				removeNode = removeNode.left;
			} else {
				removeNode = removeNode.right;
			}

			/*
			 * 값 대소를 비교하며 탐색했을 때 잎 노드(Leaf node)인 경우 삭제를 위한 탐색 실패
			 */
			if (removeNode == null)
				return false;

		} // end of while

		/* 자식 노드가 모두 없을 때 */
		if (removeNode.left == null && removeNode.right == null) {
			/* 삭제 대상이 트리의 루트일 때 */
			if (removeNode == root) {
				root = null;
			} else if (removeNode == parentOfRemoveNode.right) {
				parentOfRemoveNode.right = null;
			} else {
				parentOfRemoveNode.left = null;
			}
		} // end of if

		/* 오른쪽 자식 노드만 존재하는 경우 */
		else if (removeNode.left == null) {
			if (removeNode == root) {
				root = removeNode.right;
			} else if (removeNode == parentOfRemoveNode.right) {
				/*
				 * 삭제 대상의 오른쪽 자식 노드를 삭제 대상 위치에 둔다.
				 */
				parentOfRemoveNode.right = removeNode.right;
			} else {
				parentOfRemoveNode.left = removeNode.right;
			}
		} // end of else if

		/* 왼쪽 자식 노드만 존재하는 경우 */
		else if (removeNode.right == null) {
			if (removeNode == root) {
				root = removeNode.left;
			} else if (removeNode == parentOfRemoveNode.right) {
				parentOfRemoveNode.right = removeNode.left;
			} else {
				/*
				 * 삭제 대상의 왼쪽 자식을 삭제 대상 위치에 둔다.
				 */
				parentOfRemoveNode.left = removeNode.left;
			}
		} // end of else if

		/*
		 * 두 개의 자식 노드가 존재하는 경우 삭제할 노드의 왼쪽 서브 트리에 있는 가장 큰 값 노드를 올리거나 오른쪽 서브 트리에 있는 가장 작은
		 * 값 노드를 올리면 된다. 구현 코드는 2번째 방법을 사용한다.
		 */
		else {
			/* 삭제 대상 노드의 자식 노드 중에서 대체될 노드(replaceNode)를 찾는다. */
			Node parentOfReplaceNode = removeNode;

			/* 삭제 대상의 오른쪽 서브 트리 탐색 지정 */
			Node replaceNode = parentOfReplaceNode.right;

			while (replaceNode.left != null) {
				/* 가장 작은 값을 찾기 위해 왼쪽 자식 노드로 탐색한다. */
				parentOfReplaceNode = replaceNode;
				replaceNode = replaceNode.left;
			} // end of while

			if (replaceNode != removeNode.right) {
				/* 가장 작은 값을 선택하기 때문에 대체 노드의 왼쪽 자식은 빈 노드가 된다. */
				parentOfReplaceNode.left = replaceNode.right;

				/* 대체할 노드의 오른쪽 자식 노드를 삭제할 노드의 오른쪽으로 지정한다. */
				replaceNode.right = removeNode.right;
			} // end of if

			/* 삭제할 노드가 루트 노드인 경우 대체할 노드로 바꾼다. */
			if (removeNode == root) {
				root = replaceNode;
			} else if (removeNode == parentOfRemoveNode.right) {
				parentOfRemoveNode.right = replaceNode;
			} else {
				parentOfRemoveNode.left = replaceNode;
			} // end of if

			/* 삭제 대상 노드의 왼쪽 자식을 잇는다. */
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
