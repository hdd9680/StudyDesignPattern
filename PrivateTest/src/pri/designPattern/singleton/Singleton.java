package pri.designPattern.singleton;

public class Singleton {
	
	private static Singleton singleton = null;
	
	private Singleton() {
		System.out.println("싱글톤 인스턴스를 생성했습니다.");
	}
	
	public static Singleton getInstance() {
		if(Singleton.singleton == null) {
			Singleton.singleton = new Singleton();
		}
		
		return Singleton.singleton;
	}
	
}
