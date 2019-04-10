package battle;

public class General extends Enemy{

	public General() {
		super(1000, 50, "General General");
	}

	@Override
	String description() {
		return "A mook bigger than a mook. The General General. Yes his name is actually General.";
	}

	@Override
	public Action randomActions() {
		StringBuilder s = new StringBuilder();
		int damage;
		
		int random = (int)( Math.random() * 2 + 1);
		if(random == 1) {
			s.append("General General busts out his ultimate technique! GIGAPUNCH! Its not very effective! \n");
			damage = gigaPunch();
			
			if(critChance()) {
				damage = damage * 2;
				s.append("CRITICAL HIT! The attack is surprisingly affective! \n");
				s.append(damage + "DAMAGE HAS BEEN DEALT TO YOU!!");
			} else {
				s.append(damage + " damage was dealt to you");
			}
		}
		else if(random == 2) {
			s.append("The general points his fingers at you and a tiny beam shoots at you!\n");
			damage = hyperBeam();
			
			if(critChance()) {
				damage = damage * 2;
				s.append("CRITICAL HIT! The enemy strikes a weak point!\n");
				s.append(damage + "DAMAGE HAS BEEN DEALT TO YOU!!");
			} else {
				s.append(damage + " damage was dealt to you");
			}
		}
		else {
			s.append("THe enemy jumps high into the sky and drops down with both of his feet on your face! \n");
			damage = dropKick();
			
			if(critChance()) {
				damage = damage * 2;
				s.append("CRITICAL HIT! You body shatters upon getting hit!\n");
				s.append(damage + "DAMAGE HAS BEEN DEALT TO YOU!!");
			} else {
				s.append(damage + " damage was dealt to you");
			}
		}
		
		Action a = new Action(damage, s.toString());
		
		return a;
	}
	
	public int gigaPunch() {
		return super.dealDamage();
	}
	
	public int hyperBeam() {
		return super.dealDamage() + 1;
	}
	
	public int dropKick() {
		return super.dealDamage() + 10;
	}
	

}
