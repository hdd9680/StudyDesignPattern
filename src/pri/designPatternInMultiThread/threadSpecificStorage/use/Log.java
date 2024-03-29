package pri.designPatternInMultiThread.threadSpecificStorage.use;

public class Log {
    private static final ThreadLocal tsLogCollection = new ThreadLocal();

    public static void println(String s) {
        getTSLog().println(s);
    }

    public static void close() {
        getTSLog().close();
    }

    private static TSLog getTSLog() {
        TSLog tsLog = (TSLog) tsLogCollection.get();

        if(tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
            startWatcher(tsLog);
        }

        return tsLog;
    }

    private static void startWatcher(final TSLog tsLog) {
        final Thread target = Thread.currentThread();

        new Thread() {
            @Override
            public void run() {
                System.out.println("startWatcher for " + target.getName() + " BEGIN");
                try {
                    target.join();
                } catch (InterruptedException e) {
                }
                tsLog.close();
                System.out.println("startWatcher for " + target.getName() + " END");
            }
        }.start();
    }

}
