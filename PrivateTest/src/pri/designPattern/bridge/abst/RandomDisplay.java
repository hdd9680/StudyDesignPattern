package pri.designPattern.bridge.abst;

import pri.designPattern.bridge.impl.DisplayImpl;

public class RandomDisplay extends Display {

	public RandomDisplay(DisplayImpl impl) {
		super(impl);
	}
	
	public void randomDisplay(int max) {
		int times = ((int) (Math.random() * max));
		
		open();
		for(int i = 0 ; i < times ; i++) {
			print();
		}
		close();
	}

}
