package pri.designPattern.prototype;

import pri.designPattern.prototype.framework.Manager;
import pri.designPattern.prototype.framework.Product;

public class Application {

	public static void main(String[] args) {
		
		Manager manager = new Manager();
		
		UnderLinePen upen = new UnderLinePen('~');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');
		manager.register("strong message", upen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);
		
		System.out.println(upen.hashCode());
		System.out.println(mbox.hashCode());
		System.out.println(sbox.hashCode());
		
		Product p1 = manager.create("strong message");
		Product p2 = manager.create("warning box");
		Product p3 = manager.create("slash box");
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		
//		p1.use("Hello, world.");
//		p2.use("Hello, world.");
//		p3.use("Hello, world.");
		
	}

}
