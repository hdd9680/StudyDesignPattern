package pri.designPattern.state;

public class NightState implements State {

	private static NightState singleton = new NightState();
	private NightState() {}
	
	public static State getInstance() {
		return singleton;
	}
	
	@Override
	public void doClock(Context context, int hour) {
		if(12 <= hour && hour <= 13) {
			context.changeState(LunchState.getInstance());
			return;
		}
		
		if(8 <= hour && hour < 21) {
			context.changeState(DayState.getInstance());
			return;
		}
	}

	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("비상:야간의 금고사용");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(야간)");
	}

	@Override
	public void doPhone(Context context) {
		context.recordLog("야간의 통화 녹음");
	}
	
	@Override
	public String toString() {
		return "[야간]";
	}

}
