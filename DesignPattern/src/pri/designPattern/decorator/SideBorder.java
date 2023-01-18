package pri.designPattern.decorator;

public class SideBorder extends Border {
	
	private char ch;

	public SideBorder(Display display, char ch) {
		super(display);
		this.ch = ch;
	}

	@Override
	public int getColumns() {
		return 1 + display.getColumns() + 1;
	}

	@Override
	public int getRows() {
		return display.getRows();
	}

	@Override
	public String getRowText(int row) {
		return ch + display.getRowText(row) + ch;
	}

}
