package pri.designPatternInMultiThread.future;

public class Main {

    public static void main (String[] args) throws Exception {
        System.out.println("main BEGIN");
        Host host = new Host();
        Data data1 = host.request(-1, 'A');
        Data data2 = host.request(20, 'B');
        Data data3 = host.request(30, 'C');

        System.out.println("main OtherJob BEGIN");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("main otherJob END");

        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());
        System.out.println("main END");
    }
}
