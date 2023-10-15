// Students, please implement this class

/**
 * A FrequencyTable stores a set of characters each of which has
 * an associated integer frequency
 */

import structure5.*;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

public class FrequencyTable {

  public Hashtable<Character,Integer> letterTable;
  public int maxValue = 0;

  /** Construct an empty FrequencyTable */
  public FrequencyTable() {
    maxValue = 0;
    letterTable = new Hashtable<Character,Integer>();
  }

  /** add(char ch)
   * If ch is in the FrequencyTable, increment its associated frequency
   * Otherwise add ch to FrequencyTable with frequency 1a
   * 
   * @param ch is the String to add to the FrequencyTable
   */
  public void add(char ch) {
    
    // Check if the FrequencyTable contains the key already. If it does, increment the current value and total value by 1.
    if (letterTable.containsKey(ch)) {
      letterTable.put(ch, letterTable.get(ch) + 1);
      maxValue++;
    } else {
      // If the FrequencyTable doesn't have the key currently, then add the character to the table with a value of 1 and
      // increment the total by 1.
      letterTable.put(ch, 1);
      maxValue++;
    }
  }

  /** Selects a character from this FrequencyTable with probabality equal to its relative frequency.
   * 
   * @return a character from the FrequencyTable
   */
  public char choose() {
    // Get a random number from 1 to the "max" amount of values we have.
    Random r = new Random();
    int selectedValue = r.nextInt(1, maxValue + 1);

    // Loop through every key and get its current frequency. Subtract from the selectedValue (random number).
    // When selectedValue is at 0 or below, that means that the number selected falls into the range of that character.
    // Thus, return the current character.
    for (char current : letterTable.keySet()) {
      selectedValue = selectedValue - letterTable.get(current);
      if (selectedValue <= 0) {
        return current;
      }
    }
    return ' ';
  }

  /** Produce a string representation of the FrequencyTable 
   * 
   * @return a String representing the FrequencyTable
   */
  public String toString() {

    // Mostly formatting. Create a holder variable to add to later.
    String holder = "Frequency Table\n------------------\n";

    //Iterate through the keys and format it. Get the current key and the current frequency and add it to holder
    for (char current : letterTable.keySet()) {
      holder += "'" + current + "' has " + letterTable.get(current) + " occurances.\n";
    }

    // Close holder's table (formatting) and return it.
    holder += "------------------\n";
    return holder;
  }

  // Use main to test your FrequencyTable class
  public static void main(String[] args) {
    FrequencyTable test = new FrequencyTable();
    test.add('a');
    test.add('a');
    test.add('a');
    test.add('a');
    test.add('a');
    test.add('a');
    test.add('a');
    test.add('a');
    test.add('a');
    test.add('a');
    test.add('b');
    test.add('c');
    test.add('d');
    System.out.println(test.choose());
    System.out.println(test.toString());
  }

}
