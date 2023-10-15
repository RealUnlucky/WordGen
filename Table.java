// Students, please implement this class

import java.util.Hashtable;
import java.util.Iterator;

import structure5.*;

/**
* A Table holds a collection of strings, each of which has an
* associated FrequencyTable
*/
public class Table {
  
  public Hashtable<String,FrequencyTable> stringTable;
  /** Construct an empty table */
  public Table() {
    stringTable = new Hashtable<String,FrequencyTable>();
  }

  /**
  * Updates the table as follows
  * If key already exists in the table, update its FrequencyTable
  * by adding value to it
  * Otherwise, create a FrequencyTable for key and add value to it
  *
  * @param key is the desired k-letter sequence
  * @param value is the character to add to the FrequencyTable of key
  */
  public void add(String key, char value) {

    // Check if table contains key. If it does, access the FreqTable inside and add the value to that.
    if (stringTable.containsKey(key)) {
      stringTable.get(key).add(value);
    
      // If the table does not contain the key, create a new hash for the key by making a new FreqTable.
      // Put the key and FreqTable in together, and then make sure to add 1 to the value of the FreqTable.
    } else {
      FrequencyTable tempFT = new FrequencyTable();
      stringTable.put(key, tempFT);
      stringTable.get(key).add(value);
    }
  }

  /**
  * If key is in the table, return one of the characters from
  * its FrequencyTable with probability equal to its relative frequency
  * Otherwise, determine a reasonable value to return
  *
  * @param key is the k-letter sequence whose frequencies we want to use
  * @return a character selected from the corresponding FrequencyTable
  */
  public char choose(String key) {
    // Access the key and choose() from the key's FreqTable.
    Character test = ' ';
    
    // Try to get from the stringTable -- if the key doesn't exist, return a temporary value
    // that indicates to other code that the key we are looking for doesn't have a value.
    try {
      test = stringTable.get(key).choose();
    } catch (Exception NullPointerException) {
      return '@';
    }

    // If a normal value is detected, return the value.
    return test;
  }

  /** Produce a string representation of the Table 
  * 
  * @return a String representing this Table
  */
  public String toString() {
    // Create a holder variable to add to later
    String holder = "";

    // Iterate through the keys and get the toString() of each key's frequency table. Add that to holder.
    for (String current : stringTable.keySet()) {
      holder += "\"" + current + "\" " + stringTable.get(current).toString();
    }

    // Return the completed holder variable.
    return holder;
  }

  // Use main to test your Table class
  public static void main(String[] args) {
    Table test = new Table();
    test.add("the", ' ');
    test.add("the", ' ');
    test.add("the", ' ');
    test.add("the", ' ');
    test.add("the", ' ');
    test.add("the", ' ');
    test.add("the", ' ');
    test.add("the", ' ');
    test.add("the", 'a');
    test.add("the", 'a');
    test.add("the", 'a');
    test.add("the", 'b');
    test.add("the", 'b');
    test.add("the", 'b');
    test.add("the", 'c');
    test.add("the", 'c');
    test.add("the", 'c');
    System.out.println(test.toString());
    test.add("valorant", ' ');
    test.add("valorant", ' ');
    test.add("valorant", ' ');
    test.add("valorant", ' ');
    test.add("valorant", ' ');
    test.add("valorant", ' ');
    test.add("valorant", ' ');
    test.add("valorant", ' ');

    System.out.println(test);
    test.add("valorant", 'a');
    test.add("valorant", 'a');
    test.add("valorant", 'a');
    System.out.println(test.toString());    
    System.out.println(test.choose("the"));
  }
}
