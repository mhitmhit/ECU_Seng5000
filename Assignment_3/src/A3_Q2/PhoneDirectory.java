package A3_Q2;

import java.util.ArrayList;

public class PhoneDirectory {
	/**
	 * Array list that holds our data
	 */
	private ArrayList<DirectoryEntry> theDirectory = new ArrayList<>();
    
	/**
     * Method to add new entry if non existent.
     * if entry already exists, update the corresponding phone number
     * 
     * @param aName The name of the person being added or changed
	 * @param newNumber The new number to be assigned
	 * @return The old number, or if a new entry, null
     */
    public String addOrChangeEntry(String aName, String newNumber) {
    	String result = null;
    	
    	// if directory is empty, add entry and return null
    	if (theDirectory.size()==0) {
    		theDirectory.add(new DirectoryEntry(aName, newNumber));
    		return result;
    	}

		// search by name and get index, if none set index to -1
		int index = -1;
		for (int i = 0; i < theDirectory.size(); i++) {
			if (theDirectory.get(i).getName().equals(aName)) {
				index = i;
			}
		}
		
		// if index  = -1, create entry and return null
		if (index == -1) {
			theDirectory.add(new DirectoryEntry(aName, newNumber));
			return result;
		}
		
		// if index >-1, update value at index and return old number
    	result = theDirectory.get(index).getNumber();
    	theDirectory.get(index).setNumber(newNumber);
    	return result;
    }
    
    /** Remove an entry.
    * @param aName The name of the person being removed
    * @return The entry removed, or null if there is no entry for aName
    */
    public DirectoryEntry removeEntry(String aName) {
    	DirectoryEntry entry = null;
    	
    	// if directory is empty, no removal, return null
    	if (theDirectory.size()==0) {
    		return entry;
    	}
    	
    	// search by name and get index, if none set index to -1
    	int index = -1;
    	for (int i = 0; i < theDirectory.size(); i++) {
    		if (theDirectory.get(i).getName().equals(aName)) {
    			index = i;
    		}
    	}
    	
    	// if index  = -1, no removal, return null
    	if (index == -1) {
    		return entry;
    	}
    	
    	// if index >-1, update entry value, remove entry, return removed entry
    	entry = theDirectory.get(index);
    	theDirectory.remove(index);
    	return entry;
    }
    
    /**
     * 
     * for testing purposes.
     * @return our data array list
     */
    public ArrayList<DirectoryEntry> getDirectory() {
    	return theDirectory;
    }
}
