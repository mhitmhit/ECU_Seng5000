package A6_Q6;

public class MergeSort_Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] items = new Integer[8];
		items[0] = 5;
		items[1] = 100;
		items[2] = 51;
		items[3] = 110;
		items[4] = 15;
		items[5] = 150;
		items[6] = 1;
		items[7] = 0;
		
		MergeSort test1 = new MergeSort();

		System.out.println("before MergeSort the array is:");
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i]+" ");
		}
		System.out.println("");
		System.out.println("-----------------------------");
//		after sorting
//		System.out.println("after sorting the array is:");
		test1.sort(items);
//		for (int i = 0; i < items.length; i++) {
//			System.out.print(items[i]+" ");
//		}
		
		
	}

}
