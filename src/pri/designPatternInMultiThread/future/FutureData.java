package pri.designPatternInMultiThread.future;

import java.lang.reflect.InvocationTargetException;

public class FutureData implements Data {

    private RealData realdata;
    private InvocationTargetException e;
    private boolean ready = false;

    @Override
    public synchronized String getContent() throws InvocationTargetException {
        while(!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        if(e != null) {
            throw e;
        }

        return realdata.getContent();
    }

    public synchronized  void setRealData(RealData realdata) {
        if(ready) {
            return;
        }
        this.realdata = realdata;
        this.ready = true;
        notifyAll();
    }

    public synchronized void setException(Throwable throwable) {
        if(ready) {
            return;
        }
        this.e = new InvocationTargetException(throwable);
        this.ready = true;
        notifyAll();
    }
}
