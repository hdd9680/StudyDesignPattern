package pri.designPatternInMultiThread.twoPhaseTermination;

public class Main {

    public static void main(String[] args) {
        System.out.println("main : BEGIN");
        try {
            CountupThread countupThread = new CountupThread();
            countupThread.start();
            Thread.sleep(5000);
            System.out.println("main : shutdownRequest");
            countupThread.shutdownRequest();
            System.out.println("main : join");
            countupThread.join();
        } catch (InterruptedException e) {
        }
        System.out.println("main : END");
    }
}
