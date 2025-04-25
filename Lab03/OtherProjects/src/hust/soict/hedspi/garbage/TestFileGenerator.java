package hust.soict.hedspi.garbage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class TestFileGenerator {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe"; 
        int fileSizeInMB = 5;         

        int numBytes = fileSizeInMB * 1024 * 1024; 
        byte[] data = new byte[numBytes];

        Random random = new Random();
        random.nextBytes(data); 

        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(data);
        }

        System.out.println("Tạo file thành công: " + filename + " (" + fileSizeInMB + "MB)");
    }
}
