package pri.designPatternInMultiThread.guardedSuspension;

import java.util.Random;

public class ClientThread extends Thread {

    private Random random;
    private RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        int count = 0;

        while(true) {
            Request request = new Request("NO. " + count);
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.putRequest(request);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (Exception e) {
            }
            count++;
        }
    }
}
