package pri.designPattern.bridge.impl;

public class CharDisplayImpl extends DisplayImpl {
	
	private char startChar;
	private char mainChar;
	private char endChar;
	
	public CharDisplayImpl(char startChar, char mainChar, char endChar) {
		this.startChar = startChar;
		this.mainChar = mainChar;
		this.endChar = endChar;
	}

	@Override
	public void rawOpen() {
		System.out.print(startChar);
	}

	@Override
	public void rawPrint() {
		System.out.print(mainChar);
	}

	@Override
	public void rawClose() {
		System.out.println(endChar);
	}

}
