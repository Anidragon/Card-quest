import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Eagle extends Enemies
{

	private String nextMove;
	private ArrayList<String> rotation;
	private boolean recoil = false;
	public Eagle(int healthStat, int attackStat, int reward) 
	{
		super(healthStat, attackStat, reward);
		rotation = new ArrayList<String>();
		rotation.add("Attack");
		rotation.add("Attack");
		rotation.add("Heal");
		rotation.add("Heal");
		rotation.add("specialMove");
		rotation.add("speacilMove2");
		nextMove = rotation.get(0);
		
	}

	public void TakeAction(Hero hero)
	{
		
		switch(nextMove)
		{
			case "Attack":
				int att = getAttackStat();
				hero.takeDamage(getAttackStat());
				JOptionPane.showConfirmDialog(null, "the Eagle attacked for " + att + " damage!", "Attacked!", JOptionPane.PLAIN_MESSAGE);
				break;
				
			case "Heal":
				int deb = -hero.getAttackStat()/6;
				this.shield(this.getOHealth()/3);
				JOptionPane.showConfirmDialog(null, "the Crab shielded itself by " + deb + " points", "Shielded", JOptionPane.PLAIN_MESSAGE);
				break;
			case "specialMove":
				int boom = hero.getShield();
				heal(hero.getShield());
				hero.takeDamage(hero.getShield());
				JOptionPane.showConfirmDialog(null, "the Eagle removed your shield and healed that amount: " + boom + " health", "Special Attack", JOptionPane.PLAIN_MESSAGE);
				break;
			case "specialMove2":
				heal(this.getAttackStat());
				hero.takeDamage(this.getAttackStat());
				recoil = true;
				JOptionPane.showConfirmDialog(null, "the Eagle dealed " + this.getAttackStat()*2 + " damage!, it has to wait one turn to recover", "Special Attack", JOptionPane.PLAIN_MESSAGE);
				break;
			case "Nothing":
				recoil = false;
				JOptionPane.showConfirmDialog(null, "The Eagle is recovering from its last attack", "Rest", JOptionPane.PLAIN_MESSAGE);
				break;
		}
		
		if(recoil)
		nextMove = "Nothing";
		
		nextMove = rotation.get((int)(Math.random() * rotation.size()));
	}
	
	public String getNextMove()
	{
		return nextMove;
	}

}
