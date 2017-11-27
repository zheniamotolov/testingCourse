package classses;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;


public class FileTextReader {
    private Scanner scan;

    FileTextReader() {
        scan = null;
    }

    public String[] readFromFile(String pathToFile) {
        StringBuilder string = new StringBuilder("");
        String arrayOfValues[];
        try {
            scan = new Scanner(new FileReader(pathToFile));
            while (scan.hasNext()) {
                string.append(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } finally
        {
            if (scan != null) {
                scan.close();
            }
        }
        arrayOfValues = parseToStringArray(string);
        //  string = parseToStringArray(string);
        return arrayOfValues;
    }
    private String[] parseToStringArray(StringBuilder string) {
        String stringArrayOfValues[] = null;
        try {
            stringArrayOfValues = string.toString().split(",");
        } catch (Exception e) {
            System.err.println("problems with data in file, probably wrong format of text data");
        }
        return stringArrayOfValues;
    }

}
