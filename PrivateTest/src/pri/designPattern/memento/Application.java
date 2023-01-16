package pri.designPattern.memento;

import pri.designPattern.memento.game.Gamer;
import pri.designPattern.memento.game.Memento;

public class Application {
	
	public static void main(String[] args) throws InterruptedException {
		
		Gamer gamer = new Gamer(100);
		Memento memento = gamer.createMemento();
		
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println("==== " + i);
			System.out.println("현 상태: " + gamer.toString());
			
			gamer.bet();
			
			System.out.println("돈은 " + gamer.getMoney() + "원이 되었습니다.");
			
			if(gamer.getMoney() > memento.getMoney()) {
				System.out.println("(많이 증가했으니 여기서 저장하자)");
				memento = gamer.createMemento();
			} else if(gamer.getMoney() <= memento.getMoney() / 2) {
				System.out.println("(많이 줄었으니 저장한거로 다시하자)");
				gamer.restoreMemento(memento);
			}
			
//			Thread.sleep(1000);
			
			System.out.println();
		}
		
	}

}
