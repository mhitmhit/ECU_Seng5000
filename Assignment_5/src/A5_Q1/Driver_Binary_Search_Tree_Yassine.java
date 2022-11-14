package A5_Q1;

public class Driver_Binary_Search_Tree_Yassine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//BinarySearchTree<String> aSearchTree = new BinarySearchTree<String>();
		//aSearchTree.setRootData("A");
		
		// Leaves
		BinarySearchTree<String> dSearchTree = new BinarySearchTree<String>("D", null, null );
		BinarySearchTree<String> eSearchTree = new BinarySearchTree<String>("E", null, null);
		BinarySearchTree<String> fSearchTree = new BinarySearchTree<String>("F", null, null);
		BinarySearchTree<String> gSearchTree = new BinarySearchTree<String>("G", null, null);
		
		// Subtrees:
		BinarySearchTree<String> bSearchTree = new BinarySearchTree<String>("B", dSearchTree, eSearchTree);
		BinarySearchTree<String> cSearchTree = new BinarySearchTree<String>("C", fSearchTree, gSearchTree);
		
		BinarySearchTree<String> aSearchTree = new BinarySearchTree<String>("A", bSearchTree, cSearchTree);
		
		// Test the contains method
		System.out.println("searching a node if it contains the value b: " + aSearchTree.contains("B"));// expecting false
		System.out.println("searching a node it it contains the value a: " + aSearchTree.contains("A"));// expecting true
		
		System.out.println("deleting A                                 : " + aSearchTree.delete("A"));  // expecting A for the item deleted
		
		System.out.println("searching a node if it contains  A         : "+ aSearchTree.contains("A"));// expecting false
		System.out.println("getting data stored in the root node       : " + aSearchTree.getRootData());// expecting E
		
		
		
	}

}
