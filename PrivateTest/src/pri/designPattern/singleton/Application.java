package pri.designPattern.singleton;

public class Application {

	public static void main(String[] args) throws Exception {
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		NoneSingleton obj3 = new NoneSingleton();
		NoneSingleton obj4 = new NoneSingleton();
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		System.out.println(obj3.hashCode());
		System.out.println(obj4.hashCode());
		
		System.out.println(TicketMarker.getNextTicketNumber());
		System.out.println(TicketMarker.getNextTicketNumber());
		System.out.println(TicketMarker.getNextTicketNumber());
		System.out.println(TicketMarker.getNextTicketNumber());
		System.out.println(TicketMarker.getNextTicketNumber());
		System.out.println(TicketMarker.getNextTicketNumber());
		System.out.println(TicketMarker.getNextTicketNumber());
		
		System.out.println(Triple.getInstance(0).hashCode());
		System.out.println(Triple.getInstance(1).hashCode());
		System.out.println(Triple.getInstance(2).hashCode());
		
	}

}
