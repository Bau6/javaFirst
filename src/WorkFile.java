import java.io.*;

public class WorkFile {
    public String fileName = "";
    private File file = null;
    public String fileInfo = "";
    public WorkFile() {
        this.fileName = "text.txt";
        this.file = new File(fileName);
        this.fileInfo = "Hello FileOutputStream World";
    }

    public void getFileInfo() throws IOException {
        getFileInfo(this.fileName);
    }

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

    public void inputFileInfo(String fileInfo) throws IOException {
        inputFileInfo(this.fileName, fileInfo);
    }

    public void inputFileInfo() throws IOException {
        inputFileInfo(this.fileName, this.fileInfo);
    }

    public void inputFileInfo(String fileName, String fileInfo) throws IOException {
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(fileInfo.getBytes());
        fos.close();
    }
}
