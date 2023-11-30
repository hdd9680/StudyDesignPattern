package pri.designPattern.factoryMethod.Television;

import java.util.ArrayList;
import java.util.List;

import pri.designPattern.factoryMethod.framework.Factory;
import pri.designPattern.factoryMethod.framework.Product;

public class TelevisionFactory extends Factory {

	private List<Product> owners = new ArrayList<>();

	@Override
	protected Product createProduct(String owner) {
		return new Television(owner);
	}

	@Override
	protected void registerProduct(Product product) {
		owners.add(product);
	}
	
	public List<Product> getOwners() {
		return owners;
	}

}
