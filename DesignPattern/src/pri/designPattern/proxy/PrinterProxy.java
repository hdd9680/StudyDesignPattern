package pri.designPattern.proxy;

public class PrinterProxy implements Printable {
	
	private String name;
	private Printable realPrinter;
	private String className;
	
	public PrinterProxy(String name, String className) {
		this.name = name;
		this.className = className;
	}
	
	@Override
	public synchronized void setPrinterName(String name) {
		if(realPrinter != null) {
			realPrinter.setPrinterName(name);
		}
		this.name = name;
	}

	@Override
	public String getPrinterName() {
		return name;
	}

	@Override
	public void print(String string) {
		realize();
		realPrinter.print(string);
	}
	
	private synchronized void realize() {
		if(realPrinter == null) {
			try {
				realPrinter = (Printable) Class.forName(className).getConstructor().newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
