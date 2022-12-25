package pri.designPattern.adapter;

import java.io.IOException;

public class Application {

	public static void main(String[] args) {
		
		FileIO fileIO = new FileProperties();
		
		try {
			fileIO.readFromFile(System.getProperty("user.dir") + "\\src\\pri\\designPattern\\adapter\\properties.properties");
			fileIO.setValue("year", "2000");
			fileIO.setValue("month", "11");
			fileIO.setValue("day", "20");
			fileIO.writeToFile(System.getProperty("user.dir") + "\\src\\pri\\designPattern\\adapter\\newProperties.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}


