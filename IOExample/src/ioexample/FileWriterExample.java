package ioexample;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ruslan
 */
// Demonstrates the writing of individual characters to a text file
public class FileWriterExample {

    public static void main(String[] args) {

        FileWriterExample fwExample = new FileWriterExample();

        // Call the writeToFile method and catch all the exceptions thrown by the method
        try {
            fwExample.writeToFile();
        } catch (IOException io) {
            System.out.println("Encountered problems while writing to a file");

        }

    }

    public void writeToFile() throws IOException {

        String toWrite = "Hello World" + "\n"
                + "This will be written to a file" + "\n"
                + "One character at a time" + "\n"
                + "Using File Writer" + "\n";

        // attach a file to FileWriter 
        FileWriter fw = new FileWriter("FromFileWriter.txt");

        // read character wise from string and write 
        // into FileWriter 
        for (int i = 0; i < toWrite.length(); i++) {
            fw.write(toWrite.charAt(i));
        }

        System.out.println("Writing successful");
        fw.close();

    }

}
