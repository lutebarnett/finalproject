package battle;

public class Minion extends Enemy{
	
	public Minion() {
		super(500,10,"Minion");
	}
	
	public String description() {
		return "A demonic servant that causes mayhem wherever it goes!";
	}
	
	/**
	 * returns an Action object that contains a string (representing the enemey's
	 * action description) and an int (that represents the damage).
	 * return Action object
	 */
	public Action randomActions() {
		StringBuilder s = new StringBuilder();
		int damage;
		
		int random = (int) (Math.random() * 2) + 1;
		if(random == 1) {
			s.append("The enemy holds up their arm and brings their claws down at you!\n");
			damage = slash();
			
			if(critChance()) {
				damage = damage * 2;
				s.append("CRITICAL HIT! The enemy strikes a weak point!\n");
				s.append(damage + "DAMAGE HAS BEEN DEALT TO YOU!!");
			} else {
				s.append(damage + " damage was dealt to you");
			}
		} else {
			s.append("The enemy opens their mouths and bites your arm! \n");
			damage = bite();
			
			if(critChance()) {
				damage = damage * 2;
				s.append("CRITICAL HIT! The enemy strikes a weak point!\n");
				s.append(damage + "DAMAGE HAS BEEN DEALT TO YOU!!");
			} else {
				s.append(damage + " damage was dealt to you");
			}
		}
		
		Action a = new Action(damage, s.toString());
		
		return a;
	}
	
	/**
	 * Represents a possible attack that a Minion can do
	 * @return damage dealt
	 */
	public int slash() {
		return super.dealDamage();
	}
	
	/**
	 * Represents a possible attack that a Minion can do. The damage done is greater
	 * than the damage done with slash.
	 * @return
	 */
	public int bite() {
		return dealDamage() + 20;
	}

}
