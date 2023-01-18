package pri.designPattern.flyweight.bigchar;

import java.util.HashMap;

public class BigCharFactory {
	
	private HashMap<Character, BigChar> pool = new HashMap<>();
	private static BigCharFactory singleton = new BigCharFactory();
	
	private BigCharFactory() {}
	
	public static BigCharFactory getInstance() {
		return singleton;
	}
	
	public synchronized BigChar getBigChar(char charName) {
		BigChar bigChar = pool.get(charName);
		
		if(bigChar == null) {
			bigChar = new BigChar(charName);
			pool.put(charName, bigChar);
		}
		
		return bigChar;
	}
	
}
