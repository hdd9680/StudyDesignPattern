package pri.designPatternInMultiThread.producerConsumer;

public class ClearThread extends  Thread {

    private final Table table;

    public ClearThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while(true) {
                table.clear();
                System.out.println("========== " + getName() + " clears ==========");
                    sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
