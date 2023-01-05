package pri.designPattern.chainOfResponsbility;

public class OddSupport extends Support {

	public OddSupport(String name) {
		super(name);
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		
		if(trouble.getNo() % 2 == 0) {
			return true;
		}
		
		return false;
	}

}
