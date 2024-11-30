import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class CopyFileSecurity {
    public static void main(String[] args) {
        try {
            copyFileUsingStream("utf8.txt", "UTF-8", "win1251.txt", "WINDOWS-1251");
            System.out.println("File copied successfully");
        } catch (ConvertException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void copyFileUsingStream(String src, String sourseEnc, String dest, String destEnc) throws ConvertException {
        try (Reader fis = new InputStreamReader(new FileInputStream(src), Charset.forName(sourseEnc));
        Writer fos = new OutputStreamWriter(new FileOutputStream(dest), Charset.forName(destEnc));) {
            char[] buf = new char[1024];
            int len;
            while ((len = fis.read(buf)) > 0) {
                fos.write(buf, 0, len);
            }
        } catch (UnsupportedCharsetException e) {
            throw new ConvertException("Encoder problem: " + e.getMessage());
        } catch (FileNotFoundException e) {
            throw new ConvertException("Problem file: " + e.getMessage());
        } catch (IOException e) {
            throw new ConvertException("Err copy: " + e.getMessage());
        }
    }
}

class ConvertException extends Exception {
    ConvertException(String message) {
        super(message);
    }
}
