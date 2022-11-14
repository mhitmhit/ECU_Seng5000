package A5_Q1_V2;


public class Driver_Yassine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> gTree = new BinaryTree<>("G");
		// Subtrees:
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);
		// Root
		BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);
		

		

		//aTree.setTree("A", bTree, cTree);	
		
		System.out.println("\nTree 1:\n");
		System.out.println("     A      ");
		System.out.println("   /   \\   "); // '\\' is the escape character for backslash
		System.out.println("  B     C   ");
		System.out.println(" / \\   / \\");
		System.out.println("D   E  F  G ");
		System.out.println();
		
//		System.out.println(aTree.getData());
//		System.out.println(aTree.getLeftSubtree().getData());
//		System.out.println(dTree.getLeftSubtree());
		System.out.println(aTree.root.toString());
		
		// PreOrder Traverse testing:
//		System.out.println("PreOrder method from A should return: A, B, D, E, C, F, G");
//		aTree.preOrderTraverse();
//		System.out.println("PreOrder method from B should return: B, D, E");
//		bTree.preOrderTraverse();
		
		// InOrder Traverse testing:
		System.out.println("InOrder method from A should return: D, B, E, A, F, C, G");
		aTree.inOrderTraverse();
		System.out.println("InOrder method from B should return: D, B, E");
		bTree.inOrderTraverse();
	}

}
