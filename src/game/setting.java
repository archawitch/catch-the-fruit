package Game;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import character.gameData;

public class setting extends JPanel implements KeyListener,MouseListener,MouseMotionListener{
	
	protected JRadioButton easy = new JRadioButton("easy");
	protected JRadioButton normal = new JRadioButton("normal");
	protected JRadioButton hard = new JRadioButton("hard");
	String fruitColorList[] = {"banana","apple","watermelon","grape","orange"};
	String userColorList[] = {"stone","flint","tiger","honey","rose","wine"};
	String backgroundColorList[] = {"city","ramen","sea","mountain"};
	JComboBox<String> fruitColor = new JComboBox<String>(fruitColorList);
	JComboBox<String> userColor = new JComboBox<String>(userColorList);
	JComboBox<String> backgroundColor = new JComboBox<String>(backgroundColorList);
	String setting = "SETTINGS";
	String mode = "MODE";
	String background = "BACKGROUND";
	String user = "USER";
	String fruit = "FRUIT";
	String exit = "PRESS SPACE BAR TO RETURN";
	String gameStart = "PRESS ENTER TO TRY AGAIN";
	Font font;
	Font font2;
	Font font3;
	FontMetrics metrics1;
	FontMetrics metrics2;
	FontMetrics metrics3;
	Color fontColor = Color.WHITE;
	JPanel p = new JPanel();
	Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
	static gameData u;
	String mSelected = "";
	String uSelected = "";
	String fSelected = "";
	String bSelected = "";
	
	Image i;
	
	public setting(gameData u) {
		
		this.u = u;
		
		createFont();
		System.out.println(u.userColor);
		checkUserData();
		System.out.println(uSelected);
		setBackground(Color.BLUE);
		this.setBounds(0, 0, 500, 500);
		this.setLayout(null);
		setSize(500,500);
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.u = u;
		
	}
	
	private void checkUserData() {
		Color Banana = new Color(255,204,0);
		Color Apple = new Color(192,0,0);
		Color Melon = new Color(0,98,66);
		Color Grape = new Color(142,36,63);
		Color Orange = new Color(255,127,39);
		Color Flint = new Color(107,104,147);
		Color Stone = new Color(154,168,199);
		Color Tiger = new Color(255,127,39);
		Color Honey = new Color(254,198,72);
		Color Wine = new Color(142,36,63);
		Color Rose = new Color(223,58,64);
		if(u.gameSpeed == 3)		mSelected = "Easy";
		if(u.gameSpeed == 5)		mSelected = "Normal";
		if(u.gameSpeed == 7)		mSelected = "Hard";
		if(u.fruitColor.equals(Banana))		fSelected = "Banana";
		if(u.fruitColor.equals(Apple))		fSelected = "Apple";
		if(u.fruitColor.equals(Melon))		fSelected = "Melon";
		if(u.fruitColor.equals(Grape))		fSelected = "Grape";
		if(u.fruitColor.equals(Orange))		fSelected = "Orange";
		if(u.userColor.equals(Flint))		uSelected = "Flint";
		if(u.userColor.equals(Stone))		uSelected = "Stone";
		if(u.userColor.equals(Tiger))		uSelected = "Tiger";
		if(u.userColor.equals(Honey))		uSelected = "Honey";
		if(u.userColor.equals(Wine))		uSelected = "Wine";
		if(u.userColor.equals(Rose))		uSelected = "Rose";
		if(u.background == new ImageIcon(this.getClass().getResource("/city.png")).getImage())			bSelected = "City";
		if(u.background == new ImageIcon(this.getClass().getResource("/ramen.png")).getImage())			bSelected = "Ramen";
		if(u.background == new ImageIcon(this.getClass().getResource("/sea.jpeg")).getImage())			bSelected = "Sea";
		if(u.background == new ImageIcon(this.getClass().getResource("/mountain.png")).getImage())		bSelected = "Mountain";
	}
	
	private void createFont() {
		try {
		    //create the font to use. Specify the size!
		   font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/DeterminationSansWebRegular-369X.ttf")).deriveFont(30f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(font);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		try {
		    //create the font to use. Specify the size!
		   font2 = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/DeterminationSansWebRegular-369X.ttf")).deriveFont(80f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(font2);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		try {
		    //create the font to use. Specify the size!
		   font3 = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/DeterminationSansWebRegular-369X.ttf")).deriveFont(15f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(font3);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(fontColor);
		g.setFont(font2);
		metrics1 = g.getFontMetrics(g.getFont());
		g.drawString(setting, (40 + metrics1.stringWidth(String.valueOf(setting)) - metrics1.stringWidth(String.valueOf(mode))), 165);
		g.setFont(font);
		metrics2 = g.getFontMetrics(g.getFont());
		g.drawString(mode, (40 + metrics2.stringWidth(String.valueOf(background)) - metrics2.stringWidth(String.valueOf(mode))), 280);
		g.drawString(user, (40 + metrics2.stringWidth(String.valueOf(background)) - metrics2.stringWidth(String.valueOf(user))), 330);
		g.drawString(fruit, (40 + metrics2.stringWidth(String.valueOf(background)) - metrics2.stringWidth(String.valueOf(fruit))), 380);
		g.drawString(background, 40, 430);
		g.setFont(font3);
		metrics3 = g.getFontMetrics(g.getFont());
		int a = 7;
		g.drawString(exit, (500 - metrics3.stringWidth(String.valueOf(exit)))-10, 15);
		g.drawString(gameStart, 10, 15);
		g.drawString("FLINT", 210 + a, 326);
		g.drawString("TIGER", 255 + a, 326);
		g.drawString("HONEY", 300 + a, 326);
		g.drawString("ROSE", 345 + a, 326);
		g.drawString("STONE", 390, 326);
		g.drawString("WINE", 435, 326);
		g.drawString("BANANA", 210, 376);
		g.drawString("APPLE", 310, 376);
		g.drawString("MELON", 425, 376);
		g.drawString("GRAPE", 260, 376);
		g.drawString("ORANGE", 360, 376);
		g.drawString("CITY", 230, 426);
		g.drawString("RAMEN", 285, 426);
		g.drawString("SEA", 350, 426);
		g.drawString("MOUNTAIN", 400, 426);
		g.drawString("EASY", 255-a, 276);
		g.drawString("NORMAL", 330-a, 276);
		g.drawString("HARD", 415-a, 276);
		if(!mSelected.isEmpty())	g.drawString("Mode: " + mSelected, 50, 225);
		if(!uSelected.isEmpty())	g.drawString("User: " + uSelected, 150, 225);
		if(!fSelected.isEmpty())	g.drawString("Fruit: " + fSelected, 250, 225);
		if(!bSelected.isEmpty())	g.drawString("Background: " + bSelected, 350, 225);
		
	}
	
	public void Return() {
		display.menu(u);
	}
	
	public void gameStart() {
		display.gameStart(u);
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 32) {
			Return();
		}
		if(e.getKeyCode() == 10) {
			gameStart();
		}
		if(e.getKeyCode() == 69) {
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e) {}
	
	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		System.out.println("pressed");
		if(e.getButton() == 3)	Return();
		if(e.getButton() == 1) {
			if(e.getY() >= 270 && e.getY() <= 280) {
				if(e.getX() >=  250 && e.getX() <= 275) {
					u.gameSpeed = 3;
					this.mSelected = "Easy";
				}
				if(e.getX() >=  320 && e.getX() <= 365) {
					u.gameSpeed = 5;
					this.mSelected = "Normal";
				}
				if(e.getX() >=  410 && e.getX() <= 435) {
					u.gameSpeed = 7;
					this.mSelected = "Hard";	
				}
	
			}
			if(e.getY() >= 320 && e.getY() <= 330) {
				if(e.getX() >=  217 && e.getX() <= 250) {
					u.userColor = new Color(107,104,147);
					this.uSelected = "Flint";
				}
				if(e.getX() >=  262 && e.getX() <= 295) {
					u.userColor = new Color(255,127,39);
					this.uSelected = "Tiger";
				}
				if(e.getX() >=  307 && e.getX() <= 340) {
					u.userColor = new Color(254,198,72);
					this.uSelected = "Honey";
				}
				if(e.getX() >=  351 && e.getX() <= 375) {
					u.userColor = new Color(223,58,64);
					this.uSelected = "Rose";
				}
				if(e.getX() >=  390 && e.getX() <= 422) {
					u.userColor = new Color(154,168,199);
					this.uSelected = "Stone";
				}
				if(e.getX() >=  435 && e.getX() <= 463) {
					u.userColor = new Color(142,36,63);
					this.uSelected = "Wine";
				}	
			}
			if(e.getY() >= 370 && e.getY() <= 380) {
				if(e.getX() >=  210 && e.getX() <= 250) {
					u.fruitColor = new Color(255,204,0);
					this.fSelected = "Banana";
				}
				if(e.getX() >=  260 && e.getX() <= 293) {
					u.fruitColor = new Color(142,36,63);
					this.fSelected = "Grape";
				}
				if(e.getX() >=  310 && e.getX() <= 343) {
					u.fruitColor = new Color(192,0,0);
					this.fSelected = "Apple";	
				}
				if(e.getX() >=  360 && e.getX() <= 400) {
					u.fruitColor = new Color(255,127,39);
					this.fSelected = "Orange";
				}
				if(e.getX() >=  425 && e.getX() <= 460) {
					u.fruitColor = new Color(0,98,66);
					this.fSelected = "Melon";
				}
			}
			if(e.getY() >= 420 && e.getY() <= 430) {
				if(e.getX() >=  230 && e.getX() <= 255) {
					u.background = new ImageIcon(this.getClass().getResource("/city.png")).getImage();
					this.bSelected = "City";
				}
				if(e.getX() >=  285 && e.getX() <= 320) {
					u.background = new ImageIcon(this.getClass().getResource("/ramen.png")).getImage();
					this.bSelected = "Ramen";
				}
				if(e.getX() >=  350 && e.getX() <= 370) {
					u.background = new ImageIcon(this.getClass().getResource("/sea.jpeg")).getImage();
					this.bSelected = "Sea";
				}
				if(e.getX() >=  400 && e.getX() <= 455) {
					u.background = new ImageIcon(this.getClass().getResource("/mountain.png")).getImage();
					this.bSelected = "Mountain";
				}
			}
			repaint();
		}
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {}
	
	public void mouseMoved(MouseEvent e) {
		if(e.getY() >= 270 && e.getY() <= 280) {
			if(e.getX() >=  250 && e.getX() <= 275) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  320 && e.getX() <= 365) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  410 && e.getX() <= 435) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		else if(e.getY() >= 320 && e.getY() <= 330) {
			if(e.getX() >=  217 && e.getX() <= 250) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  262 && e.getX() <= 295) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  307 && e.getX() <= 340) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  351 && e.getX() <= 375) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  390 && e.getX() <= 422) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  435 && e.getX() <= 463) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}	
			else	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		else if(e.getY() >= 370 && e.getY() <= 380) {
			if(e.getX() >=  210 && e.getX() <= 250) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  260 && e.getX() <= 293) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  310 && e.getX() <= 343) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  360 && e.getX() <= 400) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  425 && e.getX() <= 460) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		else if(e.getY() >= 420 && e.getY() <= 430) {
			if(e.getX() >=  230 && e.getX() <= 255) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  285 && e.getX() <= 320) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else if(e.getX() >=  350 && e.getX() <= 370) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));	
			}
			else if(e.getX() >=  400 && e.getX() <= 455) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		else	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			
	}
}