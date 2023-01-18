package pri.designPattern.abstractFactory;

import pri.designPattern.abstractFactory.factory.Factory;
import pri.designPattern.abstractFactory.factory.Link;
import pri.designPattern.abstractFactory.factory.Page;
import pri.designPattern.abstractFactory.factory.Tray;

public class Application {
	
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("Usage: java Main class.name.of.ConcreteFactory");
			System.out.println("Example 1: java Main pri.designPattern.abstractFactory.listFactory.ListFactory.");
			System.out.println("Example 2: java Main pri.designPattern.abstractFactory.listFactory.TableFactory.");
		}
		
		Factory factory = Factory.getFactory(args[0]);
		
		Link joins = factory.createLink("중앙일보", "https://www.joins.com/");
		Link hani = factory.createLink("한겨례 신문", "https://www.hani.com/");
		
		Link naver = factory.createLink("네이버", "https://www.naver.com/");
		Link daum = factory.createLink("다음", "https://www.daum.net/");
		
		Link excite = factory.createLink("Excite", "https://www.excite.com/");
		Link google = factory.createLink("Google", "https://www.google.net/");
		
		Tray trayNews = factory.createTray("신문");
		trayNews.add(joins);
		trayNews.add(hani);
		
		Tray trayPortal = factory.createTray("포탈");
		trayPortal.add(naver);
		trayPortal.add(daum);
		
		Tray traySearch = factory.createTray("검색");
		traySearch.add(trayPortal);
		traySearch.add(excite);
		traySearch.add(google);
		
		Page page = factory.createPage("LinkPage", "황성연");
		page.add(trayNews);
		page.add(trayPortal);
		page.add(traySearch);
		page.output();
		
		Page naverPage = factory.createNaver();
		naverPage.output();
		
	}

}
