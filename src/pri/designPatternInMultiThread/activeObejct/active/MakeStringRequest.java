package pri.designPatternInMultiThread.activeObejct.active;

class MakeStringRequest extends MethodRequest {

    private final int count;
    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult result, int count, char fillChar) {
        super(servant, result);
        this.count = count;
        this.fillChar = fillChar;
    }

    @Override
    public void execute() {
        Result result = servant.makeString(count, fillChar);
        future.setResult(result);
    }
}
