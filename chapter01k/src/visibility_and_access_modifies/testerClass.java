package visibility_and_access_modifies;

public class testerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testClassOne obj1 = new testClassOne();
		
		System.out.println(obj1.defaultVar);
		System.out.println(obj1.publicVar);
		//System.out.println(obj1.privateVar);
		System.out.println(obj1.protectedVar);
		obj1.defaultMethod();
		obj1.publicMethod();
		//obj1.privateMethod();
		obj1.protectedMethod();
	}

}
