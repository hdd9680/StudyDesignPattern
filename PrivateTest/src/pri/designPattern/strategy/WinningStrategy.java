package pri.designPattern.strategy;

import java.util.Random;

public class WinningStrategy implements Strategy {

	private Random random;
	private boolean won = false;
	private Hand prevHand;
	
	public WinningStrategy(int seed) {
		this.random = new Random(seed);
		prevHand = Hand.getHand(0);
	}
	
	@Override
	public Hand nextHand() {
		if(!won) {
			return Hand.getHand(random.nextInt(3));
		}
		
		return prevHand;
	}

	@Override
	public void study(boolean isWin) {
		this.won = isWin;
	}

}
