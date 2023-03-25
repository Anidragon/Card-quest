import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class LevelSelect extends JFrame
{
	private Hero hero;
    private boolean firstTime = false;
    private AudioPlayer player;
    private static File file = new File("SaveFile.txt"); 
    
    //secondary constructor to display win/loss messages
    public LevelSelect(boolean boom, int r) throws IOException, UnsupportedAudioFileException, LineUnavailableException
    {
    	new LevelSelect();
    	
    	if(boom)
    	{
    		this.lossMsg();
    	}
    	
    	if(!boom)
    	{
    		this.WinMsg(r);
    	}
    }
    
    //regular level select constructor for opening the level select frame
	public LevelSelect() throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		
		player = new AudioPlayer("Now-We-Ride.wav", false);
		player.play();
		 
		FileNotFoundException FileNotFound = new FileNotFoundException();
		
		try
		{
			 boolean exists = file.exists();
			 if(!exists)
			 {
			 //if it's your first time opening the game, it asks for your name and records it 
				 String name = JOptionPane.showInputDialog(null, "What is your name? no spaces or /", "", JOptionPane.QUESTION_MESSAGE);
				 if(name.equals(null) || name.equals("") || name.contains(" ") || name.contains("/"))
					System.exit(0);
				 
				 hero = new Hero(name, 5, 20, 0);
				 hero.getDeck().getDeck().add(new AttackCard());
				 hero.getDeck().getDeck().add(new AttackCard());
				 hero.getDeck().getDeck().add(new AttackCard());
				 hero.getDeck().getDeck().add(new ShieldCard());
				 hero.getDeck().getDeck().add(new ShieldCard());
				 hero.getDeck().getDeck().add(new ShieldCard());
				 firstTime = true;
				 throw FileNotFound ; 
			 }
		}
		
		
		catch(Exception FileNotFoundException)
		{
		//creates a save file
			file.createNewFile();
			PrintWriter writer = new PrintWriter(file);
			try
			{
			writer.print(hero.getName() + "/" + hero.getHealthStat() + "/" + hero.getOAttack() + "/" + hero.getGold() + "/");
			}
			catch(Exception e)
			{
				System.exit(0);
			}
			 
			for(int i = hero.getFullDeckList().size() - 1 ; i >= 0 ; i--)
			{
		
				writer.print(hero.getFullDeckList().get(i).getName() + "/");
		
			}
				writer.close();

		}
		
		 
		
	if(!firstTime)
	{
		try
		{
		ArrayList<String> txt = new ArrayList<String>();
		txt = this.txtToList(file);
		String[] split = txt.get(0).split("/");
		hero = new Hero(split[0], Integer.parseInt(split[2]), Integer.parseInt(split[1]),Integer.parseInt(split[3]));
		for(int i = 4; i < split.length ; i++)
		{
			if(split[i].equals("Attack"))
			{
				hero.getDeck().getDeck().add(new AttackCard());
			}
			
			else if(split[i].equals("Shield"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			
			else if(split[i].equals("Armor"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			else if(split[i].equals("Ultimate Combo"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			else if(split[i].equals("Triple Strike"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			
			else if(split[i].equals("Spadille"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			else if(split[i].equals("Shield Sweeper"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			
			else if(split[i].equals("Sketchy Medicine"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			else if(split[i].equals("Shield Gambler"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			
			else if(split[i].equals("Risky Play"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			else if(split[i].equals("Poison Strike"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			
			else if(split[i].equals("Momentum"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			else if(split[i].equals("Meditation"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			
			else if(split[i].equals("Health Gambler"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			else if(split[i].equals("Foggy Heal"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			
			else if(split[i].equals("Flurry"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			else if(split[i].equals("Final Breath"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			
			else if(split[i].equals("Energy Gambler"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			else if(split[i].equals("Double Strike"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			
			else if(split[i].equals("Critical Hit"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			else if(split[i].equals("Chug Jug"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
			
			else if(split[i].equals("Attack Gambler"))
			{
				hero.getDeck().getDeck().add(new ShieldCard());
			}
		
			
		}
		}
		
		catch(Exception e)
		{
			file.delete();
			dispose();
			new LevelSelect();
		}
	}
	

	 	//instantiates JFrame
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setLayout(new GridLayout(4, 4));
		GridBagConstraints gbc = new GridBagConstraints();
		ImageIcon fields = new ImageIcon("1.jpg");
		ImageIcon caves = new ImageIcon("2.jpg");
		ImageIcon forest = new ImageIcon("3.jpg");
		ImageIcon desert = new ImageIcon("4.jpg");
		ImageIcon beach =  new ImageIcon("5.jpg");
		ImageIcon island = new ImageIcon("6.jpg");
		ImageIcon canyon = new ImageIcon("7.jpg");
		ImageIcon mountain = new ImageIcon("8.jpg");
		ImageIcon frost = new ImageIcon("9.jpg");
		ImageIcon volc = new ImageIcon("10.jpg");
		
		//instantiates menu bar and options 
		 JMenuBar menuBar = new JMenuBar();
	        JMenu Options = new JMenu("Options");
	        JMenuItem Save = new JMenuItem("Save");
	        JMenuItem Shop = new JMenuItem("Shop");
	        JMenuItem Stats = new JMenuItem("Stats");
	        JMenuItem Close = new JMenuItem("Close");
	        JMenuItem Restart = new JMenuItem("Restart Game");
	        Options.add(Shop);
	        Options.add(Stats);
	        Options.add(Close);
	        Options.add(Restart);
	        menuBar.add(Options);
	        
	        Stats.addActionListener(new ActionListener()
	    	{
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			JOptionPane.showMessageDialog(null, "Attack: " + hero.getAttackStat() + "\n" + "Health: " + hero.getHealthStat() + "\n" + "Gold: " + hero.getGold());
	    			
	    		}

	    	});
	        
	       
	        Close.addActionListener(new ActionListener()
	       	{
	       		public void actionPerformed(ActionEvent e)
	       		{
	       			System.exit(0);
	       			try {
						player.stop();
					} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	       		}

	       	});
	        
	        Shop.addActionListener(new ActionListener()
	    	{
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			int confirm = JOptionPane.showConfirmDialog(null, "are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
	    			
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
	        
	        Restart.addActionListener(new ActionListener()
	    	{
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			int confirm = JOptionPane.showConfirmDialog(null, "are you sure you want to delete all of your progress?", "Confirm", JOptionPane.YES_NO_OPTION);
	    			
	    			if(confirm == 0)
	    			{
	    				dispose();
	    				try {
							player.stop();
						} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	    				file.delete();
	    				try {
							new LevelSelect();
						} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	    				
	    			}
	    		}

	    	});
	        
	        
	        
	        this.setJMenuBar(menuBar);
		
		//creating and setting the locations of buttons
		JButton level1 = new JButton("Level 1", fields);
		level1.setRolloverIcon(fields);
	
	    JButton level2 = new JButton("", caves);
	    level2.setRolloverIcon(caves);
		
	    JButton level3 = new JButton("", forest);
	    level3.setRolloverIcon(forest);
	    
	    JButton level4 = new JButton("", desert);
	    level4.setRolloverIcon(desert);
	    
	    JButton level5 = new JButton("", beach);
	    level5.setRolloverIcon(beach);
	    
	    JButton level6 = new JButton("", island);
	    level6.setRolloverIcon(island);
	    
	    JButton level7 = new JButton("", canyon);
	    level7.setRolloverIcon(canyon);
	    
	    JButton level8 = new JButton("", mountain);
	    level8.setRolloverIcon(mountain);
	    
	    JButton level9 = new JButton("", frost);
	    level9.setRolloverIcon(frost);
	    
	    JButton Spacer = new JButton("");
	    Spacer.setEnabled(false);
	    
	    JButton level10 = new JButton("", volc);
	    level10.setRolloverIcon(volc);
	    
	    JButton Spacer2 = new JButton("");
	    Spacer2.setEnabled(false);
	  
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    this.add(level1, gbc);
	    gbc.gridx = 1;
	   
	    gbc.gridx = 2;
	    this.add(level2, gbc);
	    gbc.gridx = 3;
	   
	    gbc.gridx = 4;
	    this.add(level3, gbc);
	    gbc.gridx = 5;
	   
	    gbc.gridx = 6;
	    this.add(level4, gbc);
	    gbc.gridx = 7;
	
	    gbc.gridx = 8;
	    this.add(level5, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    this.add(level6, gbc);
	    gbc.gridx = 1;
	 
	    gbc.gridx = 2;
	    this.add(level7, gbc);
	    gbc.gridx = 3;

	    gbc.gridx = 4;
	    this.add(level8, gbc);
	    gbc.gridx = 5;
	
	    gbc.gridx = 6;
	    this.add(level9, gbc);
	    gbc.gridx = 7;
	 
	    this.add(Spacer);
	    
	    gbc.gridx = 8;
	    this.add(level10, gbc);
	   
	    this.add(Spacer2);
	    
	    
	    //when level buttons are clicked, activate a game file with the proper level
	    level1.addActionListener(new ActionListener()
    	{
	    	
    		public void actionPerformed(ActionEvent e)
    		{
    			
    			 try {
					try {
						new Stage(1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose(); 
					player.stop();
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			 
    		}

    	});
	    
	    level2.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			 try {
					try {
						new Stage(2);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					player.stop();
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			 
    		}

    	});
	    
	    level3.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			 try {
					try {
						new Stage(3);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					player.stop();
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			 
    		}

    	});
	    
	    level4.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			 try {
					try {
						new Stage(4);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					player.stop();
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			 
    		}

    	});
	    
	    level5.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			 try {
					try {
						new Stage(5);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					player.stop();
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			 
    		}

    	});
	    
	    level6.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			 try {
					try {
						new Stage(6);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					player.stop();
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			 
    		}

    	});
	    level7.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			 try {
					try {
						new Stage(7);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					player.stop();
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			 
    		}

    	}); 
	    
	    level8.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			 try {
					try {
						new Stage(8);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					player.stop();
					dispose();
					
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			 
    		}

    	});
    	
    	 level9.addActionListener(new ActionListener()
     	{
     		public void actionPerformed(ActionEvent e)
     		{
     			 try {
 					try {
						new Stage(9);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 					player.stop();
 					dispose();
 					
 				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 				}
     			 
     		}

     	});
	    
    	 level10.addActionListener(new ActionListener()
     	{
     		public void actionPerformed(ActionEvent e)
     		{
     			 try {
 					try {
						new Stage(10);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 					player.stop();
 					dispose();
 					
 				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 				}
     			 
     		}

     	});
	    
	    this.setTitle("Level Select");
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	    
		
	}
	
	//saves hero's stats after opening level select
	public ArrayList<String> txtToList(File fileparam) throws IOException
	{
		ArrayList<String> storage = new ArrayList<String>();
		Scanner s = new Scanner(fileparam);
		while (s.hasNextLine())
		{
			
			try
			{
				storage.add(s.next());
			}
			catch(Exception e) {}
			
		}
		s.close();
		return storage;
	}

	public void lossMsg()
	{
		JOptionPane.showMessageDialog(null, "you lost!, try upgrading at the shop and try again ", "Lost", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void WinMsg(int reward)
	{
		JOptionPane.showMessageDialog(null, "you Won! you gained " + reward + " Gold, use it in the shop for new cards and upgrades", "Won", JOptionPane.PLAIN_MESSAGE); 
	}
	
	
}
