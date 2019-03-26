package battle;

public class Character {
	private int health;
	private int attack;
	
	public Character(int health, int attack) {
		this.health = health;
		this.attack = attack;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void takeDamage(int damage) {
		health = health - damage;
	}
	
	public int dealDamage() {
		return attack;
	}

}
