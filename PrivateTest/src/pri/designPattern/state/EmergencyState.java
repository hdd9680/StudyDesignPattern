package pri.designPattern.state;

public class EmergencyState implements State {

	private static EmergencyState singleton = new EmergencyState();
	private EmergencyState() {}
	
	public static State getInstance() {
		return singleton;
	}
	
	@Override
	public void doClock(Context context, int hour) {
		
	}

	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("비상:비상사태 금고사용");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(비상)");
	}

	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("비상사태 통화(비상사태)");
	}
	
	@Override
	public String toString() {
		return "[비상]";
	}

}
