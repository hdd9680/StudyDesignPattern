package pri.designPatternInMultiThread.guardedSuspension;

public class Request {

    private final String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "[ Request " + name + " ]";
    }

}
