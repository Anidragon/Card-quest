import java.awt.Color;

public class ChugJug extends Card
{
	public ChugJug()
	{
	super(Color.BLUE, "This card heals you back to full health along with shield that is equivalent to your HealthStat", 4, "Chug Jug");	
		
		
	}
	
	public void use(Hero hero)
	{
		hero.setHealth(hero.getHealthStat());
		hero.shield(hero.getHealthStat());
		
		
	}
	
	
	
}