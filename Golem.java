import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Golem extends Enemies
{
	private String nextMove;
	private ArrayList<String> rotation;
	
	public Golem(int healthStat, int attackStat, int reward) 
	{
		super(healthStat, attackStat, reward);
		rotation = new ArrayList<String>();
		rotation.add("Attack");
		rotation.add("Debuff");
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
				JOptionPane.showConfirmDialog(null, "the Golem attacked for " + att + " damage!", "Attacked!", JOptionPane.PLAIN_MESSAGE);
				break;
			case "Shield":
				int deb = this.getOHealth()/3;
				this.shield(this.getOHealth()/3);
				JOptionPane.showConfirmDialog(null, "the Golem shielded itself by " + deb + " points", "Shielded", JOptionPane.PLAIN_MESSAGE);
				break;
			case "specialMove":
				shield(this.getAttackStat());
				hero.takeDamage(this.getAttackStat());
				JOptionPane.showConfirmDialog(null, "the Golem shielded itself by " + this.getAttackStat() + " and attacked by th same amount ", "Special Attack", JOptionPane.PLAIN_MESSAGE);
				break;
			case "Debuff":
				int lessen = hero.getAttackStat()/6;
				hero.changeAttackStat(-hero.getAttackStat()/6);
				JOptionPane.showMessageDialog(null, "the Golem lowered your attack by " + lessen, "Lowered Attack", JOptionPane.PLAIN_MESSAGE);
		}
		
		nextMove = rotation.get((int)(Math.random() * rotation.size()));
	}
	
	public String getNextMove()
	{
		return nextMove;
	}

	
}
