package pri.designPattern.decorator;

public class UpDownBorder extends Border {

	private char ch;
	
	protected UpDownBorder(Display display, char ch) {
		super(display);
		this.ch = ch;
	}

	@Override
	public int getColumns() {
		return super.display.getColumns();
	}

	@Override
	public int getRows() {
		return 1 + super.display.getRows() + 1;
	}

	@Override
	public String getRowText(int row) {
		
		if(row == 0 || (row == super.display.getRows() + 1)) {
			return makeLine(this.ch, super.display.getColumns());
		}
		
		return super.display.getRowText(row - 1);
	}

	private String makeLine(char ch, int columns) {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0 ; i < columns ; i++) {
			sb.append(ch);
		}
		
		return sb.toString();
	}

}
