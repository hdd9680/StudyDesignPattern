package pri.designPattern.chainOfResponsbility;

public class Trouble {
	
	private int no;
	
	public Trouble(int no) {
		this.no = no;
	}
	
	public int getNo() {
		return this.no;
	}

	@Override
	public String toString() {
		return "Trouble [no=" + no + "]";
	}
	
}
