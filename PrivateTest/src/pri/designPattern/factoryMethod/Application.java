package pri.designPattern.factoryMethod;

import pri.designPattern.factoryMethod.framework.Factory;
import pri.designPattern.factoryMethod.framework.Product;
import pri.designPattern.factoryMethod.idcard.IDCardFactory;

public class Application {

	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		
		Product card1 = factory.create("홍길동");
		Product card2 = factory.create("이순신");
		Product card3 = factory.create("강감찬");
		
		card1.use();
		card2.use();
		card3.use();
	}
	
}
