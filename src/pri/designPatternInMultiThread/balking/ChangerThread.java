package pri.designPatternInMultiThread.balking;

import java.util.Random;

public class ChangerThread extends Thread {

    private Data data;
    private Random random = new Random();

    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for(int i = 0 ;; i++){
                data.change("NO. " + i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        } catch (Exception e) {

        }
    }
}
