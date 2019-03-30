package battle;

public class Character {
	private final int maxHealth;
	private int health;
	private int attack;
	private String name;
	
	public Character(int health, int attack, String name) {
		this.maxHealth = health;
		this.health = health;
		this.attack = attack;
		this.name = name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getMaxHealth() {
		return maxHealth;
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
