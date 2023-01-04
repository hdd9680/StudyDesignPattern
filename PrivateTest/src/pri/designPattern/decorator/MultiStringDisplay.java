package pri.designPattern.decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiStringDisplay extends Display {

	private List<String> stringList;
	
	public MultiStringDisplay() {
		stringList = new ArrayList<>();
	}
	
	public MultiStringDisplay(String... strings) {
		stringList = new ArrayList<>(Arrays.asList(strings));
	}
	
	@Override
	public int getColumns() {
		
		int maxColumns = 0;
		
		for(String string : stringList) {
			int stringLengh = string.getBytes().length;
			
			maxColumns = maxColumns < stringLengh ? stringLengh : maxColumns; 
		}
		
		return maxColumns;
	}

	@Override
	public int getRows() {
		return stringList.size();
	}

	@Override
	public String getRowText(int row) {
		
		String string = stringList.get(row);
		StringBuffer sb = new StringBuffer();
		int maxColumns = getColumns();
		
		int columnsDistance = maxColumns - string.getBytes().length;
		
		for(int i = 0 ; i < columnsDistance ; i++) {
			sb.append(' ');
		}
		
		return stringList.get(row) + sb.toString();
	}
	
	public void add(String string) {
		stringList.add(string);
	}

}
