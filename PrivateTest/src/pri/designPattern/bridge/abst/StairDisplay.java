package pri.designPattern.bridge.abst;

import pri.designPattern.bridge.impl.DisplayImpl;

public class StairDisplay extends CountDisplay {

	private int step;
	
	public StairDisplay(DisplayImpl impl, int step) {
		super(impl);
		this.step = step;
	}

	public void stairDisplay(int level) {
		int count = 0;
		for(int i = 0 ; i < level ; i++) {
			multiDisplay(count);
			count += step;
		}
	}
	
}
