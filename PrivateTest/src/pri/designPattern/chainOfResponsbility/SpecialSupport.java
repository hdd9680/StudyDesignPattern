package pri.designPattern.chainOfResponsbility;

public class SpecialSupport extends Support {

	private int specialNo;
	
	public SpecialSupport(String name, int specialNo) {
		super(name);
		this.specialNo = specialNo;
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		
		if(trouble.getNo() == this.specialNo) {
			return true;
		}
		
		return false;
	}

}
