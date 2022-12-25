package pri.designPattern.factoryMethod.idcard;

import java.util.ArrayList;
import java.util.List;

import pri.designPattern.factoryMethod.framework.Factory;
import pri.designPattern.factoryMethod.framework.Product;

public class IDCardFactory extends Factory {
	
	private List<Product> owners = new ArrayList<>();
	private int serial = 0;

	@Override
	protected synchronized Product createProduct(String owner) {
		return new IDCard(owner, serial++);
	}

	@Override
	protected void registerProduct(Product product) {
		owners.add(product);
	}
	
	public List<Product> getOwners() {
		return owners;
	}

}
