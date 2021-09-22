
package ioexample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ruslan
 */

// Demonstrates the writing of lines to  a text file
public class BufferedWriterExample {
    
    public static void main(String [] args)
    {
        BufferedWriterExample bfwExample = new BufferedWriterExample();
        
        
        try
        {
           bfwExample.writeLinesToFile();
        }
        catch(IOException e)
        {
            System.out.println("Encountered problems while writing to the file");
        }
    }
    
    // Note how the file writer is wrapped inside the buffered writer
    public void writeLinesToFile() throws IOException
    {
        String line1 = "This is the first line\n";
        String line2 = "This is the second line\n";
        String line3 = "This is the third line\n";
        String lastLine="This is the last line\n";
        
        BufferedWriter bfw;
        bfw = new BufferedWriter(new FileWriter("FromBufferedFileWriter.txt"));
        
        bfw.write(line1);
        bfw.write(line2); 
        bfw.write(line3); 
        bfw.write(lastLine); 
        
        bfw.close();
    }
    
}
