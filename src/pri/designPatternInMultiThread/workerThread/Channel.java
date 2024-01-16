package pri.designPatternInMultiThread.workerThread;

import java.util.ArrayDeque;
import java.util.Queue;

public class Channel {
    private static final int MAX_REQUEST = 100;
    private final Queue<Request> requestQueue = new ArrayDeque<>(MAX_REQUEST);
    private int count = 0;

    private final WorkerThread[] threadPool;

    public Channel(int threadCount) {
        this.threadPool = new WorkerThread[threadCount];
        for(int i = 0 ; i < threadPool.length ; i++) {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    public void startWorks() {
        for(WorkerThread workerThread : threadPool) {
            workerThread.start();
        }
    }

    public synchronized void putRequest(Request request) {
        while(count >= MAX_REQUEST) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        requestQueue.add(request);
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest() {
        while(requestQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        Request request = requestQueue.poll();
        count--;
        notifyAll();
        return request;
    }

}
