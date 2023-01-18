package pri.designPattern.strategy;

public class Hand {
	
	public static final int HANDVALUE_GUU = 0 ;
	public static final int HANDVALUE_CHO = 1 ;
	public static final int HANDVALUE_PPA = 2 ;
	public static final Hand[] hand = {
			new Hand(HANDVALUE_GUU)
		  , new Hand(HANDVALUE_CHO)
		  , new Hand(HANDVALUE_PPA)
	};
	private static final String[] name = {"주먹", "가위", "보"};
	private int handValue;
	
	private Hand(int handValue) {
		this.handValue = handValue;
	}
	
	public static Hand getHand(int handValue) {
		return hand[handValue];
	}
	
	public boolean isStrongerThan(Hand hand) {
		return fight(hand) == 1;
	}
	
	public boolean isWeakerThan(Hand hand) {
		return fight(hand) == -1;
	}

	private int fight(Hand hand) {
		if(this == hand) {
			return 0;
		}
		else if ((this.handValue + 1) % 3 == hand.handValue) {
			return 1;
		} else {
			return -1;
		}
		
	}
	
	public String toString() {
		return name[this.handValue];
	}
	
}
