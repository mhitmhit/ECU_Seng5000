package chapter03_Excercises;

public class Letter {
	
	private String body;
	private String sender;
	private String receiver;
	private String letter;
	
	public Letter (String from, String to) {
		sender = "sincerly,\n\n".concat(from);
		receiver = "Dear " + to + ":";
		body = "";
		letter = receiver+"\n" + body + "\n" + sender;
		
	}
	
	public void addLine(String line) {
		body = body.concat(line);
		System.out.println(body);
	}
	
	public String getText() {
		return letter;
	}
	
	public void letterPrinter() {
		System.out.println(letter);
	}
}
