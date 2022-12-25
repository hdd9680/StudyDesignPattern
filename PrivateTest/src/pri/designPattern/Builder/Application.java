package pri.designPattern.Builder;

public class Application {

	public static void main(String[] args) {
		for(String str : args) {
			if("plain".equals(str)) {
				Director director = new Director(new TextBuilder());
				String result = director.construct().toString();
				System.out.println(result);
			} else if("html".equals(str)) {
				Director director = new Director(new HTMLBuilder());
				String fileName = director.construct().toString();
				System.out.println(fileName + "이작성되었습니다.");
			}
		}
		
		System.out.println("시스템 종료.");
	}
	
}
