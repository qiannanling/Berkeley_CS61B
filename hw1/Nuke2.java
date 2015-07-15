/**
 * Berkeley CS61B 2014 Spring HW1 - 2
 * Nuke2.java
 * @author Qiannan Ling
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A class that provides a function that reads a string from the keyboard and 
 * prints the same string, with its second character removed.
 */
public class Nuke2 {

    /**
     * Take in a word and print the word with the second character removed.
     * It does not print a prompt, and assumes the length of the word is at least 2.
     * @param args is not used
     */
    public static void main(String[] args) {
        BufferedReader keybd = new BufferedReader(new InputStreamReader(System.in));
        try {
            String word = keybd.readLine();
            System.out.println(word.substring(0, 1) + word.substring(2));
            // Could use "word.charAt(0)" instead if only one char is required
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
