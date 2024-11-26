import java.io.InputStream;
import java.util.Scanner;

public class Task682 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new OneZeroStream());
        for (int i = 0; i < 10; i++) {
            System.out.print(scanner.nextInt());
        }
    }

    public static class OneZeroStream extends InputStream {
        private final byte[] bytes = {'1', ' ', '0', ' '};
        int i = 0;

        public int read() {
            if (i >= bytes.length) {
                i = 0;
            }
            return bytes[i++];
        }
    }
}
