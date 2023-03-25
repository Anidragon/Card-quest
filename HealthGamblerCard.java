import java.awt.Color;

public class HealthGamblerCard extends Card
{
	public HealthGamblerCard()
	{
		super(Color.YELLOW, "This card gives you a 50% chance of healing to full health but theres also a 50% chance of your health decreasing to 1", 3, "Health Gambler Card");
		
		
	}
	public void use(Hero hero)
	{
		double gamble = Math.random()*101 + 1;
		if(gamble < 50)
		{
			hero.setHealth(hero.getHealthStat());
		}
		else
		{
			hero.setHealth(1);	
		}
		
	}
	
	
	
}