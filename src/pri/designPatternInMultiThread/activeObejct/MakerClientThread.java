package pri.designPatternInMultiThread.activeObejct;

import pri.designPatternInMultiThread.activeObejct.active.ActiveObject;
import pri.designPatternInMultiThread.activeObejct.active.Result;

public class MakerClientThread extends Thread {

    private final ActiveObject activeObject;
    private final char fillChar;

    public MakerClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
        this.fillChar = name.charAt(0);
    }

    @Override
    public void run() {
        try {
            for(int i = 0 ; true ; i++) {
                Result result = activeObject.makeString(i, fillChar);
                Thread.sleep(10);
                String value = (String)result.getResultValue();
                System.out.println(Thread.currentThread().getName() + ": value = " + value);
            }
        } catch (InterruptedException e){
        }
    }

}
