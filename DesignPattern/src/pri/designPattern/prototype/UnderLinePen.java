package pri.designPattern.prototype;

import pri.designPattern.prototype.framework.DefaultProduct;

public class UnderLinePen extends DefaultProduct {
	
	private char ulChar;
	
	public UnderLinePen(char ulChar) {
		this.ulChar = ulChar;
	}

	@Override
	public void use(String str) {
		
		int length = str.getBytes().length;
		
		System.out.println("\"" + str + "\"");
		
		for(int i = 0 ; i < length ; i++) {
			System.out.print(ulChar);
		}
		
		System.out.println();
	}

}
