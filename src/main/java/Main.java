import StreamGobbler.StreamGobbler;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("C:\\Users\\310149649\\Downloads\\Captura v2.exe"
                , "-", "-", "AcquireFrom", "TWAIN2 FreeImage Software Scanner");
        Process proc = builder.start();
        proc.getOutputStream();

        InputStream stdin = proc.getInputStream();
        final StringBuilder sb = new StringBuilder();
        Thread thread = new StreamGobbler(stdin, null, sb::append);
        thread.start();
        proc.waitFor();
        thread.join();
    }
}
