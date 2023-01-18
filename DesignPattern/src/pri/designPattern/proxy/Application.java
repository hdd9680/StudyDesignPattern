package pri.designPattern.proxy;

public class Application {

	public static void main(String[] args) {
		Printable printer = new PrinterProxy("Alice", "pri.designPattern.proxy.Printer");
		System.out.println("이른은 현재 " + printer.getPrinterName() + "입니다.");
		printer.setPrinterName("Bob");
		System.out.println("이른은 현재 " + printer.getPrinterName() + "입니다.");
		printer.print("Hello, world.");
	}

}
