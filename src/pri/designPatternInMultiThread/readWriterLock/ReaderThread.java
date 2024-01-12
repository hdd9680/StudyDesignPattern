package pri.designPatternInMultiThread.readWriterLock;

public class ReaderThread extends Thread {

    private final Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while(true) {
                char[] readBuffer = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuffer));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
