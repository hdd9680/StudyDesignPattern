package pri.designPattern.Builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HTMLBuilder implements Builder {
	private String fileName;
	private PrintWriter writer;
	
	private final String FILE_PATH = "C:\\Users\\hdd96\\git\\StudyDesignPattern\\PrivateTest\\src\\pri\\designPattern\\Builder\\";
	
	@Override
	public void makeTitle(String title) {
		this.fileName = FILE_PATH + title + ".html";
		
		try {
			writer = new PrintWriter(new FileWriter(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>" + title + "</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>" + title + "</h1>");
	}
	@Override
	public void makeString(String str) {
		writer.println("<p>" + str + "</p>");
	}
	@Override
	public void makeItem(String... items) {
		writer.println("<ul>");
		for(String item : items) {
			writer.println("<li>" + item + "</li>");
		}
		writer.println("</ul>");
	}
	@Override
	public Object getResult() {
		writer.println("</body>");
		writer.println("</head>");
		writer.close();
		return fileName;
	}

}
