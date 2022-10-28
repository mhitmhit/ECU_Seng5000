package A4_Q3;

public class Recursive_Char_Repeater {
	/**
	 * String builder string to store the newly
	 * created repeated String
	 */
	static StringBuilder returnValue = new StringBuilder();
	
	/**
	 * 
	 * @param word which letters need to be repeated
	 * @return returnValue String
	 */
	private static StringBuilder Repeat_Char(String word) {
		if (word.length()==0) {
			return returnValue;
		} else {
			returnValue.append(word.charAt(0));
			returnValue.append(word.charAt(0));
			Repeat_Char(word.substring(1));
		}
		return returnValue;
    }
    
 
    
	public static void main(String[] args) {
		
		// testing 
		System.out.println(Repeat_Char("seng")); // expecting sseenngg
		System.out.println(Repeat_Char("")); // expecting blank
		
	}

}
