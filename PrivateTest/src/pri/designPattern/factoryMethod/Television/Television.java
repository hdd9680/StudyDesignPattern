package pri.designPattern.factoryMethod.Television;

import pri.designPattern.factoryMethod.framework.Product;

public class Television extends Product {

	private String owner;
	
	Television(String owner) {
		System.out.println(owner + "의 텔레비전을 생성합니다.");
		this.owner = owner;
	}
	
	@Override
	public void use() {
		System.out.println(owner + "의 텔레비전을 시청합니다.");
	}

}
