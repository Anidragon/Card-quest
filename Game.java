	
	import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*; 
	

public class Game extends JFrame 
{
	
	private Hero hero;
	private Enemies enemy;
	private AudioPlayer player;
	private boolean notSent = true;

	
	public Game(String back, String MonsterPIC, int MonsterWidth, int MonsterHeight, Hero hero, Enemies enemy) throws IOException, UnsupportedAudioFileException, LineUnavailableException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		
		
		if(enemy.getReward() == 50)
		 {
			 player = new AudioPlayer("Slime.wav", false);
				player.play();
		 }
		if(enemy.getReward() == 850)
		 {
			 player = new AudioPlayer("EagleFight.wav", false);
				player.play();
		 }
		if(enemy.getReward() == 700)
		 {
			 player = new AudioPlayer("TreeFight.wav", false);
				player.play();
		 }
		if(enemy.getReward() == 1400)
		 {
			 player = new AudioPlayer("snow.wav", false);
				player.play();
		 }
		if(enemy.getReward() == 2000)
		 {
			 player = new AudioPlayer("MellisFight.wav", false);
				player.play();
		 }
		
		 if(enemy.getReward() == 540)
		 {
			 player = new AudioPlayer("CrabFight.wav", false);
				player.play();
		 }
		 
		 if(enemy.getReward() == 20)
		 {
			 player = new AudioPlayer("GobFight.wav", false);
				player.play();
		 }
		 
		 if(enemy.getReward() == 170) 
		 {
			 player = new AudioPlayer("GolemFight.wav", false);
				player.play();
		 }
		 
		 if(enemy.getReward() == 300)
		 {
			 player = new AudioPlayer("MummyFight.wav", false);
				player.play();
		 }
		 
		 if(enemy.getReward() == 1000)
		 {
			 player = new AudioPlayer("DragonFight.wav", false);
				player.play();
		 }
		
			 
	
		this.hero = hero;
		this.enemy = enemy;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		JLabel contentPane = new JLabel();
		ImageIcon backy = new ImageIcon(back);
		
		contentPane.setIcon(resizeIcon(backy, 1600, 900));
		contentPane.setLayout(new BorderLayout());
        
		
	    this.setContentPane(contentPane);
	    ImageIcon icon = new ImageIcon(MonsterPIC); 
	    JLabel label = new JLabel(); 
	    
	    label.setIcon(resizeIcon(icon, MonsterWidth, MonsterHeight)); 
	    this.add(label, BorderLayout.NORTH);
	    
	    label.setHorizontalAlignment(label.RIGHT);
	    
	    //click to read effect of each of the three cards in hand
	    JButton read1 = new JButton("Read Effect");
	    JButton read2 = new JButton("Read Effect");
	    JButton read3 = new JButton("Read Effect");
	    
	    // click to use each card in hand
	    JButton use1 = new JButton("Use Card");
	    JButton use2 = new JButton("Use Card");
	    JButton use3 = new JButton("Use Card");
	   
	    //panel to hold all above components and card panels
	    JPanel hand = new JPanel();
	    
	    this.add(hand, BorderLayout.SOUTH);
	    
	    
	    //creating each card and adding the respective read and use buttons to each
	    JPanel card1 = new JPanel();
	    card1.add(read1);
	    card1.add(use1);
	    card1.setBackground(hero.getDeck().getDeck().get(0).getColor());
	    
	    
		
	    JPanel card2 = new JPanel();
	    card2.add(read2);
	    card2.add(use2);
	    card2.setBackground(hero.getDeck().getDeck().get(1).getColor());
	    
	    
	    JPanel card3 = new JPanel();
	    card3.add(read3);
	    card3.add(use3);
	    card3.setBackground(hero.getDeck().getDeck().get(2).getColor());
	    hero.getDeck().draw();
	   
	  //End- ends turn, Energy- displays available energy, Deck- displays cards in deck, Discard - displays cards in discard pile
	    JButton End = new JButton("End Turn");
	    JLabel Energy = new JLabel("Energy: "+ hero.getEnergy());
	    JLabel Deck = new JLabel("Deck: " + hero.getDeck().getDeck().size());
	    JLabel Discard = new JLabel("Discarded: "+ hero.getDeck().getDiscard().size());
	    
	  
	   
	    
	    
	    
	    //adding components in order from left to right to the Hand Panel
	    hand.setPreferredSize(new Dimension(300, 80));
	    
	    hand.add(Deck);
	    
	    hand.add(Discard);
	    
	    hand.add(card1);
	   
        hand.add(card2);
   
        hand.add(card3);
        
        hand.add(Energy);
       
        hand.add(End);
        
        
        JMenuBar menuBar = new JMenuBar();
        JMenu Options = new JMenu("Options");
        JMenuItem Save = new JMenuItem("Save");
        JMenuItem Shop = new JMenuItem("Shop");
        JMenuItem Stats = new JMenuItem("Stats");
        JMenuItem SaveClose = new JMenuItem("Save and Close");
        JMenuItem returnTo = new JMenuItem("Return to level select");
        
        Options.add(Save);
        
        Options.add(SaveClose);
        
        Options.add(Shop);
        
        Options.add(Stats);
        
        Options.add(returnTo);
        
	    menuBar.add(Options);
	    
        this.setJMenuBar(menuBar);
        
        JPanel healthPanel1 = new JPanel();
        healthPanel1.setLayout(new BorderLayout());
        healthPanel1.setOpaque(false);
        this.add(healthPanel1, BorderLayout.WEST);
        
        JPanel healthPanel2 = new JPanel();
        healthPanel2.setLayout(new BorderLayout());
        healthPanel2.setOpaque(false);
        this.add(healthPanel2, BorderLayout.EAST);
        
        JLabel healthEnemy = new JLabel(enemy.getHealth() + "/" + enemy.getHealth());
        JLabel healthHero = new JLabel(hero.getHealth() + "/" + hero.getHealthStat());
        
        healthPanel2.add(healthEnemy, BorderLayout.NORTH);
        healthEnemy.setHorizontalAlignment(healthEnemy.RIGHT);
        healthEnemy.setFont(new Font("Serif", Font.PLAIN, 100));
        healthEnemy.setForeground(Color.RED);
        
        healthPanel1.add(healthHero, BorderLayout.SOUTH);
        healthHero.setHorizontalAlignment(healthEnemy.LEFT);
        healthHero.setFont(new Font("Serif", Font.PLAIN, 100));
        healthHero.setForeground(Color.GREEN);
        
        //Actions:
        
        
        Stats.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(null, hero.getName() + "'s stats: "+ "\n" + "Attack: " + hero.getAttackStat() + "\n" + "Shield: " + hero.getShield() + "\n" + "Gold: " + hero.getGold() + "\n" + "Reward: " + enemy.getReward() +"\n" + "Enemy shield: " + enemy.getShield()+"\n" + "Enemy attack: " + enemy.getAttackStat());
    			
    		}

    	});
        
        Save.addActionListener(new ActionListener()
       	{
       		public void actionPerformed(ActionEvent e)
       		{
       			try {
					Stage.save(hero);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
       			
       		}

       	});
        
        SaveClose.addActionListener(new ActionListener()
       	{
       		public void actionPerformed(ActionEvent e)
       		{
       			try {
					Stage.save(hero);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
       			System.exit(0);
       		}

       	});
        
        Shop.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			int confirm = JOptionPane.showConfirmDialog(null, "are you sure?, If you go to the shop now you will lose your progress against this monster", "Confirm", JOptionPane.YES_NO_OPTION);
    			
    			if(confirm == 0)
    			{
    				try {
						Stage.save(hero);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    				dispose();
    				try {
						player.stop();
					} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
        
        returnTo.addActionListener(new ActionListener()
     	{
     		public void actionPerformed(ActionEvent e)
     		{
     			int confirm = JOptionPane.showConfirmDialog(null, "are you sure?, If you go to the Level select screen now you will lose your progress against this monster", "Confirm", JOptionPane.YES_NO_OPTION);
     			
     			if(confirm == 0)
     			{
     				try {
 						Stage.save(hero);
 					} catch (IOException e1) {
 						// TODO Auto-generated catch block
 						e1.printStackTrace();
 					}
     				dispose();
     				try {
						player.stop();
					} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
     				try {
						new LevelSelect();
					} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
     				
     				
     			}
     		}

     	});
        
      //hand buttons Action listeners:
	    read1.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(null, "Name: " + hero.getDeck().getHand().get(0).getName() + " | Energy: " + hero.getDeck().getHand().get(0).getEnergy() + "\n" + "Effect: " + hero.getDeck().getHand().get(0).getEffect());
    			
    		}

    	});
	    
	    use1.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			if(hero.getEnergy() < hero.getDeck().getHand().get(0).getEnergy())
    			{
    				JOptionPane.showMessageDialog(null, "not enough energy to use this card");
    			}
    			
    			else
    			{
    				hero.setEnergy(hero.getDeck().getHand().get(0).getEnergy() * -1);
    				hero.getDeck().getHand().get(0).use(hero, enemy);
    				hero.getDeck().getDiscard().add(hero.getDeck().getHand().remove(0));
    				hero.getDeck().draw();
    				Deck.setText("Deck: "+ hero.getDeck().getDeck().size());
    				Discard.setText("Discarded: "+ hero.getDeck().getDiscard().size());
    				card1.setBackground(hero.getDeck().getHand().get(0).getColor());
    				card2.setBackground(hero.getDeck().getHand().get(1).getColor());
    				card3.setBackground(hero.getDeck().getHand().get(2).getColor());
    				healthEnemy.setText(enemy.getHealth() + "/" + enemy.getOHealth());
    				healthHero.setText(hero.getHealth() + "/" + hero.getHealthStat());
    				Energy.setText("Energy: "+ hero.getEnergy());
    				if(hero.getHealth() <= 0)
    				{
    					try {
    						if(notSent)
    						{
							HeroDied();
							notSent = false;
    						}
						} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				}
    				
    				if(enemy.getHealth() <= 0)
    				{
    					try {
    						if(notSent)
    						{
    						EnemyDied();
    						notSent = false;
    						}
						} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				}
    				
    			}
    		}

    	});
	    
	    read2.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(null, "Name: " + hero.getDeck().getHand().get(1).getName() + " | Energy: " + hero.getDeck().getHand().get(0).getEnergy() + "\n" + "Effect: " + hero.getDeck().getHand().get(1).getEffect());
    			
    		}

    	});
	    
	    use2.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			if(hero.getEnergy() < hero.getDeck().getHand().get(1).getEnergy())
    			{
    				JOptionPane.showMessageDialog(null, "not enough energy to use this card");
    			}
    			
    			else
    			{
    				hero.setEnergy(hero.getDeck().getHand().get(1).getEnergy() * -1);
    				hero.getDeck().getHand().get(1).use(hero, enemy);
    				hero.getDeck().getDiscard().add(hero.getDeck().getHand().remove(1));
    				hero.getDeck().draw();
    				Deck.setText("Deck: "+ hero.getDeck().getDeck().size());
    				Discard.setText("Discarded: "+ hero.getDeck().getDiscard().size());
    				card1.setBackground(hero.getDeck().getHand().get(0).getColor());
    				card2.setBackground(hero.getDeck().getHand().get(1).getColor());
    				card3.setBackground(hero.getDeck().getHand().get(2).getColor());
    				healthEnemy.setText(enemy.getHealth() + "/" + enemy.getOHealth());
    				healthHero.setText(hero.getHealth() + "/" + hero.getHealthStat());
    				Energy.setText("Energy: "+ hero.getEnergy());
    				if(hero.getHealth() <= 0)
    				{
    					try {
    						if(notSent)
    						{
							HeroDied();
							notSent = false;
    						}
						} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				}
    				
    				if(enemy.getHealth() <= 0)
    				{
    					try {
    						if(notSent)
    						{
    						EnemyDied();
    						notSent = false;
    						}
						} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				}
    				
    			}
    		}

    	});
	    
	    read3.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			JOptionPane.showMessageDialog(null, "Name: " + hero.getDeck().getHand().get(2).getName() + " | Energy: " + hero.getDeck().getHand().get(0).getEnergy() + "\n" + "Effect: " + hero.getDeck().getHand().get(2).getEffect());
    			
    		}

    	});
	    
	    
//	    use3.addMouseListener(new MouseListener()
//	    {
//	    	
//
//			
//			public void mouseClicked(MouseEvent e) {
//				
//				
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				
//				
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				
//				use3.setBackground(Color.YELLOW);
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				
//				use3.setBackground(new JButton().getBackground());
//			}
//	    });
	    
	    use3.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			if(hero.getEnergy() < hero.getDeck().getHand().get(2).getEnergy())
    			{
    				JOptionPane.showMessageDialog(null, "not enough energy to use this card");
    			}
    			
    			else
    			{
    				hero.setEnergy(hero.getDeck().getHand().get(2).getEnergy() * -1);
    				hero.getDeck().getHand().get(2).use(hero, enemy);
    				hero.getDeck().getDiscard().add(hero.getDeck().getHand().remove(2));
    				hero.getDeck().draw();
    				Deck.setText("Deck: "+ hero.getDeck().getDeck().size());
    				Discard.setText("Discarded: "+ hero.getDeck().getDiscard().size());
    				card1.setBackground(hero.getDeck().getHand().get(0).getColor());
    				card2.setBackground(hero.getDeck().getHand().get(1).getColor());
    				card3.setBackground(hero.getDeck().getHand().get(2).getColor());
    				healthEnemy.setText(enemy.getHealth() + "/" + enemy.getOHealth());
    				healthHero.setText(hero.getHealth() + "/" + hero.getHealthStat());
    				Energy.setText("Energy: "+ hero.getEnergy());
    				if(hero.getHealth() <= 0)
    				{
    					try {
    						if(notSent)
    						{
							HeroDied();
							notSent = false;
    						}
						} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				}
    				
    				if(enemy.getHealth() <= 0)
    				{
    					try {
    						if(notSent)
    						{
    						EnemyDied();
    						notSent = false;
    						}
						} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				}
    				
    			}
    		}

    	});
	    
	      End.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			 End.setEnabled(false);
    			 use1.setEnabled(false);
    			 read1.setEnabled(false);
    			 use2.setEnabled(false);
    			 read2.setEnabled(false);
    			 use3.setEnabled(false);
    			 read3.setEnabled(false);
    		
    			 enemy.atStart();
    			 if(hero.getHealth() <= 0)
 				{
 					try {
 						if(notSent)
						{
						HeroDied();
						notSent = false;
						}
						} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
 				}
 				
 				if(enemy.getHealth() <= 0)
 				{
 					try {
 						if(notSent)
						{
						EnemyDied();
						notSent = false;
						}
						} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
 				}
    			 
    			 enemy.TakeAction(hero);
    			 if(hero.getHealth() <= 0)
 				{
 					try {
 						if(notSent)
						{
						HeroDied();
						notSent = false;
						}
							
						} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
 				}
 				
 				if(enemy.getHealth() <= 0)
 				{
 					try {
 						if(notSent)
						{
						EnemyDied();
						notSent = false;
						}
						} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
 				}
 				
    			 Deck.setText("Deck: "+ hero.getDeck().getDeck().size());
    			 
 				Discard.setText("Discarded: "+ hero.getDeck().getDiscard().size());
 				card1.setBackground(hero.getDeck().getHand().get(0).getColor());
 				card2.setBackground(hero.getDeck().getHand().get(1).getColor());
 				card3.setBackground(hero.getDeck().getHand().get(2).getColor());
 				healthEnemy.setText(enemy.getHealth() + "/" + enemy.getOHealth());
 				healthHero.setText(hero.getHealth() + "/" + hero.getHealthStat());
 				Energy.setText("Energy: "+ hero.getEnergy());
    			 
    			hero.atStart();
    			if(hero.getHealth() <= 0)
				{
					try {
						if(notSent)
						{
						HeroDied();
						notSent = false;
						}
						
					} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				if(enemy.getHealth() <= 0)
				{
					try {
						if(notSent)
						{
						EnemyDied();
						notSent = false;
						}
					} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
    			 End.setEnabled(true);
    			 use1.setEnabled(true);
    			 read1.setEnabled(true);
    			 use2.setEnabled(true);
    			 read2.setEnabled(true);
    			 use3.setEnabled(true);
    			 read3.setEnabled(true);
    			 Energy.setText("Energy: "+ hero.getEnergy());
    			 
    		}

    	});
	    
        
	    //regular stuff for frame
		this.setTitle("Card quest");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}
	
	public ImageIcon resizeIcon(ImageIcon icon, int width, int height)
	{
		
		Image image = icon.getImage();
	    Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
	    ImageIcon newImageIcon = new ImageIcon(newimg);
	    return newImageIcon;
	    
	    
	}
	
	    
	
	

	
	

	public void HeroDied() throws IOException, LineUnavailableException, UnsupportedAudioFileException
	{
		player.stop();
		this.dispose();
		new LevelSelect(true, enemy.getReward());
			
	}
	
	public void EnemyDied() throws IOException, LineUnavailableException, UnsupportedAudioFileException
	{
		
		player.stop();
		hero.gainReward(enemy.getReward());
		Stage.save(hero);
		this.dispose();
		new LevelSelect(false, enemy.getReward());
			
	}
	
	
	
	public Enemies getEnemy()
	{
		return enemy;
	}
	
	public Hero getHero()
	{
		return hero;
	}

	
}
