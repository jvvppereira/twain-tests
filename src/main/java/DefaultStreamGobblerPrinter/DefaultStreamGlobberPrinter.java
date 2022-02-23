package DefaultStreamGobblerPrinter;

import StreamGlobberPrinter.StreamGlobberPrinter;

public class DefaultStreamGlobberPrinter implements StreamGlobberPrinter {

    @Override
    public void printLog(final String log) {
        System.out.println(log);
    }

}
