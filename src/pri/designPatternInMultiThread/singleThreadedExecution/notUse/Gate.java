package pri.designPatternInMultiThread.singleThreadedExecution.notUse;

public class Gate {

    private int counter = 0;
    private String name;
    private String address;

    public void pass(String name, String address) {
        this.counter++;
        this.name = name;
        try {
            Thread.sleep(1);    // 스레드 충돌이 더 잘 발생하라고 넣는코드
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.address = address;
        check();
    }

    private void check() {
        if(name.charAt(0) != address.charAt(0)) {
            System.out.println("****** BROKEN ****** " + toString());
        }
    }

    @Override
    public String toString() {
        return "No. " + counter + ": " + name + ", " + address;
    }

}