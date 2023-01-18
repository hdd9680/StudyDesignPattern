package pri.designPattern.abstractFactory.tableFactory;

import java.util.Iterator;

import pri.designPattern.abstractFactory.factory.Item;
import pri.designPattern.abstractFactory.factory.Tray;

public class TableTray extends Tray {

	public TableTray(String caption) {
		super(caption);
	}

	@Override
	public String makeHtml() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<td>\n");
		buffer.append("<table width=\"100%\" border=\"1\">\n");
		buffer.append("<tr>\n");
		buffer.append("<td bgcolor=\"cccccc\" align=\"center\" colspan=\"" + tray.size() + "\"><b>" + caption + "<b></td>\n");
		buffer.append("</tr>\n");
		buffer.append("<tr>\n");
		
		Iterator<Item> iterator = tray.iterator();
		while(iterator.hasNext()) {
			buffer.append(iterator.next().makeHtml());
		}
		
		buffer.append("</tr>\n");
		buffer.append("</table>\n");
		buffer.append("</td>\n");
		
		return buffer.toString();
	}

}
