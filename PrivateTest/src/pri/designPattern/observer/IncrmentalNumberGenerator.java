package pri.designPattern.observer;

public class IncrmentalNumberGenerator extends NumberGenerator {

	private int startNumber;
	private int endNumber;
	private int incremntal;
	private int nowNumber;
	
	public IncrmentalNumberGenerator(int startNumber, int endNumber, int incremntal) {
		this.startNumber = startNumber;
		this.endNumber = endNumber;
		this.incremntal = incremntal;
	}
	
	@Override
	public int getNumber() {
		return nowNumber;
	}

	@Override
	public void execute() {
		for(int i = startNumber ; i < endNumber ; i += incremntal) {
			nowNumber = i;
			super.notifyObserver();
		}
	}

}
