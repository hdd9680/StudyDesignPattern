package pri.designPattern.Prototype.framework;

import java.util.Hashtable;

public class Manager {
	
	private Hashtable<String, Product> showcase = new Hashtable<>();
	
	public void register(String name, Product proto) {
		showcase.put(name, proto);
	}
	
	public Product create(String protoName) {
		Product p = (Product)showcase.get(protoName);
		return p.createClone();
	}

}
