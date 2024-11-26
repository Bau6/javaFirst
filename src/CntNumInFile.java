import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class CntNumInFile {
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        FileInputStream fis = new FileInputStream(file);
        int i;
        int count = 0;
        while ((i = fis.read()) != -1) {
            if (isNumeric((char) i)) {
                System.out.print((char) i);
                count++;
            }
        }
        fis.close();
        System.out.println();
        System.out.println(count);
    }

    public static boolean isNumeric(char value) {
        try {
            Double.parseDouble(String.valueOf(value));
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
