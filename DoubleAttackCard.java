import java.awt.Color;

public class DoubleAttackCard extends Card
{
	public DoubleAttackCard()
	{
		super(Color.RED, "This card does double the damage of your AttackStat to the enemy  ", 3, "Double Strike");
		
		
	}
	
	public void use(Hero hero, Enemies enemy)
	{
		int damage = (hero.getAttackStat() * 2);
		enemy.takeDamage(damage);		
	}
	
	
	
	
	
}