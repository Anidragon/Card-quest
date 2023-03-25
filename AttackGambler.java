import java.awt.Color;

public class AttackGambler extends Card 
{
	public AttackGambler()
	{
		super(Color.RED, "This card gives you a 10% chance of fully killing your enemy otherwise it will do no damage", 2, "Attack Gambler");
		
		
	}
	public void use(Hero hero, Enemies enemy)
	{
		double gamble = Math.random()*101 + 1;
		if(gamble <= 10)
		{
			enemy.takeDamage(enemy.getHealth());
			
			
		}
		
	}
	
}