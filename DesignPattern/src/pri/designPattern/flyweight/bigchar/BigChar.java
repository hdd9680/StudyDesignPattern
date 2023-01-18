package pri.designPattern.flyweight.bigchar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
	
	private char charName;
	private String fontData;
	
	private final String FILE_PATH = "C:\\Users\\hdd96\\git\\StudyDesignPattern\\DesignPattern\\src\\pri\\designPattern\\flyweight\\bigchar\\";
	
	BigChar(char charName) {
		this.charName = charName;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH + "big" + charName + ".txt"));
			
			String line;
			
			StringBuffer sb = new StringBuffer();
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			reader.close();
			this.fontData = sb.toString();
			
		} catch (IOException e) {
			this.fontData = charName + "?";
		}
		
	}
	
	public void print() {
		System.out.println(fontData);
	}

}
