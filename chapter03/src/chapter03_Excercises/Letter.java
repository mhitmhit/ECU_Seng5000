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
		letter = receiver.concat("\n\n") + "[blank]\n\n" + sender;
	}
	
	public void addLine(String line) {
		body = body.concat(line).concat("\n");
		letter = receiver.concat("\n\n") + body.concat("\n") + sender;
	}
	
	public String getText() {
		return letter;
	}
	
	public void letterPrinter() {
		System.out.println(letter);
	}
}
