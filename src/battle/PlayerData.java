package battle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlayerData extends Character{
	
	private int mines;
	
	public PlayerData(int health, int attack) {
		super(health, attack);
		
		setMines();
	}
	
	public void setMines() {
		try {
			Scanner input = new Scanner(new File("NumberOfMines.txt"));
			mines = input.nextInt();
			input.close();
		} catch (FileNotFoundException e) {
			mines = 0;
			System.out.println("File not found! Unable to get number of mines!");
		}
	}
	
	public int getMines() {
		return mines;
	}
	
	public int useMine() {
		if(mines - 1 < 0) {
			return -1;
		}
		
		mines--;
		
		return 500;
	}

}
