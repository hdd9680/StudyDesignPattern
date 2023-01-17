package pri.designPattern.state;

public class Application {

	public static void main(String[] args) throws Exception {
		SafeFrame frame = new SafeFrame("State Sample");
		
		while(true) {
			for(int hour = 0 ; hour < 24 ; hour++) {
				frame.setClock(hour);
				Thread.sleep(1000);
			}
		}
	}

}
