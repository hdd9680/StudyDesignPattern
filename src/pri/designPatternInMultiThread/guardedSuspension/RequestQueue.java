package pri.designPatternInMultiThread.guardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {

    private final Queue<Request> queue = new LinkedList<>();

    public synchronized Request getRequest() {
        while(queue.size() == 0) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return queue.remove();
    }


    public synchronized void putRequest(Request request) {
        queue.add(request);
        notifyAll();
    }
}
