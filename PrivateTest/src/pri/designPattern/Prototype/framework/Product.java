package pri.designPattern.Prototype.framework;

public interface Product extends Cloneable {
	
	public void use(String str);
	public Product createClone();

}
