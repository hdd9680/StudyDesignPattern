package pri.designPattern.prototype.framework;

public interface Product extends Cloneable {
	
	public void use(String str);
	public Product createClone();

}
