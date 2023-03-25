import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BrownDragon extends Enemies
{
    
	
	private String nextMove;
	private ArrayList<String> rotation;
	
	public BrownDragon(int healthStat, int attackStat, int reward)
	{
		super(healthStat, attackStat, reward);
		
		rotation = new ArrayList<String>();
		rotation.add("Attack");
		rotation.add("Debuff");
		rotation.add("Attack");
		rotation.add("splAttack");
		rotation.add("splAttack2");
		rotation.add("Heal");
		nextMove = rotation.get(0);
		
		
		
	}
	
	public void TakeAction(Hero hero)
	{
		
		
 
		switch(nextMove)
		{
			case "Attack":
				hero.takeDamage(getAttackStat());
				JOptionPane.showMessageDialog(null, "the Dragon did " + getAttackStat() + " damage!");
				break;
			case "Debuff":
				int lessen = hero.getAttackStat()/5;
				hero.changeAttackStat(-hero.getAttackStat()/5);
				JOptionPane.showMessageDialog(null, "the Dragon lowered your attack by " + lessen, "Lowered Attack", JOptionPane.PLAIN_MESSAGE);
				break;
			case "Heal":
				int heals = this.getOHealth()/10;
				heal(this.getOHealth()/10);
				JOptionPane.showMessageDialog(null, "The Dragon Healed " + heals, "Healed", JOptionPane.PLAIN_MESSAGE);
				break;
			case "splAttack":
				specialAttack(hero);
				break;
			case "splAttack2" :
				specialAttack2(hero);
				break;
				
		}
		
		nextMove = rotation.get((int)(Math.random() * rotation.size()));
	}
	
	public void specialAttack(Hero hero)
	{
		int rand = (int)(Math.random()*3);
		int attack = this.getAttackStat()/5;
		hero.takeDamageOverTime( rand + 1, this.getAttackStat()/5);
		hero.takeDamage(this.getAttackStat()/2);
		JOptionPane.showMessageDialog(null, "The Dragon burned you, you take " + this.getAttackStat()/2 + "damage and " + attack + " damage for " + rand + " turns" , "Special Attack", JOptionPane.PLAIN_MESSAGE );
	}
    
	public void  specialAttack2(Hero hero)
	{
		int rand = (int)(Math.random() * 5) + 1;
		
		if(rand == 1)
		{
			int attack = this.getAttackStat()/5;
			hero.takeDamageOverTime(2, this.getAttackStat()/5);
			JOptionPane.showMessageDialog(null, "The Dragon burned you, you take " + attack + " damage for 2 turns", "Special Attack", JOptionPane.PLAIN_MESSAGE);
		}
		
		if(rand == 2 || rand == 3)
		{
			int heals = hero.getAttackStat();
			int attack = this.getAttackStat();
			hero.takeDamage(this.getAttackStat());
			this.heal(hero.getAttackStat());
			JOptionPane.showMessageDialog(null, "The Dragon deals " + attack + " damage and heals " + heals + " damage", "Special Attack", JOptionPane.PLAIN_MESSAGE);
		}
		
		if(rand == 4)
		{
			int attack = this.getAttackStat() * 3;
			hero.takeDamage(this.getAttackStat() * 3);
			this.takeDamage(hero.getAttackStat() * 2);
			JOptionPane.showMessageDialog(null, "The Dragon deals " + attack + " damage it also takes " + hero.getAttackStat() * 2 + " recoil damage" , "Special Attack", JOptionPane.PLAIN_MESSAGE);
		}
		
		if(rand == 5)
		{
			int attack = this.getAttackStat() * 2;
			hero.takeDamage(this.getAttackStat()*2);
			JOptionPane.showMessageDialog(null, "The Dragon deals " + attack , "Special Attack", JOptionPane.PLAIN_MESSAGE);
		}
			
	}
	
	public String getNextMove()
	{
		return nextMove;
	}
	
	

	
	
}
