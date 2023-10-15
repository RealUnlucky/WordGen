// Students, please implement this class

import java.util.Scanner;
import structure5.*;

public class WordGen {
    public static Table data = new Table();
    public static int k = 2;

    /**
     * A method to randomly generate a String based on a given set of data (Hashtable and a text file).
     * 
     * @param in is the text that we were given. Only used for the first k characters.
     * @param max is the amount of charaters we want to generate.
     * @param data is the table that we are getting our data and values from.
     */

    public static String generate(String in, int max, Table data) {
        // Get the first k letters from the text. Helps guarantee accuracy later on.
        String holder = in.substring(0, k);

        // Create a temp char variable to check in case the code goes wrong.
        Character temp = ' ';

        // Loop to the "max" - which is a user input for the desired amount of generated characters.
        for (int i = 0; i < max + k; i++) {

            // Get a char from the data based on the recent k letters of holder (what we are currently building).
            temp = data.choose(holder.substring(i, i + k));

            // If the temp is '@' -- an error is detected (there is no associated value for the substring) and the code will delete the last k
            // letters and restart from there to try and avoid the error.
            if (temp == '@') {
                holder = holder.substring(0, holder.length() - k);
                i -= k;
                temp = data.choose(holder.substring(i, i + k));
            }
            
            // When temp is good (and not an error), add temp to holder.
            holder += temp;
        }
        return holder;
    }
    public static void main(String[] args) {
        // If user inputs a value for k, incorporate that value into k.
        if (args.length > 0) {
            k = Integer.valueOf(args[0]);
        }

        // Scan the inputted text and store it in a text variable.
        Scanner in = new Scanner(System.in);
        StringBuffer textBuffer = new StringBuffer();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            textBuffer.append(line);
            textBuffer.append(" ");
        }

        String text = textBuffer.toString();
        
        // Add the text to the data. Loop through the entire text length and check every k letters
        // and input the character at k + 1 (right after the substring that we look at).
        String current = "";
        for (int i = 0; i < text.length() - k; i++) {
            current = text.substring(i, i + k);
            data.add(current, text.charAt(i + k));
        }

        // Code to add the end of the section (when there are less than k letters remaining).
        // Loop around the letters and add the start to the end to create a substring.
        String temp = current;
        for (int i = 0; i < current.length(); i++) {
            temp = temp.substring(i) + temp.substring(0, i);
            data.add(temp, current.charAt(i));
        }

        // Generate 500 characters of a text.
        System.out.println(generate(text, 500, data).substring(k));   
    }
}
