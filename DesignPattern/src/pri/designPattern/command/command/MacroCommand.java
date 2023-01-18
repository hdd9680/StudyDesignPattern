package pri.designPattern.command.command;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command {
	
	private Stack<Command> commands = new Stack<Command>();

	@Override
	public void execute() {
		Iterator<Command> iterator = commands.iterator();
		while(iterator.hasNext()) {
			iterator.next().execute();
		}
	}
	
	public void append(Command command) {
		commands.push(command);
	}
	
	public void undo() {
		if(!commands.empty()) {
			commands.pop();
		}
	}
	
	public void clear() {
		commands.clear();
	}

}
