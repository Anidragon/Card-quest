import java.awt.Color;

public class Flurry extends Card
{
	public Flurry()  
	{ 
	super(Color.ORANGE, "This Attack does three times the damage of the Hero's attackstat", 5, "Flurry"); 
	 
	 
	} 
	
	public void use(Hero hero, Enemies enemy)
	{
		enemy.takeDamage(hero.getAttackStat()*3); 
		
		
	}
	
	
	
}