package battle;

public class DemonLord extends Enemy {
	
	DemonLord(int i, int b, String c){
		super(100000, 3000, "Itmic Algor");
	}
	
	public String description() {
		return "The monster who desire's the world's end! The leader of all demons! THE DEMON LORD!!!";
	}
	
	public Action randomActions() {
		StringBuilder s = new StringBuilder();
		int damage;
		
		int random = (int) Math.random() * 1 + 1;
		if(random == 1) {
			s.append("The demon lords moves towards you and strikes with uncanny precision with his sword!\n");
			damage = slash();
			
			if(critChance()) {
				damage = damage * 2;
				s.append("CRITICAL HIT! The enemy strikes a weak point!\n");
				s.append(damage + "DAMAGE HAS BEEN DEALT TO YOU!!");
			} else {
				s.append(damage + " damage was dealt to you");
			}
		}
		else {
			s.append("A dark flame flickers to life and surges towards! \n");
			damage = hellfire();
			
			if(critChance()) {
				damage = damage * 2;
				s.append("CRITICAL HIT! Your body was unable to handle the heat!\n");
				s.append(damage + "DAMAGE HAS BEEN DEALT TO YOU!!");
			} else {
				s.append(damage + " damage was dealt to you");
			}
		}
		
		Action a = new Action(damage, s.toString());
		
		return a;
		
	}
	
	
	public int slash() {
		return super.dealDamage();
	}
	
	public int hellfire() {
		return super.dealDamage() + 200;
	}
}
