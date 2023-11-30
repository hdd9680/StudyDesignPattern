package pri.designPatternInMultiThread.singleThreadedExecution.notUse;

public class UserThread extends Thread {
    private final Gate gate;
    private final String myName;
    private final String myAddress;

    public UserThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.myName = name;
        this.myAddress = address;
    }

    @Override
    public void run() {
        System.out.println(myName + " BEGIN");
        while(true) {
            gate.pass(myName, myAddress);
        }
    }

}