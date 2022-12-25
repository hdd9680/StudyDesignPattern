package pri.designPattern.adapter;

import java.io.IOException;

public interface FileIO {
	
	public void readFromFile(String fileName) throws IOException;
	public void writeToFile(String fileName) throws IOException;
	public void setValue(String key, String value) throws IOException;
	public String getValue(String key);

}
