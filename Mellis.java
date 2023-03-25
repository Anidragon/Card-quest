import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Mellis extends Enemies
{
 
	private String nextMove;
	private ArrayList<String> rotation;
	public Mellis(int healthStat, int attackStat, int reward) {
		super(healthStat, attackStat, reward);
		rotation = new ArrayList<String>();
		rotation.add("Attack");
		rotation.add("Attack");
		rotation.add("Heal");
		rotation.add("Debuff");
		nextMove = rotation.get(0);
	}
	
	public void TakeAction(Hero hero)
	{
		
		switch(nextMove)
		{
			case "Attack":
				int att = getAttackStat();
				hero.takeDamage(getAttackStat());
				JOptionPane.showConfirmDialog(null, "the PeaShooter Mellis chokeSlammed for " + att + " damage!", "Attacked!", JOptionPane.PLAIN_MESSAGE);
				break;
			case "Debuff":
				int deb = -hero.getAttackStat()/6;
				hero.changeAttackStat(-hero.getAttackStat()/6);
				JOptionPane.showConfirmDialog(null, "the Peashooter Mellis lowered your attack by " + deb + " points", "Lowered Attack", JOptionPane.PLAIN_MESSAGE);
				break;
			case "Heal":
				heal(this.getOHealth()/10);
				JOptionPane.showConfirmDialog(null, "the PeaShooter Mellis healed itself by  " + this.getOHealth()/10 + " health", "Healed", JOptionPane.PLAIN_MESSAGE);
				break;
		}
		
		nextMove = rotation.get((int)(Math.random() * rotation.size()));
	}
	
	public String getNextMove()
	{
		return nextMove;
	}

}