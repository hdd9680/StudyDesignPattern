package pri.designPattern.strategy;

import java.util.Random;

public class ProbStrategy implements Strategy {

	private Random random;
	private int prevHandValue;
	private int currentHandValue;
	private int[][] history = {
			{1, 1, 1},
			{1, 1, 1},
			{1, 1, 1}
	};
	
	public ProbStrategy(int seed) {
		this.random = new Random(seed);
	}
	
	@Override
	public Hand nextHand() {
		int bet = random.nextInt(getSum(currentHandValue));
		int handValue;
		
		if(bet < history[currentHandValue][0]) {
			handValue = 0;
		} else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
			handValue = 1;
		} else {
			handValue = 2;
		}
		
		prevHandValue = currentHandValue;
		currentHandValue = handValue;
		return Hand.getHand(handValue);
	}

	private int getSum(int currentHandValue) {
		int sum = 0;
		for(int i = 0 ; i < 3 ; i++) {
			sum += history[currentHandValue][i];
		}
		
		return sum;
	}

	@Override
	public void study(boolean isWin) {
		if(isWin) {
			history[prevHandValue][currentHandValue]++;
		} else {
			history[prevHandValue][(currentHandValue + 1) % 3]++;
			history[prevHandValue][(currentHandValue + 2) % 3]++;
		}
	}

}
