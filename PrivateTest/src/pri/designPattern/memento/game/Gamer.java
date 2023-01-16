package pri.designPattern.memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
	
	private int money;
	private List<String> fruits;
	private Random random;
	private static final String[] FRUITS_NAMES = {"사과", "포도", "바나나", "귤" };
	
	public Gamer(int moeny) {
		this.money = moeny;
		this.fruits = new ArrayList<>();
		this.random = new Random();
	}
	
	public int getMoney() {
		return money;
	}
	
	public void bet() {
		int dice = random.nextInt(6) + 1;
		
		if(dice == 1) {
			money += 100;
			System.out.println("돈이 증가했습니다.");
		} else if(dice == 2) {
			money /= 2;
			System.out.println("돈이 반으로 줄었습니다.");
		} else if(dice == 6) {
			String fruit = getFruit();
			System.out.println("과일(" + fruit + ")을 받았습니다.");
			fruits.add(fruit);
		} else {
			System.out.println("아무일도 일어나지 않았습니다.");
		}
	}

	public Memento createMemento() {
		Memento memento = new Memento(money);
		
		for(String fruit : fruits) {
			if(fruit.startsWith("맛있다")) {
				memento.addFruit(fruit);
			}
		}
		
		return memento;
	}
	
	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.fruits;
	}
	
	private String getFruit() {
		String prefix = "";
		if(random.nextBoolean()) {
			prefix = "맛있다";
		}
		
		return prefix + FRUITS_NAMES[random.nextInt(FRUITS_NAMES.length)];
	}
	
	@Override
	public String toString() {
		return "[money = " + money + ", fruits = " + fruits + "]";
	}
}
