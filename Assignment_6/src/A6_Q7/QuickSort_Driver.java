package A6_Q7;

public class QuickSort_Driver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] items = new Integer[13];
		items[0] = 55;
		items[1] = 50;
		items[2] = 10;
		items[3] = 40;
		items[4] = 80;
		items[5] = 90;
		items[6] = 60;
		items[7] = 100;
		items[8] = 70;
		items[9] = 80;
		items[10] = 20;
		items[11] = 50;
		items[12] = 22;
		
		
		YassineQuickSort test1 = new YassineQuickSort();
		//before sorting
		System.out.println("before sorting the array is:");
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i]+" ");
		}
		System.out.println("");
		//after sorting
		System.out.println("-----------------------------");
		//System.out.println("after sorting the array is:");
		test1.quickSort(items, 0, 12);
		
//		for (int i = 0; i < items.length; i++) {
//			System.out.print(items[i]+" ");
//		}
	}
}
