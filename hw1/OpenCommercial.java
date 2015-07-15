/**
 * Berkeley CS61B 2014 Spring HW1 - 1
 * OpenCommercial.java
 * @author Qiannan Ling
 */

import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */
class OpenCommercial {

    /** Prompts the user for the name X of a company (a single string), opens
     *  the Web site corresponding to www.X.com, and prints the first five lines
     *  of the Web page in reverse order.
     *  @param arg is not used.
     *  @exception Exception thrown if there are any problems parsing the 
     *             user's input or opening the connection.
     */
    public static void main(String[] arg) throws Exception {

        BufferedReader keyboard;
        String inputLine;

        keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter the name of a company (without spaces): ");
        System.out.flush();        /* Make sure the line is printed immediately. */
        inputLine = keyboard.readLine();
        
        String[] content = new String[5];
        
        // Create a url object
        URL url = new URL("http://www." + inputLine + ".com/");
        // Create a urlconnection object
        URLConnection urlConnection = url.openConnection();
        // Wrap the urlconnection in a bufferedreader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        /*
         * Alternative for read content from url:
         * Use URL directly instead of URLConnection:
         *   BufferedReader urlReader = new BufferedReader(new InputStreamReader(url.openStream()));
         * The url.openStream() is just a shortcut for urlConnection.getInputStream() 
         * (you could tell from the official documentation)
         */

        String line;
        // Read from the urlconnection via the bufferedreader
        for (int i = 0; i < content.length; i++) {
            line = bufferedReader.readLine();
            content[i] = line;
        }
        bufferedReader.close();
        
        // Print out the content
        for (int i = content.length; i > 0; i--) {
            System.out.println(content[i-1]);
        }
    }
}