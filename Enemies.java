import java.util.ArrayList;

public class Enemies {

	//stats of the enemies
	private int health;
	private int healthStat;
	private int attackStat;
	//amount of gold you get for defeating the enemy 
	private int reward;
	
	//implements a turn base damage
	private int turnsDMG;
	private int DmgOT;
	private int shield;
	
	//checks if the enemy is alive or not
	private boolean isdead;
	
	public Enemies(int healthStat, int attackStat, int reward)
	{
		this.isdead = false;
		this.health = healthStat;
		this.healthStat = healthStat;
		this.attackStat = attackStat;
		this.reward = reward;
			
	}
	
	//sets the values of the enemy to the default values
	public void atStart()
	{
		shield = 0;
		if(DmgOT > 0 && turnsDMG > 0)
		{
			takeDamage(DmgOT);
			turnsDMG--;
			if(turnsDMG == 0)
			{
				DmgOT = 0;
			}
		}
		
	}
	
	public int getOHealth()
	{
		return healthStat;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getAttackStat()
	{
		return attackStat;
	}
	
	//method to deal damage to the enemy
	public int takeDamage(int damage)
	{
		health = health - damage;
		if(health <= 0)
		{
			die();
			return health;
		}
		
		return health;
		
	}
	
	//method to implement damage over time
	public void takeDamageOverTime(int turns, int damage) 
	{
		DmgOT = damage;
		turnsDMG = turns;
	}
	
	
	public void die()
	{
		
	}
	
	public void dealDamage(int damage, Hero hero)
	{
		  hero.takeDamage(damage);
		 
	}
	
	public void buff(int buff)
	{
		attackStat += buff;
	}
	
	public void heal(int heal)
	{
		health += heal;
		if (health > healthStat)
		{
			health = healthStat;
		}
	}
	
	public void debuff(int debuff)
	{
		attackStat-= debuff;
	}
	
	public int currHealth()
	{
		return health;
	}
	
	public int getReward()
	{
		return reward;
	}
	
	public void shield(int amt)
	{
		shield += amt;
		
	}
	
	public int getShield()
	{
		return shield;
	}
	
	//method is overidden by child classes in order to perform an action against the hero 
	public void TakeAction(Hero hero)
	{
		
	}
	
	public String getNextMove()
	{
		return null;
	}
	
	public void setDeath()
	{
		isdead = true;
	}
	
	public boolean isDead()
	{
		return isdead;
	}

	public void setHealth(int amt)
	{
		health += amt;
		if(health > healthStat)
		{
			health = healthStat;
		}
	}
	
	
}
