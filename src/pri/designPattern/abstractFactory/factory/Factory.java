package pri.designPattern.abstractFactory.factory;

public abstract class Factory {
	
	private final static String packagePath = "pri.designPattern.abstractFactory.";
	
	public static Factory getFactory(String className) {
		Factory factory = null;
		
		try {
			factory = (Factory) Class.forName(packagePath + className).getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		}
		
		return factory;
		
	}
	
	public Page createNaver() {
		Link link = createLink("네이버", "https://www.naver.com/");
		Page page = createPage("naver", "naver");
		page.add(link);
		return page;
	}
	
	public abstract Link createLink(String caption, String url);
	public abstract Tray createTray(String caption);
	public abstract Page createPage(String title, String author);
}
