package pri.designPattern.iterpreter.language;

public class CommandNode extends Node {
	
	private Node node;
	
	@Override
	public void parse(Context context) throws ParseException {
		if("repeat".equals(context.currentToken())) {
			node = new RepeatCommandNode();
			node.parse(context);
		} else {
			node = new PrimitiveCommandNode();
			node.parse(context);
		}
	}

	@Override
	public void execute() throws ExecuteException {
		node.execute();
	}
	
	@Override
	public String toString() {
		return node.toString();
	}

}
