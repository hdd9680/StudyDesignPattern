package pri.designPattern.facade.pageMaker;

import java.io.FileInputStream;
import java.util.Properties;

public class Database {
	
	private static final String FILE_PATH = "C:\\Users\\hdd96\\git\\StudyDesignPattern\\PrivateTest\\src\\pri\\designPattern\\facade\\";
	
	private Database() {
		
	}
	
	public static Properties getProperties(String name) {
		String fileName = FILE_PATH + name + ".txt";
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
}
