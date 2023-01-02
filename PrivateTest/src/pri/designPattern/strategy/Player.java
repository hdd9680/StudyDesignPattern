package pri.designPattern.strategy;

public class Player {
	
	private String name;
	private Strategy strategy;
	private int gameCount;
	private int winCount;
	private int loseCount;
	
	public Player(String name, Strategy strategy) {
		this.name = name;
		this.strategy = strategy;
	}
	
	public Hand nextHand() {
		return strategy.nextHand();
	}
	
	public void win() {
		strategy.study(true);
		this.winCount++;
		this.gameCount++;
	}

	public void lose() {
		strategy.study(false);
		this.loseCount++;
		this.gameCount++;
	}

	public void even() {
		this.gameCount++;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", gameCount=" + gameCount + ", winCount=" + winCount + ", loseCount="
				+ loseCount + "]";
	}
	
}
