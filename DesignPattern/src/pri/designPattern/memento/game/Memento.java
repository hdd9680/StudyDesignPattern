package pri.designPattern.memento.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Memento implements Serializable {

	private static final long serialVersionUID = 2358023175723880966L;
	
	int money;
	List<String> fruits;
	private int number;
	
	Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList<>();
	}
	
	public int getMoney() {
		return money;
	}
	
	void addFruit(String fruit) {
		fruits.add(fruit); 
	}
	
	int getNumber() {
		return number;
	}
	
}
