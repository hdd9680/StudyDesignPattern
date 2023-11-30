package pri.designPattern.iterpreter.language;

public class PrimitiveCommandNode extends Node {

	private String name;
	private Executor executor;
	
	@Override
	public void parse(Context context) throws ParseException {
		name = context.currentToken();
		context.skipToken(name);
		executor = context.createExecutor(name);
		
		if(!"go".equals(name) && !"right".equals(name) && !"left".equals(name)) {
			throw new ParseException(name + " is undefined");
		}
	}

	@Override
	public void execute() throws ExecuteException {
		if(executor == null) {
			throw new ExecuteException(name + ": is not defined");
		}
		
		executor.execute();
	}

	@Override
	public String toString() {
		return name;
	}

}
