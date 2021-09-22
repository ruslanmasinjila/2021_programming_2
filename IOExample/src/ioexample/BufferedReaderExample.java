package ioexample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ruslan
 */

// Demonstrates the reading of lines from a text file
public class BufferedReaderExample {
    
    public static void main(String [] args)
    {
        BufferedReaderExample bfrExample = new BufferedReaderExample();
        
        // Call the readLinesFromFile method and catch all the exceptions thrown by the method
        try {
            bfrExample.readLinesFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Encountered problems while reading the file");

        }
        
        
    }
    
    
    // Note how the file reader is wrapped inside the buffered reader
    public void readLinesFromFile() throws FileNotFoundException, IOException
    {
        BufferedReader bfr;
        bfr = new BufferedReader(new FileReader("SampleText.txt"));
        
        String line="";
        while((line=bfr.readLine())!=null)
        {
            System.out.println(line);
        }
    }
    
}
