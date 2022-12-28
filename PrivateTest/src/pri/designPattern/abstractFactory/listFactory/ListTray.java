package pri.designPattern.abstractFactory.listFactory;

import java.util.Iterator;

import pri.designPattern.abstractFactory.factory.Item;
import pri.designPattern.abstractFactory.factory.Tray;

public class ListTray extends Tray {

	public ListTray(String caption) {
		super(caption);
	}

	@Override
	public String makeHtml() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<li>\n");
		buffer.append(caption + "\n");
		buffer.append("<ul>\n");
		
		Iterator<Item> iterator = tray.iterator();
		while(iterator.hasNext()) {
			buffer.append(iterator.next().makeHtml());
		}
		
		buffer.append("</li>\n");
		buffer.append("</ul>\n");
		
		return buffer.toString();
	}

}
