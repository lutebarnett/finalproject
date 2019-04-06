package battle;


public abstract class Enemy extends Character{
	
	public Enemy(int health, int attack, String name) {
		super(health, attack, name);
	}
	
	abstract String description();
	
	public abstract Action randomActions();
}
