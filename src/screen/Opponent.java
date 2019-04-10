package screen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import battle.DemonLord;
import battle.Enemy;
import battle.General;
import battle.Minion;

public class Opponent {
	
	private Enemy e;
	
	public Opponent() {
		
		try {
			Scanner input = new Scanner(new File("src/BattleDecision.txt"));
			int choice = input.nextInt();
			if(choice == 1) {
				e = new Minion();
			} else if (choice == 2){
				e = new General();
			} else if (choice == 3){
				e = new DemonLord();
			} else {
				e = new Minion();
			}
			
			input.close();
		}catch(FileNotFoundException ex) {
			System.out.println("Error, unable to get enemy");
			e = new DemonLord();
		}
	}
	
	public Enemy getOpponent() {
		return e;
	}

}
