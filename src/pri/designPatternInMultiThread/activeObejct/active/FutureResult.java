package pri.designPatternInMultiThread.activeObejct.active;

class FutureResult extends Result {

    private Result result;
    private boolean ready = false;

    public synchronized void setResult(Result result) {
        this.result = result;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized Object getResultValue() {
        while(!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        return result.getResultValue();
    }

}
