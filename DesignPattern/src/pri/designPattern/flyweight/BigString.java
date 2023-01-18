package pri.designPattern.flyweight;

import java.util.ArrayList;
import java.util.List;

import pri.designPattern.flyweight.bigchar.BigChar;
import pri.designPattern.flyweight.bigchar.BigCharFactory;

public class BigString {
	private List<BigChar> bigChars = new ArrayList<>();
	
	public BigString(String string) {
		BigCharFactory bigCharFactory = BigCharFactory.getInstance();
		int stringLength = string.length();
		
		for(int i = 0 ; i < stringLength ; i++) {
			bigChars.add(bigCharFactory.getBigChar(string.charAt(i)));
		}
	}
	
	public void print() {
		for(BigChar bigChar : bigChars) {
			bigChar.print();
		}
	}
}
