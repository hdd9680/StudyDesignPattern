package pri.designPattern.iterpreter.language;

public class InterpreterFacade {
	
	private ExecutorFactory factory;
	private Context context;
	private Node programNode;
	
	public InterpreterFacade(ExecutorFactory factory) {
		this.factory = factory;
	}
	
	public boolean parse(String text) {
		boolean isOk = true;
		this.context = new Context(text);
		this.context.setExecutorFactory(factory);
		this.programNode = new ProgramNode();
		
		try {
			programNode.parse(context);
			System.out.println(programNode.toString());
		} catch (ParseException e) {
			e.printStackTrace();
			isOk = false;
		}
		
		return isOk;
	}
	
	public boolean execute() {
		boolean isOk = true;
		
		try {
			programNode.execute();
		} catch (ExecuteException e) {
			e.printStackTrace();
			isOk = false;
		}
		
		return isOk;
	}

}
