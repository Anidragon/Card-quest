import java.awt.Color;

import javax.swing.JOptionPane;

public class MeditationCard extends Card
{
	public MeditationCard()
	{
		super(Color.GREEN, "This card increases your health by 10% and predicts the enemy's next move", 2, "Meditation");
	}
	
	
	public void use(Hero hero, Enemies enemy) 
	{
		JOptionPane.showMessageDialog(null, "The enemy's next move is " + enemy.getNextMove());
		hero.setHealth((int)(hero.getHealthStat() * 0.1));	
		
	}	
	
	
	
}