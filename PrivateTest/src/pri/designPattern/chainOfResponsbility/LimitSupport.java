package pri.designPattern.chainOfResponsbility;

public class LimitSupport extends Support {
	
	private int limit;

	public LimitSupport(String name, int limit) {
		super(name);
		this.limit = limit;
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		
		if(trouble.getNo() < limit) {
			return true;
		}
		
		return false;
	}

}
