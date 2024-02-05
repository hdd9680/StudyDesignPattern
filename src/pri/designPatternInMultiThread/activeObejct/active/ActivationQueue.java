package pri.designPatternInMultiThread.activeObejct.active;

import java.util.LinkedList;
import java.util.Queue;

class ActivationQueue {

    private static final int MAX_METHOD_REQUEST = 100;
    private final Queue<MethodRequest> requestQueue;

    public ActivationQueue() {
        this.requestQueue = new LinkedList<MethodRequest>();

    }

    public synchronized void putRequest(MethodRequest methodRequest) {
        while(requestQueue.size() > MAX_METHOD_REQUEST) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        requestQueue.add(methodRequest);
        notifyAll();
    }

    public synchronized MethodRequest takeRequest() {
        while(requestQueue.size() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        MethodRequest request = requestQueue.poll();
        notifyAll();
        return request;
    }

}
