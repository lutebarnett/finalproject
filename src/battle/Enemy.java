package battle;


public class Enemy extends Character{

	private int actions;
	
	public Enemy(int health, int attack, int actions) {
		super(health, attack, "name");
		this.actions = actions;
	}
	
	public int random() {
		int num = (int) Math.random()*(actions + 1);
		
		return num;
	}
	
}
