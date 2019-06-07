import java.io.*;
public class OpenFile {
    public static void streamCopy(InputStream is, OutputStream os) throws IOException {
        if (is == null || os == null){
            throw new IllegalArgumentException("Null stream pointer");
        }

        byte [] buffer = new byte[1024 * 1024];
        int readByte = 0;

        for (; (readByte = is.read(buffer)) > 0;){
            os.write(buffer, 0, readByte);
        }
    }

    public static void fileCopy(File in, File out) throws IOException{
        try(InputStream is = new FileInputStream(in);
            OutputStream os = new FileOutputStream(out)) {
            streamCopy(is, os);
        } catch(IOException e){
            throw e;
        }
    }
}
