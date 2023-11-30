package pri.designPattern.decorator;

public class Application {
	
	public static void main(String[] args) {
		MultiStringDisplay md = new MultiStringDisplay(
			"Good Morning!",
			"Hello~",
			"GoodBye, See You Tomorrow."
		);
		
		md.show();
		
		Display d1 = new SideBorder(md, '#');
		d1.show();
		
		Display d2 = new FullBorder(md);
		d2.show();
	}

}
