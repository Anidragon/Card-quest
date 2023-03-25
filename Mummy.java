import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Mummy extends Enemies
{
	private String nextMove;
	private ArrayList<String> rotation;
	
	public Mummy(int healthStat, int attackStat, int reward) 
	{
		super(healthStat, attackStat, reward);
		rotation = new ArrayList<String>();
		rotation.add("Attack");
		rotation.add("Debuff");
		rotation.add("Attack");
		rotation.add("Shield");
		rotation.add("specialMove");
		rotation.add("specialMove2");
		nextMove = rotation.get(0);
		
	}

	public void TakeAction(Hero hero)
	{
		
		switch(nextMove)
		{
			case "Attack":
				int att = getAttackStat();
				hero.takeDamage(getAttackStat());
				JOptionPane.showConfirmDialog(null, "the Mummy attacked for " + att + " damage!", "Attacked!", JOptionPane.PLAIN_MESSAGE);
				break;
			case "Shield":
				int deb = this.getOHealth()/3;
				this.shield(this.getOHealth()/3);
				JOptionPane.showConfirmDialog(null, "the Mummy shielded itself by " + deb + " points", "Shielded", JOptionPane.PLAIN_MESSAGE);
				break;
			case "specialMove":
				int attack = this.getAttackStat()/6;
				hero.takeDamageOverTime(4, this.getAttackStat()/6);
				hero.takeDamage(hero.getShield());
				JOptionPane.showConfirmDialog(null, "the Mummy removed your shield and deals " + attack + " damage every turn for 4 turns", "Special Attack", JOptionPane.PLAIN_MESSAGE);
				break;
			case "specialMove2":
				int buff = this.getAttackStat()/5;
				this.buff(this.getAttackStat()/5);
				JOptionPane.showConfirmDialog(null, "the Mummy buffed its attack by " + buff , "Special Attack", JOptionPane.PLAIN_MESSAGE);
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
