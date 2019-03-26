package battle;

public class Character {
	private int health;
	private int attack;
	private String name;
	
	public Character(int health, int attack, String name) {
		this.health = health;
		this.attack = attack;
		this.name = name;
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
	
	public String getName() {
		return name;
	}

}
