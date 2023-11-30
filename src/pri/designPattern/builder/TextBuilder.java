package pri.designPattern.builder;

public class TextBuilder implements Builder {

	private StringBuffer buffer = new StringBuffer();
	
	@Override
	public void makeTitle(String title) {
		appendStartAndEndMark();
		buffer.append("[" + title + "]");
		appendLine();
	}

	@Override
	public void makeString(String str) {
		buffer.append('■' + str);
		appendLine();
	}

	@Override
	public void makeItem(String... items) {
		for(String item : items) {
			buffer.append("." + item);
			appendLine();
		}
		
		appendLine();
	}

	@Override
	public Object getResult() {
		appendStartAndEndMark();
		return buffer.toString();
	}
	
	private void appendStartAndEndMark() {
		buffer.append("================================");
		appendLine();
	}
	
	private void appendLine() {
		buffer.append("\n");
	}
	
}
