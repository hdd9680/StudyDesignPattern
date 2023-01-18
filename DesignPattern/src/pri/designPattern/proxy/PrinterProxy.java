package pri.designPattern.proxy;

public class PrinterProxy implements Printable {
	
	private String name;
	private Printer realPrinter;
	
	public PrinterProxy(String name) {
		this.name = name;
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
			realPrinter = new Printer(name);
		}
	}
	
}
