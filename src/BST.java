public class BST {

	BSTNode rootNode;

	public BST(int i) {
		rootNode = new BSTNode(i);
	}

	public void addNode(int i) {
		BSTNode currentNode = rootNode;
		boolean finished = false;
		do {
			BSTNode curLeftNode = currentNode.leftNode;
			BSTNode curRightNode = currentNode.rightNode;
			int curIntData = currentNode.intData;

			if (i > curIntData) {
				if (curRightNode == null) { // create a new node referenced with currentNode.rightNode
					currentNode.rightNode = new BSTNode(i);
					finished = true;
				} else { // keep looking by assigning a new current node one level down
					currentNode = currentNode.rightNode;
				}
			} else {
				if (curLeftNode == null) { // create a new node referenced with currentNode.leftNode
					currentNode.leftNode = new BSTNode(i);
					finished = true;
				} else { // keep looking by assigning a new current node one level down
					currentNode = currentNode.leftNode;
				}
			}
		} while (!finished);
	}

	public void traverseAndPrint(BSTNode currentNode) {
		System.out.print("data = " + currentNode.intData);
		
		if (currentNode.leftNode == null) {
			System.out.print(" left = null");
		} else {
			System.out.print(" left = " + (currentNode.leftNode).intData);
		}
		
		if (currentNode.rightNode == null) {
			System.out.print(" right = null");
		} else {
			System.out.print(" right = " + (currentNode.rightNode).intData);
		}
		
		System.out.println("");
		if (currentNode.leftNode != null)
			traverseAndPrint(currentNode.leftNode);
		if (currentNode.rightNode != null)
			traverseAndPrint(currentNode.rightNode);
	}

	public boolean findInt(int i) {
		BSTNode currentNode = rootNode;
		boolean finished = false;
		boolean found = false;
		
		do {
			BSTNode curLeftNode = currentNode.leftNode;
			BSTNode curRightNode = currentNode.rightNode;
			int curIntData = currentNode.intData;

			if (i > curIntData) {
				if (curRightNode == null) {
					finished = true;
				} else {
					currentNode = currentNode.rightNode;
					if(currentNode.intData == i) {
						found = true;
					}
				}
			} else {
				if (curLeftNode == null) {
					finished = true;
				} else {
					currentNode = currentNode.leftNode;
					if(currentNode.intData == i) {
						found = true;
					}
				}
			}
		} while (!finished);
		return found;
	}
}
