package pri.designPattern.adapter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties implements FileIO {
	
	private Properties properties;

	@Override
	public void readFromFile(String fileName) throws IOException {
		properties = new Properties();
		properties.load(new FileInputStream(fileName));
	}

	@Override
	public void writeToFile(String fileName) throws IOException {
		properties.store(new FileOutputStream(fileName), null);
	}

	@Override
	public void setValue(String key, String value) throws IOException {
		properties.setProperty(key, value);
	}

	@Override
	public String getValue(String key) {
		return properties.getProperty(key);
	}

}
