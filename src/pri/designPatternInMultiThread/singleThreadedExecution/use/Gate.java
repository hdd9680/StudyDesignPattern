package pri.designPatternInMultiThread.singleThreadedExecution.use;

public class Gate {

    private int counter = 0;
    private String name;
    private String address;

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    private void check() {
        if(name.charAt(0) != address.charAt(0)) {
            System.out.println("****** BROKEN ****** " + toString());
        }
    }

    @Override
    public synchronized String toString() {
        return "No. " + counter + ": " + name + ", " + address;
    }

}