package A3_Q2;

public class TestPhoneDirectory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		PhoneDirectory phoneDir = new PhoneDirectory();
		
		System.out.println(phoneDir.addOrChangeEntry("zero", "0"));
		System.out.println(phoneDir.addOrChangeEntry("zero", "0000"));
		System.out.println(phoneDir.addOrChangeEntry("zero", "0"));	
		phoneDir.addOrChangeEntry("one", "1");
		phoneDir.addOrChangeEntry("two", "2");
		phoneDir.addOrChangeEntry("three", "3");
		phoneDir.addOrChangeEntry("four", "4");
		
		System.out.println("directory size is: " + phoneDir.getDirectory().size());
		
		
		System.out.println(phoneDir.removeEntry("zero1"));
		System.out.println("directory size is: " + phoneDir.getDirectory().size());
		
		
		
		
	}

}
