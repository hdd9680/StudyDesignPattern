package pri.designPattern.facade.pageMaker;

import java.io.FileWriter;
import java.util.Properties;

public class PageMaker {
	
	private PageMaker() {}
	
	private static final String File_PATH = "C:\\Users\\hdd96\\git\\StudyDesignPattern\\PrivateTest\\src\\pri\\designPattern\\facade\\pageMaker\\";
	
	public static void makeWelcomPage(String mailAddr, String fileName) {
		try {
			Properties mailProp = Database.getProperties("mailData");
			String userName = mailProp.getProperty(mailAddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(File_PATH + fileName));
			
			writer.title("Welcom to " + userName + "'s Page");
			writer.paragraph(userName + "의 페이지에 오신걸 환영합니다.");
			writer.paragraph("메일을 기다리고 있겠습니다.");
			
			writer.mailTo(mailAddr, userName);
			writer.close();
			
			System.out.println(fileName + "is create for " + mailAddr + "(" + userName + ")");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
