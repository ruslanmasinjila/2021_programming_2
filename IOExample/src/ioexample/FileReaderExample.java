package ioexample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ruslan
 */
// Demonstrates the reading of individual characters from a text file
public class FileReaderExample {

    // File reader reads one character at a time from a file
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReaderExample frExample = new FileReaderExample();

        // Call the readfile method and catch all the exceptions thrown by the method
        try {
            frExample.readFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Encountered problems while reading the file");

        }
    }

    public void readFromFile() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("SampleText.txt");
        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println("Reading Successful");
        fr.close();

    }

}
