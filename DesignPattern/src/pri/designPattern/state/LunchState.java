package pri.designPattern.state;

public class LunchState implements State {

	private static LunchState singleton = new LunchState();
	private LunchState() {}
	
	public static State getInstance() {
		return singleton;
	}
	
	@Override
	public void doClock(Context context, int hour) {
		if(hour < 8 || 21 <= hour) {
			context.changeState(NightState.getInstance());
			return;
		}
		
		if(8 <= hour && hour < 21) {
			context.changeState(DayState.getInstance());
			return;
		}
	}

	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("비상:점심의 금고사용");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(점심)");
	}

	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("점심의 통화 녹음");
	}
	
	@Override
	public String toString() {
		return "[점심]";
	}

}
