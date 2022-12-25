package pri.designPattern.singleton;

public class TicketMarker {
	private static int ticket = 1000;
	
	private TicketMarker() {
		
	}
	
	public static synchronized int getNextTicketNumber() {
		return ticket++;
	}
}
