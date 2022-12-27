package pri.designPattern.builder;

public interface Builder {
	public abstract void makeTitle(String title);
	public abstract void makeString(String str);
	public abstract void makeItem(String... items);
	public abstract Object getResult();
	
}
