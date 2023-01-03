package pri.designPattern.decorator;

public class FullBorder extends Border {

	public FullBorder(Display display) {
		super(display);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getColumns() {
		return 1 + display.getColumns() + 1;
	}
	
	@Override
	public int getRows() {
		return 1 + display.getRows() + 1;
	}

	@Override
	public String getRowText(int row) {
		
		if(row == 0 || (row == display.getRows() + 1)) {
			return "+" + makeLine('-', display.getColumns()) + "+";
		} 
		
		return "|" + display.getRowText(row - 1) + "|";
	}

	private String makeLine(char ch, int columns) {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0 ; i < columns ; i++) {
			buffer.append(ch);
		}
		return buffer.toString();
	}
	
	
}
