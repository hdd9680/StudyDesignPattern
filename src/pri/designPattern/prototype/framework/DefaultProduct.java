package pri.designPattern.prototype.framework;

public abstract class DefaultProduct implements Product{

	public abstract void use(String str);
	
	@Override
	public Product createClone() {
		
		Product p = null;
		
		try {
			p = (Product)clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
}
