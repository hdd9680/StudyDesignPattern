package pri.designPatternInMultiThread.balking;

public class Main {

    public static void main(String[] args) {
        Data data = new Data("src/pri/designPatternInMultiThread/balking/data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }

}
