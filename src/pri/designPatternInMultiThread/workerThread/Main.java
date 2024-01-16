package pri.designPatternInMultiThread.workerThread;

public class Main {

    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorks();
        ClientThread alice = new ClientThread("Alice", channel);
        ClientThread bobby = new ClientThread("Bobby", channel);
        ClientThread chris = new ClientThread("Chris", channel);

        alice.start();
        bobby.start();
        chris.start();
    }
}
