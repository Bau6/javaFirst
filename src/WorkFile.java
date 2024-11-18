import java.io.*;
import java.nio.charset.StandardCharsets;

public class WorkFile {
    private String pictureDefault1 = "";
    private String pictureDefault2 = "";
    private String fileName = "";
    private File file = null;
    private String fileInfo = "";
    public WorkFile() {
        this.fileName = "text.txt";
        this.file = new File(fileName);
        this.fileInfo = "Hello FileOutputStream World";
        this.pictureDefault1 = "picture1.jpg";
        this.pictureDefault2 = "picture2.jpg";
    }

    //перегрузка вывода в консоль содержимого дефолтного файла
    public void getFileInfo() throws IOException {
        getFileInfo(this.fileName);
    }

    //метод вывода в консоль содержимого файла
    public void getFileInfo(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        int i;
        while ((i = fis.read()) != -1) {
            System.out.print((char) i);
        }
        fis.close();
        System.out.println();
    }

    //перегрузка записи дефолтного файла
    public void inputFileInfo(String fileInfo) throws IOException {
        inputFileInfo(this.fileName, fileInfo);
    }

    //перегрузка записи дефолтного файла с дефолтными данными
    public void inputFileInfo() throws IOException {
        inputFileInfo(this.fileName, this.fileInfo);
    }

    //метод записи данных в файл
    public void inputFileInfo(String fileName, String fileInfo) throws IOException {
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(fileInfo.getBytes(StandardCharsets.UTF_8)); // кодировка с поддержкой кириллицы
        fos.close();
    }

    //перегрузка метода копирования файла
    public void copyFile() throws IOException {
        copyFile(this.pictureDefault1, this.pictureDefault2);
    }

    //перегрузка метода копирования файла
    public void copyFile(String source) throws IOException {
        copyFile(source, this.pictureDefault2);
    }

    //метод копирования файла
    public void copyFile(String source, String dest) throws IOException {
        InputStream fis = new FileInputStream(source);
        OutputStream fos = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        fis.close();
        fos.close();
    }
}
