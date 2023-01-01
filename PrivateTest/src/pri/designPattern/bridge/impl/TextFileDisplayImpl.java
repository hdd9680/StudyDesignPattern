package pri.designPattern.bridge.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileDisplayImpl extends DisplayImpl {

	private String string;
	private int width;
	private FileWriter writer;
	
	private final String path = "C:\\Users\\hdd96\\git\\StudyDesignPattern\\PrivateTest\\src\\pri\\designPattern\\bridge\\";
	
	public TextFileDisplayImpl(String string) {
		this.string = string;
		this.width = string.getBytes().length;
	}
	
	@Override
	public void rawOpen() {
		
		File file = new File(path + string + ".txt");
		try {
			writer = new FileWriter(file);
			printLie();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void rawPrint() {
		try {
			writer.append("|" + string + "|\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rawClose() {
		try {
			printLie();
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void printLie() throws IOException {
		writer.append("+");
		
		for(int i = 0 ; i < this.width ; i++) {
			writer.append(".");
		}
		writer.append("+\n");
		
	}

}
