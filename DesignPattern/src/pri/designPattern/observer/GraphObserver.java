package pri.designPattern.observer;

public class GraphObserver implements Observer {

	@Override
	public void update(NumberGenerator generator) {
		System.out.print("GraphObserver : ");
		int cnt = generator.getNumber();
		
		for(int i = 0 ; i < cnt ; i++) {
			System.out.print("*");
		}
		
		System.out.println();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
