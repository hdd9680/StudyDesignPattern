package pri.designPattern.abstractFactory.tableFactory;

import pri.designPattern.abstractFactory.factory.Link;

public class TableLink extends Link {

	public TableLink(String caption, String url) {
		super(caption, url);
	}

	@Override
	public String makeHtml() {
		return "<td><a href=\"" + this.url + "\">" + caption + "</a></td>\n";
	}

}
