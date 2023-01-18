package pri.designPattern.abstractFactory.tableFactory;

import pri.designPattern.abstractFactory.factory.Factory;
import pri.designPattern.abstractFactory.factory.Link;
import pri.designPattern.abstractFactory.factory.Page;
import pri.designPattern.abstractFactory.factory.Tray;
import pri.designPattern.abstractFactory.listFactory.ListPage;

public class TableFactory extends Factory {

	@Override
	public Link createLink(String caption, String url) {
		return new TableLink(caption, url);
	}

	@Override
	public Tray createTray(String caption) {
		return new TableTray(caption);
	}

	@Override
	public Page createPage(String title, String author) {
		return new TablePage(title, author);
	}

}
