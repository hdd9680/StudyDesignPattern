package pri.designPatternInMultiThread.guardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Alice", 123124123L).start();
        new ServerThread(requestQueue, "Bobby", 564732593L).start();
    }

}
