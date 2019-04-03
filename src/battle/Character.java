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
	
	/**
	 * All characters have a chance to deal double damage (or "crit") and this method will dictate whether or not
	 * this is true. Although the number will not be calculated, a random number (between 1 and 100) 
	 * will be generated and if that number if 50, it will return true. In other words, this method 
	 * will represents a 1 in 100 chance of something
	 * @return boolean (true or false of whether a crit happens or not)
	 * 
	 */
	public boolean critChance() {
		int max = 100;
		int min = 1;
		int range = max - min;
		
		int random = (int) (Math.random()*range) + min;
		
		if(random == 50) {
			return true;
		}
		
		return false;
	}
}
