package pri.designPattern.memento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pri.designPattern.memento.game.Gamer;
import pri.designPattern.memento.game.Memento;

public class Application {
	
	private static final String FILE_PATH = "C:\\Users\\hdd96\\git\\StudyDesignPattern\\PrivateTest\\src\\pri\\designPattern\\memento\\";
	
	public static void main(String[] args) throws Exception {
		
		File gameData = new File(FILE_PATH + "game.dat");
		
		Gamer gamer = new Gamer(1000);
		
		if(gameData.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(gameData));
			gamer.restoreMemento(((Memento)ois.readObject()));
			ois.close();
		}
		
		Memento memento = gamer.createMemento();
		
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println("==== " + i);
			System.out.println("현 상태: " + gamer.toString());
			
			gamer.bet();
			
			System.out.println("돈은 " + gamer.getMoney() + "원이 되었습니다.");
			
			if(gamer.getMoney() > memento.getMoney()) {
				System.out.println("(많이 증가했으니 여기서 저장하자)");
				memento = gamer.createMemento();
				
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(gameData));
				oos.writeObject(memento);
				oos.close();
			} else if(gamer.getMoney() <= memento.getMoney() / 2) {
				System.out.println("(많이 줄었으니 저장한거로 다시하자)");
				gamer.restoreMemento(memento);
			}
			
			System.out.println();
		}
		
	}
	
}
