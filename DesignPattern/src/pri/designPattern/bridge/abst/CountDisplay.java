package pri.designPattern.bridge.abst;

import pri.designPattern.bridge.impl.DisplayImpl;

public class CountDisplay extends Display {

	public CountDisplay(DisplayImpl impl) {
		super(impl);
	}
	
	public void multiDisplay(int times) {
		open();
		
		for(int i = 0 ; i < times ; i++) {
			print();
		}
		
		close();
	}

}
