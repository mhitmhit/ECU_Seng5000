package A6_Q8;

public class AVLTree_Driver {

	public static void main(String[] args) {
		// Integer AVL Tree
		AVLTree<Integer> myTestTree1 = new AVLTree<Integer>();
		myTestTree1.add(10);
		myTestTree1.add(20);
		myTestTree1.add(30);
		myTestTree1.add(40);
		myTestTree1.add(50);
		myTestTree1.add(60);
		myTestTree1.add(70);
		myTestTree1.add(55);
		myTestTree1.add(53);
		System.out.println(myTestTree1);
		System.out.println("------------------------------------------------");
		
		// String AVL Tree
		AVLTree<String> myTestTree2 = new AVLTree<String>();
		myTestTree2.add("this");
		myTestTree2.add("is");
		myTestTree2.add("a");
		myTestTree2.add("test");
		myTestTree2.add("for");
		myTestTree2.add("avl");
		myTestTree2.add("tree");
		System.out.println(myTestTree2);
		System.out.println("------------------------------------------------");
		
		AVLTree<Integer> myTestTree3 = new AVLTree<Integer>();
		myTestTree3.add(30);
		myTestTree3.add(40);
		myTestTree3.add(15);
		myTestTree3.add(25);
		myTestTree3.add(90);
		myTestTree3.add(80);
		myTestTree3.add(70);
		myTestTree3.add(85);
		myTestTree3.add(15);
		myTestTree3.add(72);
		System.out.println(myTestTree3);
		System.out.println("------------------------------------------------");
	}

}
