import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        Time time = new Time();
//        time.getTime();
//        FileCheck checkFile = new FileCheck();
//        checkFile.checkMbFiles();
//        Mathematics math = new Mathematics();
//        math.test();

//        FileInputStream inputStream = new FileInputStream("text.txt");
//        int data = inputStream.read();
//        while (data != -1) {
//            System.out.print((char) data);
//            data = inputStream.read();
//        }
//        inputStream.close();

//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("text1.txt"));
//            String line = reader.readLine();
//            while (line != null) {
//                System.out.println(line);
//                line = reader.readLine();
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        File file = new File("text.txt");
//        FileInputStream fis = new FileInputStream(file);
//        int i;
//        while ((i = fis.read()) != -1) {
//            System.out.print((char) i);
//        }
//        fis.close();
//        System.out.println();

//        File file1 = new File("text1.txt");
//        FileInputStream inputStream = new FileInputStream(file1);
//        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(inputStream);
//        while (byteInputStream.available() > 0) {
//            System.out.print((char) byteInputStream.read());
//        }
//        byteInputStream.close();

//        FileOutputStream fos = new FileOutputStream("text.txt");
//        fos.write("Hello FileOutputStream World".getBytes());
//        fos.close();

        String info1 = "Me need car!!!";
        String info2 = "I want new car!";
        String info3 = "I want new car! Me need car!!!";
        String fileName = "text1.txt";
        WorkFile wf = new WorkFile();
//        wf.fileName = fileName;
//        wf.fileInfo = info1;
//        wf.inputFileInfo(fileName, info2);
//        wf.getFileInfo(fileName);
//        wf.inputFileInfo(info3);
        wf.inputFileInfo();
        wf.getFileInfo();
    }
}