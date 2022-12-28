package pri.designPattern.abstractFactory.listFactory;

import java.util.Iterator;

import pri.designPattern.abstractFactory.factory.Item;
import pri.designPattern.abstractFactory.factory.Page;

public class ListPage extends Page {

	public ListPage(String title, String author) {
		super(title, author);
	}

	@Override
	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html><head><title>" + title + "</title><head>\n");
		buffer.append("<body>\n");
		buffer.append("<h1>" + title + "</h1>\n");
		buffer.append("<ul>\n");
		
		Iterator<Item> itrator = content.iterator();
		while(itrator.hasNext()) {
			buffer.append(itrator.next().makeHtml());
		}
		buffer.append("</ul>\n");
		buffer.append("<hr><address>" + this.author  + "<address>\n");
		buffer.append("</body></html>\n");
		
		return buffer.toString();
	}

}
