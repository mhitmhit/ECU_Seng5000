package visibility_and_access_modifies;

public class testClassOne {
	
	String defaultVar = "default varr";
	public String publicVar = "public var";
	private String privateVar = "private var";
	protected String protectedVar = "protected var";
	
	void defaultMethod() {
		System.out.println("inside default Method");
	}
	
	public void publicMethod() {
		System.out.println("inside public Method");
	}
	
	private void privateMethod() {
		System.out.println("inside private Method");
	}
	
	protected void protectedMethod() {
		System.out.println("inside protected Method");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testClassOne obj1 = new testClassOne();
		
		System.out.println(obj1.defaultVar);
		System.out.println(obj1.publicVar);
		System.out.println(obj1.privateVar);
		System.out.println(obj1.protectedVar);
		obj1.defaultMethod();
		obj1.publicMethod();
		obj1.privateMethod();
		obj1.protectedMethod();
		
	}

}
