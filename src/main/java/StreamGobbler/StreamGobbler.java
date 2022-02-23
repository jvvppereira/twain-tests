package StreamGobbler;

import DefaultStreamGobblerPrinter.DefaultStreamGlobberPrinter;
import StreamGlobberPrinter.StreamGlobberPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamGobbler extends Thread {

    InputStream is;
    String type;
    StreamGlobberPrinter printer;
    public StreamGobbler(InputStream is, String type) {
        this(is, type, new DefaultStreamGlobberPrinter());
    }
    public StreamGobbler(InputStream is, String type, StreamGlobberPrinter printer) {
        this.is = is;
        this.type = type;
        this.printer = printer;
    }

    @Override
    public void run() {
        String preAppendedStatus = type == null ? "" : type + ">";
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                printer.printLog(preAppendedStatus + line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}