package pri.designPattern.abstractFactory.listFactory;

import pri.designPattern.abstractFactory.factory.Factory;
import pri.designPattern.abstractFactory.factory.Link;
import pri.designPattern.abstractFactory.factory.Page;
import pri.designPattern.abstractFactory.factory.Tray;

public class ListFactory extends Factory {

	@Override
	public Link createLink(String caption, String url) {
		return new ListLink(caption, url);
	}

	@Override
	public Tray createTray(String caption) {
		return new ListTray(caption);
	}

	@Override
	public Page createPage(String title, String author) {
		return new ListPage(title, author);
	}

	
}
