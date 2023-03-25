import java.awt.Color;

public class CriticalHit extends Card {

	public CriticalHit() 
	{
		super(Color.RED, "Using this card gives you a 20% chance of doing 50% more damage, otherwise doing the same amount", 2, "Critical Hit");
	}
	
	public void use(Hero hero, Enemies enemy) {
		double r = (Math.random()*100)+1;
		if(r <= 20.0) {
		enemy.takeDamage((int)(hero.getAttackStat()*1.5));
		}
		else {
		enemy.takeDamage((int)(hero.getAttackStat()));
		}
		
	}
	
	
	
}
