package pri.designPatternInMultiThread.future.practice1.content;

public class AsyncContentImpl implements Content {

    private Content content;
    private boolean isDone = false;

    public synchronized void setContent(Content content) {
        if(isDone) return;

        this.content = content;
        isDone = true;
        notifyAll();
    }

    @Override
    public synchronized byte[] getBytes() {
        while(!isDone) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        return content.getBytes();
    }
}
