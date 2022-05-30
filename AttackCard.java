
import java.awt.Color;
public class AttackCard extends Card
{

	
	

	public AttackCard() 
	{
		super(Color.RED, "The enemy takes damage equal" + "\n" + "to your current Attack Stat", 1, "Attack");
		
		
	}
	
	public void use(Hero hero, Enemies enemy)
	{
		
		enemy.takeDamage(hero.getAttackStat());
		
	}
	
	
}
