import java.io.File;
import java.io.IOException;

public class FileCheck {
    public void checkMbFiles() {
        File file = new File("D:\\JAVA");
        String[] files = file.list();
        int length2 = files.length;
        int lenght = 0;
        for (String fileName : files) {
            lenght += fileName.length();
            System.out.println(fileName.length());
        }
        System.out.println(lenght);
        System.out.println(length2);
    }
}
