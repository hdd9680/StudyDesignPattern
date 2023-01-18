package pri.designPattern.strategy;

public class Application {

	public static void main(String[] args) {
		
		int seed1 = 2;
		int seed2 = 2;
		
		Player player1 = new Player("홍길동", new RandomStrategy(seed1));
		Player player2 = new Player("임꺽정", new ProbStrategy(seed2));
		
		for(int i = 0 ; i < 10000 ; i++) {
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();
			
			if(nextHand1.isStrongerThan(nextHand2)) {
				player1.win();
				player2.lose();
				System.out.println("Winner : " + player1);
			} else if(nextHand1.isWeakerThan(nextHand2)) {
				player1.lose();
				player2.win();
				System.out.println("Winner : " + player2);
			} else {
				player1.even();
				player2.even();
				System.out.println("Even...");
			}
		}
		
		System.out.println("Total result===============");
		System.out.println(player1);
		System.out.println(player2);
		
	}

}
