package pri.designPatternInMultiThread.threadPerMessage;

public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("request(" + count + ", " + c + ") BEGIN");
        new HandleThread(helper, count, c).start();
        System.out.println("request(" + count + ", " + c + ") END");
    }

    private static class HandleThread extends Thread {

        private final Helper helper;
        private final int count;
        private final char c;

        public HandleThread(final Helper helper, final int count, final char c) {
            this.helper = helper;
            this.count = count;
            this.c = c;
        }

        @Override
        public void run() {
            helper.handle(count, c);
        }
    }
}
