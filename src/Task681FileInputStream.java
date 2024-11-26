import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Task681FileInputStream {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("text.txt");
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}