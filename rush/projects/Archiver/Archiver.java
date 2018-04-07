import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args){
        try {
            System.out.println("Input full path to destination archive file:");
            BufferedReader consoleReader=new BufferedReader(new InputStreamReader(System.in));
            ZipFileManager zipFileManager=new ZipFileManager(Paths.get(consoleReader.readLine()));
            System.out.println("Input full path to file which need to archive:");
            zipFileManager.createZip(Paths.get(consoleReader.readLine()));
            consoleReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
