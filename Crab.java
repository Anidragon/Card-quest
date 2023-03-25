import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Crab extends Enemies
{
	private String nextMove;
	private ArrayList<String> rotation;
	
	public Crab(int healthStat, int attackStat, int reward) 
	{
		super(healthStat, attackStat, reward);
		rotation = new ArrayList<String>();
		rotation.add("Attack");
		rotation.add("Attack");
		rotation.add("Shield");
		rotation.add("Shield");
		rotation.add("specialMove");
		nextMove = rotation.get(0);
		
	}

	public void TakeAction(Hero hero)
	{
		
		switch(nextMove)
		{
			case "Attack":
				int att = getAttackStat();
				hero.takeDamage(getAttackStat());
				JOptionPane.showConfirmDialog(null, "the Crab attacked for " + att + " damage!", "Attacked!", JOptionPane.PLAIN_MESSAGE);
				break;
			case "Shield":
				int deb = this.getOHealth()/3;
				this.shield(this.getOHealth()/3);
				JOptionPane.showConfirmDialog(null, "the Crab shielded itself by " + deb + " points", "Shielded", JOptionPane.PLAIN_MESSAGE);
				break;
			case "specialMove":
				heal(this.getAttackStat());
				hero.takeDamage(this.getAttackStat());
				JOptionPane.showConfirmDialog(null, "the Crab stole " + this.getAttackStat() + " of your health!", "Special Attack", JOptionPane.PLAIN_MESSAGE);
				break;
		}
		
		nextMove = rotation.get((int)(Math.random() * rotation.size()));
	}
	
	public String getNextMove()
	{
		return nextMove;
	}

	
}
