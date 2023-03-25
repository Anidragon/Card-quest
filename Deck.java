import java.util.ArrayList;
public class Deck
{

	private ArrayList<Card> deck;
	private ArrayList<Card> discardPile;
	private ArrayList<Card> hand;
	
	public Deck()
	{
		this.deck = new ArrayList<Card>();
		this.hand = new ArrayList<Card>();
		this.discardPile = new ArrayList<Card>();
	}
	
	//player takes cards from the top of the deck 
	public void draw()
	{
		int missing = 3 - hand.size();
		if(deck.size() >= missing)
		{
			for(int i = 0; i < missing; i++)
			{
				hand.add(deck.remove(0));
			}
			if(deck.size() == 0)
			{
				reShuffle();
			}
		}
		
		else
		{
			reShuffle();
			draw();
		}
	}
	
	//shuffles deck
	public void reShuffle()
	{
		while(discardPile.size() > 0)
		{
		   deck.add(discardPile.remove((int)(Math.random() * discardPile.size())));	
		}
	}
	
	//activates card effect
	public void use(Card card, Hero hero, Enemies enemy)
	{
		card.use(hero, enemy);
		discardPile.add(card);
		hand.remove(card);
		draw();
	}
	
	public ArrayList<Card> getDeck()
	{
		return deck;
	}
	
	public ArrayList<Card> getHand()
	{
		return hand;
	}
	
	public ArrayList<Card> getDiscard()
	{
		return discardPile;
	}
	
	public void addCard(Card card)
	{
		deck.add(card);
	}
}
