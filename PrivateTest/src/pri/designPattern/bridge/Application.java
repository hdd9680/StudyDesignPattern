package pri.designPattern.bridge;

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
		
	}

}
