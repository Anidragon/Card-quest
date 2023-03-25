import java.util.ArrayList;

public class Hero 
{

	private int health;
	private String name;
	private int healthStat;
	private int OriginalA;
	private int attackStat;
	private Deck deck;
	private int gold;
	private int energy;
	private int DmgOT;
	private int turnsDMG;
	private int shield;
	
	public Hero(String name,int AttackStat, int healthStat, int gold)
	{
		this.healthStat = healthStat; 
		this.name = name;
		OriginalA = AttackStat;
		this.attackStat = OriginalA;
		health = healthStat;
		this.gold = gold;
		this.energy = 5;
		shield = 0;
		deck = new Deck();
		 
	}
	
	

	public int takeDamage(int damage)
	{
		if(shield >= damage)
		{
			shield -= damage;
			damage = 0;
		}
		
		else if(shield < damage)
		{
			damage -= shield;
			shield = 0;
		}
		
		health = health - damage;
		
		return health;
	}
	
	public void atStart()
	{
		shield = 0;
		energy += 5;
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
	

    public void gainReward(int reward)
    {
    	
    	gold += reward;
    	
    }

	
	public void takeDamageOverTime(int turns, int damage) 
	{
		DmgOT = damage;
		turnsDMG = turns;
	}
	
	public void shield(int amt)
	{
		shield += amt;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getAttackStat()
	{
		return attackStat;
	}
	
	public void changeAttackStat(int change)
	{
		attackStat += change;
	}
	
	public Deck getDeck()
	{
		return deck;
	}
	
	public int getHealthStat()
	{
		return healthStat;
	}

	public int getEnergy()
	{
		return energy;
	}
	
	public int getGold()
	{
		return gold;
	}
	
	
	public int getOAttack()
	{
		return OriginalA;
	}
	
	public void setOAttack(int amt)
	{
		OriginalA += amt;
		attackStat = OriginalA;
	}
	
	public void setOHealth(int amt)
	{
		healthStat += amt;
		health = healthStat;
	}
	
	public void setEnergy(int nrg)
	{
		energy += nrg;
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Card> getDeckList()
	{
		
		return deck.getDeck();
	}
	
	public ArrayList<Card> getFullDeckList()
	{
		ArrayList<Card> returner = new ArrayList<Card>();
		returner.addAll(deck.getDeck());
		returner.addAll(deck.getDiscard());
		returner.addAll(deck.getHand());
		return returner;
	}
	
	public ArrayList<String> getFullDeckListStr()
	{
		ArrayList<String> returner = new ArrayList<String>();
		for(int i = 0; i < deck.getDeck().size() ; i++)
		{
			returner.add(deck.getDeck().get(i).getName());
		}
		
		for(int i = 0; i < deck.getHand().size() ; i++)
		{
			returner.add(deck.getHand().get(i).getName());
		}
		
		for(int i = 0; i < deck.getDiscard().size() ; i++)
		{
			returner.add(deck.getDiscard().get(i).getName());
		}
		return returner;
	}



	public int getShield() 
	{
		
		return shield;
	}

	public void setHealth(int amt)
	{
		health += amt;
		if(health > healthStat)
		{
			health = healthStat;
		}
	}
	public void setShield(int amt)
	{
		shield = amt;
		
		
	}
}
