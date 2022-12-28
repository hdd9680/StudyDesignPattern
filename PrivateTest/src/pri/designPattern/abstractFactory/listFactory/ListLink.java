package pri.designPattern.abstractFactory.listFactory;

import pri.designPattern.abstractFactory.factory.Link;

public class ListLink extends Link {

	public ListLink(String caption, String url) {
		super(caption, url);
	}

	@Override
	public String makeHtml() {
		return "<li><a href=\"" + this.url + "\">" + caption + "</a></li>\n";
	}

}
