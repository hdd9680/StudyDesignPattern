package pri.designPattern.iterpreter;

import java.io.BufferedReader;
import java.io.FileReader;

public class Apllication {
	
	private static final String FILE_PATH = "C:\\Users\\hdd96\\git\\StudyDesignPattern\\DesignPattern\\src\\pri\\designPattern\\iterpreter\\";
	
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH + "program.txt"));
			
			String text;
			while((text = reader.readLine()) != null) {
				System.out.println("text = \"" + text + "\"");
				Node node = new ProgramNode();
				node.parse(new Context(text));
				System.out.println("node = " + node);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
