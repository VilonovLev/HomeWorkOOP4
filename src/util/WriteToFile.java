package util;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void write(String string, String fileName) {
        try (FileWriter fw = new FileWriter(fileName,false)) {
            fw.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
