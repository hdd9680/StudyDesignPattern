package pri.designPattern.iterpreter.language;

public class ParseException extends Exception {
	private static final long serialVersionUID = 8806460728201374956L;

	public ParseException(String msg) {
		super(msg);
	}
}
