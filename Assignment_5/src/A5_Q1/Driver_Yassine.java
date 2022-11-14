package A5_Q1;


public class Driver_Yassine {

	/**
	 * Driver class to test Binary Tree
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree<String> aTree = new BinaryTree<>();
		
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> gTree = new BinaryTree<>("G");
	
		// Subtrees:
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);
	
		aTree.setTree("A", bTree, cTree);	
		
		System.out.println("\nTree 1:\n");
		System.out.println("     A      ");
		System.out.println("   /   \\   "); // '\\' is the escape character for backslash
		System.out.println("  B     C   ");
		System.out.println(" / \\   / \\");
		System.out.println("D   E  F  G ");
		System.out.println();
		
		// PreOrder Traversal Testing:
		System.out.println("	PreOrder Testing: ");
		System.out.println("PreOrder Traverse expected result: " +"A B D E C F G");
		System.out.print("PreOrder Traverse using PreOrder Itirator: ");
		aTree.iterativePreorderTraverse();
		System.out.println();
		aTree.preOrderTraverse();
		System.out.println();
		
		// InOrder Traversal Testing
		System.out.println("	InOrder Testing: ");
		System.out.println("InOrder Traverse expected result: " +"D B E A F C G");
		System.out.print("InOrder Traverse using InOrder Itirator: ");
		aTree.iterativeInorderTraverse();
		System.out.println();
		aTree.inOrderTraverse();
		System.out.println();
		
		// PostOrder Traversal Testing
		System.out.println("	PostOrder Testing: ");
		System.out.println("PostOrder Traverse expected result: " +"D E B F G C A");
		aTree.postOrderTraverse();
		System.out.println();
		
		
	}

}
