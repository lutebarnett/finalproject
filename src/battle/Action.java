package battle;

/**
 * The class represents the actions of all characters. The purpose of Action is to
 * contain a String that represents the description of an action as well as an int that 
 * return this
 * @author lij19
 *
 */

public class Action {
	private int damage;
	private String description;
	
	Action(int damage, String description){
		this.damage = damage;
		this.description = description;
	}

	public int getDamage() {
		return this.damage;
	}
	
	public String getDesciption() {
		return this.description;
	}
}
