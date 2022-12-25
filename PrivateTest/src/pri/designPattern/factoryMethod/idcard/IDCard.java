package pri.designPattern.factoryMethod.idcard;

import pri.designPattern.factoryMethod.framework.Product;

public class IDCard extends Product {

	private String owner;
	private int serial;
	
	IDCard(String owner, int serial) {
		System.out.println(owner + "(" + serial + ")의 카드를 만듭니다.");
		this.owner = owner;
		this.serial = serial;
	}
	
	@Override
	public void use() {
		System.out.println(owner + "(" + serial + ")의 카드를 사용합니다.");
	}

}
