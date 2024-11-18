import java.io.*;
import java.nio.charset.StandardCharsets;

public class WorkFile {
    private String pictureDefault1 = "";
    private String pictureDefault2 = "";
    private String fileName = "";
    private String fileInfo = "";
    private int fileInfoByteA = 0;
    private int intData = 0;
    public WorkFile() {
        this.fileInfoByteA = 65;
        this.intData = 12345;
        this.fileName = "text.txt";
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

    //перегрузка записи в дефолтный файл побайтово дефолтный текст
    public void inputFileInfoByte() throws IOException {
        inputFileInfoByte(this.fileName, this.fileInfoByteA);
    }

    //перегрузка записи в дефолтный файл побайтово
    public void inputFileInfoByte(int fileInfoByteA) throws IOException {
        inputFileInfoByte(this.fileName, fileInfoByteA);
    }

    //метод записи в файл побайтово (!не пашет!)
    public void inputFileInfoByte(String fileName, int fileInfoByteA) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(fileInfoByteA);
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
    }

    //перегрузка считывания целых чисел
    public void readIntDataDataInputStream() throws IOException {
        readIntDataDataInputStream(this.fileName);
    }

    //метод считывания целых чисел
    public void readIntDataDataInputStream(String fileName) throws IOException {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName));
        int data;
        while ((data = inputStream.read()) != -1) {
            System.out.print((char) data);
        }
        inputStream.close();
    }

    //перегрузка записи дефолтных целых чисел в дефолтный файл
//    public void writeIntDataDataInputStream() throws IOException {
//        writeIntDataDataInputStream(this.fileName, this.intData);
//    }

    //перегрузка записи целых чисел в дефолтный файл
//    public void writeIntDataDataInputStream(int intData) throws IOException {
//        writeIntDataDataInputStream(this.fileName, intData);
//    }

    //метод записи целых чисел (!не пашет!)
//    public void writeIntDataDataInputStream(String fileName, int intData) throws IOException {
//        BufferedWriter writer = new BufferedWriter(new DataOutputStream(new FileOutputStream(fileName)));
//        writer.write(intData);
//        writer.flush();
//        writer.close();
//    }

    //перегрузка считывания reader
    public void readDataReader() throws IOException {
        readDataReader(this.fileName);
    }

    //метод считывания reader
    public void readDataReader(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        int data;
        while ((data = fileReader.read()) != -1) {
            System.out.print((char) data);
        }
        fileReader.close();
    }

    //перегрузка считывания reader запись writer дефолтный файл дефолтные данные
    public void writeDataReaderWriter() throws IOException {
        writeDataReaderWriter(this.fileName, this.fileInfo);
    }

    //перегрузка считывания reader запись writer дефолтный файл
    public void writeDataReaderWriter(String fileInfo) throws IOException {
        writeDataReaderWriter(this.fileName, fileInfo);
    }

    //метод считывания reader запись writer
    public void writeDataReaderWriter(String fileName, String fileInfo) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(fileInfo);
        bufferedWriter.close();
    }
}
