import java.awt.Color;

public class Card {
	//Color of the card denotes the type of card eg. Red = attack type 
	private Color color;
	//effect is the description of the card and what it does in battle
	private String effect;
	//energy is the amount that it costs to play
	private int energy;
	//name of the card
	private String name;
	
	
	public Card(Color color, String effect, int energy, String name)
	{
		this.color = color;
		this.effect = effect;
		this.energy = energy;
		this.name = name;
		
	}
	
	//this method is overidden by child classes to implement their usage in battle
	
	public void use(Hero hero, Enemies enemy)
	{
		
	}
	
	public String getEffect()
	{
		return effect;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public void setEnergy(int newEnergy)
	{
		energy = newEnergy;
	}
	
	public int getEnergy()
	{
		return energy;
	}
	
	public Color getColor()
	{
		return color;
	}

	
	
}
