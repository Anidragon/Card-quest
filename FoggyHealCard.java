import java.awt.Color;

public class FoggyHealCard extends Card
{
	public FoggyHealCard()
	{
		super(Color.GREEN, "This card heals you back to full health but also heals the enemy back by 25% of its healthStat", 3, "Foggy Heal");
		
	}
	
	public void use(Hero hero, Enemies enemy)
	{
		hero.setHealth(hero.getHealthStat());
		double amt = enemy.getOHealth() * 0.25;
		enemy.setHealth((int)(amt));
		
		
	}
	
	
	
	
}