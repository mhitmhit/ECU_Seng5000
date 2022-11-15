package q3Test;

public class TestHashTable {
	public static void main(String[] args) {
		//create an object
		HashtableChain<String, String> hashTable = new HashtableChain<String, String>();
		//put the data into the hash map
		hashTable.put("C", "Carrie");
		hashTable.put("M", "Mike");
		hashTable.put("I", "Ian");
		hashTable.put("S", "Sara");
		hashTable.put("T", "Tim");
		
		String[] keys = { "C", "M", "I", "S", "T"};
		
		for (int i = 0; i < keys.length; i++) {
			
			//String nameList = hashTable.get(keys[i]);
			//System.out.println(nameList);
			
			String removeTest = hashTable.remove(keys[3]);
			System.out.println(removeTest);
		        
				//String rehashTest = hashTable.rehash();
				//System.out.println(rehashTest);
		}

	}
	

} 
