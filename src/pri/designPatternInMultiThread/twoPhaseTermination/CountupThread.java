package pri.designPatternInMultiThread.twoPhaseTermination;

public class CountupThread extends GracefulThread {

    private int counter;
    private boolean shutdownRequested = false;

    protected void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    protected void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
