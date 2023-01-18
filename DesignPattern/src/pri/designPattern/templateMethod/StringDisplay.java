package pri.designPattern.templateMethod;

public class StringDisplay extends AbstractDisplay {

	private String string;
	private int length;
	
	public StringDisplay(String string) {
		this.string = string;
		this.length = string.getBytes().length;
	}
	
	@Override
	protected void open() {
		printLine();
	}

	@Override
	protected void close() {
		printLine();
	}
	
	private void printLine() {
		System.out.print("+");
		for(int i = 0 ; i < length ; i++) {
			System.out.print("*");
		}
		System.out.println(".");
	}

	@Override
	protected void print() {
		System.out.println("|" + string + "|");
	}


}
