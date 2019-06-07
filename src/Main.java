import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MyFileFiltr mFF = new MyFileFiltr("docx");
        File folder = new File("/Users/nataliadanilenko/Desktop");

        File folder_copy = new File("myFolder_copy");
        folder_copy.mkdirs(); // створюємо директорію myFolder_copy

        File[] fileList = folder.listFiles(mFF); // файли з потрібним розширенням тут
        for (File file : fileList) {
            File copy = new File("myFolder_copy/" + file.getName());
            try {
                OpenFile.fileCopy(file, copy);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

