import java.awt.Color;

public class Armor extends Card
{
	public Armor()
	{
		super(Color.ORANGE, "This card activates a shield that is equal to the Hero's healthstat", 3, "Armor");
		
		
	}
	
	public void use(Hero hero)
	{
	
		hero.shield(hero.getHealthStat());
		
	}
	
	
	
	
}