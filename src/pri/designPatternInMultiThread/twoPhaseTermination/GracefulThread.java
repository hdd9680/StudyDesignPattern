package pri.designPatternInMultiThread.twoPhaseTermination;

public abstract class GracefulThread extends Thread {

    private volatile boolean shutdownRequested = false;

    @Override
    public void run() {
        try {
            while(!shutdownRequested) {
                doWork();
            }
        } catch (InterruptedException e) {
        } finally {
            doShutdown();
        }
    }

    public final void shutdownRequest() {
        shutdownRequested = false;
        interrupt();
    }

    public final boolean isShutdownRequested() {
        return shutdownRequested;
    }

    abstract protected void doWork() throws InterruptedException;

    abstract protected void doShutdown();

}
