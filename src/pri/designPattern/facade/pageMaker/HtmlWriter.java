package pri.designPattern.facade.pageMaker;

import java.io.IOException;
import java.io.Writer;

class HtmlWriter {
	
	private Writer writer;
	
	public HtmlWriter(Writer writer) {
		this.writer = writer;
	}
	
	public void title(String title) throws IOException {
		writer.write("<html>\n");
		writer.write("<head>\n");
		writer.write(makeTag("title", title));
		writer.write("</head>\n");
		writer.write("<body>\n");
		writer.write(makeTag("h1", title));
	}
	
	public void paragraph(String msg) throws IOException {
		writer.write(makeTag("p", msg));
	}
	
	public void link(String href, String caption) throws IOException {
		paragraph("<a href=\"" + href + "\">" + caption + "</a>");
	}
	
	public void mailTo(String mailAddr, String userName) throws IOException {
		link("mailto : " + mailAddr, userName);
	}
	
	public void close() throws IOException {
		if(writer != null) {
			writer.write("</body>\n");
			writer.write("</html>");
			writer.close();
		}
	}
	
	private String makeTag(String tag, String text) {
		return "<" + tag + ">" + text + "</" + tag + ">\n";
	}
	
}
