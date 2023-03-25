import java.awt.Color;

public class FinalBreathCard extends Card
{
	public FinalBreathCard()
	{
		super(Color.RED, "This card will do triple the damage of your regular attackStat if your health is less than 10% of your healthStat otherwise this card will only heal you by 10% of your healthStat", 3, "Final Breath");
		
		
		
	}
	
	public void use(Hero hero, Enemies enemy)
	{
		if(hero.getHealth() < (hero.getHealthStat()*0.1))
		{
			enemy.takeDamage(3*hero.getAttackStat());
			
			
		}
		else
		{
		hero.setHealth((int)((hero.getHealthStat()*0.1)));	
			
			
		}
		
		
	}
	
	

}
