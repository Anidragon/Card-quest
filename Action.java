
public class Action {
//this is the code for how an enemy performs attack actions all attacks performed by enemies are done through this class.
	Enemies enemy;
	
	
	public Action(Enemies e)
	{
		enemy = e;
	}
	
	public void Attack(Hero hero)
	{
		hero.takeDamage(enemy.getAttackStat());
	}
	
	public void Heal(int heal)
	{
		enemy.heal(heal);
	}
	
	public void burn(Hero hero, int turns, int damage)
	{
		hero.takeDamageOverTime(turns, damage);
	}
	
}
