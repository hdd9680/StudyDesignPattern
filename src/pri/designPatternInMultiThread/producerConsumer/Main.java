package pri.designPatternInMultiThread.producerConsumer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Table table = new Table(10);

        Thread[] threads = {
                new MakerThread("MakeThread-1", table, 12341234),
                new MakerThread("MakeThread-2", table, 46234523),
                new MakerThread("MakeThread-3", table, 67891243),
                new EaterThread("EaterThread-1", table, 67821367),
                new EaterThread("EaterThread-2", table, 89129012),
                new EaterThread("EaterThread-3", table, 56712367),
                new ClearThread("ClearThread", table)
            };

        for(Thread thread : threads) {
            thread.start();
        }

        Thread.sleep(10000);

        for(Thread thread : threads) {
            thread.interrupt();
        }

    }

}
