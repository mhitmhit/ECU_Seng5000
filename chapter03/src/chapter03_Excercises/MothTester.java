package chapter03_Excercises;

public class MothTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Moth moth1 = new Moth(10);
		System.out.println(moth1.getPosition());
		moth1.moveToLight(20);
		System.out.println(moth1.getPosition());
	}

}
