package pri.designPattern.bridge;

import pri.designPattern.bridge.abst.CountDisplay;
import pri.designPattern.bridge.abst.Display;
import pri.designPattern.bridge.abst.RandomDisplay;
import pri.designPattern.bridge.abst.StairDisplay;
import pri.designPattern.bridge.impl.CharDisplayImpl;
import pri.designPattern.bridge.impl.StringDisplayImpl;
import pri.designPattern.bridge.impl.TextFileDisplayImpl;

public class Application {
	
	public static void main(String[] args) {
		System.out.println("테스트");
		
		Display d1 = new Display(new StringDisplayImpl("Hello, Korea"));
		Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World"));
		CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe"));
		
		d1.display();
		d2.display();
		d3.display();
		
		d3.multiDisplay(5);
		
		RandomDisplay d4 = new RandomDisplay(new TextFileDisplayImpl("Test"));
		d4.randomDisplay(5);
		
		StairDisplay d5 = new StairDisplay(new CharDisplayImpl('|', '#', '-'), 1);
		d5.stairDisplay(4);
		
		StairDisplay d6 = new StairDisplay(new CharDisplayImpl('<', '*', '>'), 2);
		d6.stairDisplay(6);
		
	}

}
