/*<listing chapter="7" section="6">*/
package KW.CH07;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;

/**
 * The interface for the telephone directory.
 * @author Koffman &amp; Wolfgang
 */
public class MapContactList implements ContactListInterface {

    /** The contact list */
    private final Map<String, List<String>> contacts =
            new TreeMap<>();

    /**
     * Add an entry or change an existing entry.
     * @param name The name of the person being added or changed
     * @param newNumbers The new number to be assigned
     * @return The old list of numbers or null if this is a new entry
     */
    @Override
    public List<String> addOrChangeEntry(String name, List<String> newNumbers) {
        List<String> oldNumbers = contacts.put(name, newNumbers);
        return oldNumbers;
    }

    /**
     * Look up an entry.
     * @param name The name of the person to look up
     * @return The number or null if name is not in the directory
     */
    @Override
    public List<String> lookupEntry(String name) {
        return contacts.get(name);
    }

    /**
     * Remove an entry from the directory.
     * @param name The name of the person to be removed
     * @return The current list of numbers. If not in directory, null is
     *         returned
     */
    @Override
    public List<String> removeEntry(String name) {
        return contacts.remove(name);
    }

    /** Displays the contact list in order by name. */
    @Override
    public void display() {
        contacts.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }

// Insert solution to programming project 1, chapter 07 here
}
/*</listing>*/
