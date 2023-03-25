import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CardShop extends JFrame
{
	private int cost;
	private ArrayList<String> cardList;
	private String reader1;
	private String reader2;
	private String reader3;
	private Color color1;
	private Color color2;
	private Color color3;
	public CardShop(Hero hero) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		if(hero.getFullDeckList().size() == 3)
		{
			cost = 10;
		}
		if(hero.getFullDeckList().size() == 4)
		{
			cost = 10;
		}
		if(hero.getFullDeckList().size() == 5)
		{
			cost = 10;
		}
		if(hero.getFullDeckList().size() == 6)
		{
			cost = 10;
		}
		if(hero.getFullDeckList().size() == 7)
		{
			cost = 20;
		}
		if(hero.getFullDeckList().size() == 8)
		{
			cost = 30;
		}
		if(hero.getFullDeckList().size() >= 9)
		{
			cost = 40;
		}
	
		cardList = new ArrayList<String>();
		cardList.add("Attack");
		cardList.add("Shield");
		cardList.add("Armor");
		cardList.add("Ultimate Combo");
		cardList.add("Triple Strike");
		cardList.add("Shield Sweeper");
		cardList.add("Sketchy Medicine");
		cardList.add("Shield Gambler");
		cardList.add("Risky Play");
		cardList.add("Poison Strike");
		cardList.add("Meditation");
		cardList.add("Health Gambler");
		cardList.add("Foggy Heal");
		cardList.add("Final Breath");
		cardList.add("Energy Gambler");
		cardList.add("Double Strike");
		cardList.add("Critical Hit");
		cardList.add("Chug Jug");
		cardList.add("Attack Gambler");
		cardList.add("Spadille");
		
		ArrayList<Card> cardObjList = new ArrayList<Card>();
		cardObjList.add(new AttackCard());
		cardObjList.add(new AttackGambler());
		cardObjList.add(new ChugJug());
		cardObjList.add(new Armor());
		cardObjList.add(new UltimateCombo());
		cardObjList.add(new TripleStrikeCard());
		cardObjList.add(new ShieldCard());
		cardObjList.add(new ShieldSweeper());
		cardObjList.add(new SketchyMedicine());
		cardObjList.add(new ShieldGamblerCard());
		cardObjList.add(new RiskyPlayCard());
		cardObjList.add(new PoisonStrikeCard());
		cardObjList.add(new MeditationCard());
		cardObjList.add(new HealthGamblerCard());
		cardObjList.add(new FoggyHealCard());
		cardObjList.add(new FinalBreathCard());
		cardObjList.add(new EnergyGamblerCard());
		cardObjList.add(new DoubleAttackCard());
		cardObjList.add(new CriticalHit());
		cardObjList.add(new Spadille());
		
		
		Card card1 = cardObjList.get((int)(Math.random()*20));
		Card card2 = cardObjList.get((int)(Math.random()*20));
		Card card3 = cardObjList.get((int)(Math.random()*20));
		
		AudioPlayer player = new AudioPlayer("Shop.wav", false );
		player.play();
		
	this.setLayout(new GridLayout());
	JMenuBar menuBar = new JMenuBar();
	this.setJMenuBar(menuBar);
    JMenuItem Back = new JMenuItem("Return");
    menuBar.add(Back);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    
    Back.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			int confirm = JOptionPane.showConfirmDialog(null, "are you sure you want to go back to the main Shop screen?", "Confirm", JOptionPane.YES_NO_OPTION);
			
			if(confirm == 0)
			{
				try {
					player.stop();
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				try {
					new Shop(hero);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
		}
		}
	});
    
    
    JPanel Card1 = new JPanel();
    Card1.setLayout(new GridLayout(2, 1, 100, 100));
    JPanel Card2 = new JPanel();
    Card2.setLayout(new GridLayout(2, 1, 100, 100));
    JPanel Card3 = new JPanel();
    Card3.setLayout(new GridLayout(2, 1, 100, 100));
    JPanel sellPanel = new JPanel();
    sellPanel.setLayout(new GridLayout());
    JButton Sell = new JButton("Sell a Card?");
    
    sellPanel.add(Sell);
    
    JButton read1 = new JButton("Read Effect");
    JButton buy1 = new JButton("Buy Card");
    
    
    JButton read2 = new JButton("Read Effect");
    JButton buy2 = new JButton("Buy Card");
  
    
    
    JButton read3 = new JButton("Read Effect");
    JButton buy3 = new JButton("Buy Card");
  
    Card1.add(read1);
    Card1.add(buy1);
    
    Card2.add(read2);
    Card2.add(buy2);
    
    Card3.add(read3);
    Card3.add(buy3);
    
    
    Card1.setBackground(card1.getColor());
    Card2.setBackground(card2.getColor());
    Card3.setBackground(card3.getColor());
   
    read1.addActionListener(new ActionListener()
   	{
   		public void actionPerformed(ActionEvent e)
   		{
   			JOptionPane.showMessageDialog(null, card1.getName() + '\n' +"Effect: " + card1.getEffect(), "Confirm", JOptionPane.PLAIN_MESSAGE);
   		}
   	});
    
    read2.addActionListener(new ActionListener()
   	{
   		public void actionPerformed(ActionEvent e)
   		{
   			JOptionPane.showMessageDialog(null, card2.getName() + '\n' +"Effect: " + card2.getEffect(), "Confirm", JOptionPane.PLAIN_MESSAGE);
   				
   		}
   		
   	});
    
    read3.addActionListener(new ActionListener()
   	{
   		public void actionPerformed(ActionEvent e)
   		{
   			JOptionPane.showMessageDialog(null, card3.getName() + '\n' +"Effect: " + card3.getEffect(), "Confirm", JOptionPane.PLAIN_MESSAGE);
   		}
   	});
    
    buy1.addActionListener(new ActionListener()
   	{
   		public void actionPerformed(ActionEvent e)
   		{
   			int o = JOptionPane.showConfirmDialog(null, "this card costs " + cost + " Would you like to buy it?", "Confirm", JOptionPane.YES_NO_OPTION);
   			
   			if(o == 0)
   			{
   				if(hero.getGold() - cost >= 0)
   				{
   					
   				try {
					player.stop();
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   				
   				dispose();
   				JOptionPane.showMessageDialog(null, "You bought the card! returning to main Shop", "Confirm", JOptionPane.PLAIN_MESSAGE);
   				hero.getDeck().getDeck().add(card1);
   				hero.gainReward(-cost);
   				
   				}
   				
   				else
   				{
   					JOptionPane.showMessageDialog(null, "You do not have enough gold to buy this card, you have only " + hero.getGold() + " gold");
   				}
   				
   				
   			
   				try {
					new Shop(hero);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   				
   				
   				
   			}
   		}
   	});
    
    buy2.addActionListener(new ActionListener()
   	{
    	public void actionPerformed(ActionEvent e)
   		{
   			int o = JOptionPane.showConfirmDialog(null, "this card costs " + cost + " Would you like to buy it?", "Confirm", JOptionPane.YES_NO_OPTION);
   			
   			if(o == 0)
   			{
   				if(hero.getGold() - cost >= 0)
   				{
   					
   				try {
					player.stop();
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   				
   				dispose();
   				JOptionPane.showMessageDialog(null, "You bought the card! returning to main Shop", "Confirm", JOptionPane.PLAIN_MESSAGE);
   				hero.getDeck().getDeck().add(card2);
   				hero.gainReward(-cost);
   				
   				}
   				
   				else
   				{
   					JOptionPane.showMessageDialog(null, "You do not have enough gold to buy this card, you have only " + hero.getGold() + " gold");
   				}
   				
   				
   			
   				try {
					new Shop(hero);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   				
   				
   				
   			}
   		}
   	});
    
    buy3.addActionListener(new ActionListener()
   	{
    	public void actionPerformed(ActionEvent e)
   		{
   			int o = JOptionPane.showConfirmDialog(null, "this card costs " + cost + " Would you like to buy it?", "Confirm", JOptionPane.YES_NO_OPTION);
   			
   			if(o == 0)
   			{
   				if(hero.getGold() - cost >= 0)
   				{
   					
   				try {
					player.stop();
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   				
   				dispose();
   				JOptionPane.showMessageDialog(null, "You bought the card! returning to main Shop", "Confirm", JOptionPane.PLAIN_MESSAGE);
   				
   				
   				hero.getDeck().getDeck().add(card3);
   				hero.gainReward(-cost);
   				
   				}
   				
   				else
   				{
   					JOptionPane.showMessageDialog(null, "You do not have enough gold to buy this card, you have only " + hero.getGold() + " gold");
   				}
   				
   				
   			
   				try {
					new Shop(hero);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   				
   				
   				
   			}
   		}
   	});
    
    this.add(Card1);
    this.add(Card2);
    this.add(Card3);
   
    
      
    
    this.setResizable(false);
	this.setTitle("Shop");
	this.setVisible(true);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
    
	
	
	
	
}
