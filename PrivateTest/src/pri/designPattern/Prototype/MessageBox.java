package pri.designPattern.Prototype;

import pri.designPattern.Prototype.framework.DefaultProduct;

public class MessageBox extends DefaultProduct {
	
	private char decoChar;
	
	public MessageBox(char decoChar) {
		this.decoChar = decoChar;
	}

	@Override
	public void use(String str) {
		printDeocoCharLine(str);
		System.out.println(decoChar + str + decoChar);
		printDeocoCharLine(str);
	}

	private void printDeocoCharLine(String str) {
		int length = str.getBytes().length;
		
		for(int i = 0 ; i < length ; i++) {
			System.out.print(decoChar);
		}
		
		System.out.println();
	}

}
