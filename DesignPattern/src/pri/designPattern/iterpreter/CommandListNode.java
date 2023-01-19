package pri.designPattern.iterpreter;

import java.util.ArrayList;
import java.util.List;

public class CommandListNode extends Node {
	
	private List<Node> nodeList = new ArrayList<>();
	
	@Override
	public void parse(Context context) throws ParseException {
		while(true) {
			if(context.currentToken() == null) {
				throw new ParseException("Missing 'end'");
			} else if("end".equals(context.currentToken())) {
				context.skipToken("end");
				break;
			} else {
				Node commandNode = new CommandNode();
				commandNode.parse(context);
				nodeList.add(commandNode);
			}
		}
	}
	
	@Override
	public String toString() {
		return nodeList.toString();
	}
}
