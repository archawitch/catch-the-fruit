package Game;

import java.awt.*;
import javax.swing.*;

import character.gameData;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class startMenu extends JPanel implements ActionListener,ItemListener,KeyListener,MouseListener,MouseMotionListener,FocusListener{
	
	String fruitColorList[] = {"banana","apple","watermelon","grape","orange"};
	String userColorList[] = {"stone","flint","tiger","honey","rose","wine"};
	String backgroundColorList[] = {"city","ramen","sea","mountain"};
	JComboBox<String> fruitColor = new JComboBox<String>(fruitColorList);
	JComboBox<String> userColor = new JComboBox<String>(userColorList);
	JComboBox<String> backgroundColor = new JComboBox<String>(backgroundColorList);
	JLabel showFruit = new JLabel("  Fruit : ");
	JLabel showUser = new JLabel("  User : ");
	JLabel showBackground = new JLabel("   Background : ");
	JLabel yourName = new JLabel("    Enter your name : ");
	JTextField name = new JTextField(13);
	JButton gameStart = new JButton("Start");
	JLabel scoreText = new JLabel("Top Scorer");
	String topScorer = game.highestScore[0]+ " : ";
	JLabel topScore = new JLabel("Top Scorer  |  " + game.highestScore[0]+ " : " + game.highestScore[1]);
	JLabel gameMode = new JLabel("    Mode :");
	JRadioButton easy = new JRadioButton("easy");
	JRadioButton normal = new JRadioButton("normal");
	JRadioButton hard = new JRadioButton("hard   ");
	JPanel modeSelectedPanel = new JPanel();
	JPanel modePanel = new JPanel();
	JPanel namePanel = new JPanel();
	JPanel firstPanel = new JPanel();
	JPanel lastPanel = new JPanel();
	JPanel startPanel = new JPanel();
	JPanel fruitPanel = new JPanel();
	JPanel userPanel = new JPanel();
	JPanel backgroundPanel = new JPanel();
	JPanel selectedPanel = new JPanel();
	JPanel gameSpeedPanel = new JPanel();
	JPanel topScorePanel = new JPanel();
	JPanel mainPanel = new JPanel();
	
	String userName;
	Color uColor;
	Color fColor;
	Color bColor = Color.BLACK;
	Image background = new ImageIcon(this.getClass().getResource("/city.png")).getImage();;
	private double gameSpeed = 5;
	Font pxFont1;
	Font pxFont11;
	Font pxFont2;
	FontMetrics metrics;
	Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
	gameData u;
	String mSelected = "";
	String uSelected = "";
	String fSelected = "";
	String bSelected = "";
	
	startMenu(gameData u){
		
		this.u = u;
		
		checkUserData();
		createFont();
		
		this.setBounds(0, 0, 500, 500);
		modeSelectedPanel.setLayout(new GridLayout(1,3));
		modeSelectedPanel.add(easy);
		modeSelectedPanel.add(normal);
		modeSelectedPanel.add(hard);
		modePanel.setLayout(new BorderLayout());
		modePanel.add(gameMode, BorderLayout.WEST);
		modePanel.add(modeSelectedPanel, BorderLayout.CENTER);
		easy.setForeground(Color.WHITE);
		easy.setFont(pxFont2);
		normal.setForeground(Color.WHITE);
		normal.setFont(pxFont2);
		hard.setForeground(Color.WHITE);
		hard.setFont(pxFont2);
		gameMode.setForeground(Color.WHITE);
		gameMode.setFont(pxFont2);
		gameMode.setHorizontalAlignment(SwingConstants.CENTER);
		hard.setSelected(false);
		normal.setSelected(true);
		hard.setSelected(false);
		easy.setCursor(handCursor);
		normal.setCursor(handCursor);
		hard.setCursor(handCursor);
		
		namePanel.setLayout(new BorderLayout());
		namePanel.add(yourName, BorderLayout.WEST);
		yourName.setForeground(Color.WHITE);
		yourName.setFont(pxFont2);
		yourName.setHorizontalAlignment(SwingConstants.RIGHT);
		namePanel.add(name, BorderLayout.CENTER);
		name.setFont(pxFont2);
		
		firstPanel.setLayout(new BorderLayout());
		firstPanel.add(namePanel,BorderLayout.WEST);
		firstPanel.add(modePanel);

		fruitPanel.setLayout(new BorderLayout());
		fruitPanel.add(showFruit, BorderLayout.WEST);
		showFruit.setForeground(Color.WHITE);
		showFruit.setFont(pxFont2);
		fruitColor.setFont(pxFont2);
		fruitPanel.add(fruitColor);
		showFruit.setHorizontalAlignment(SwingConstants.CENTER);
		fruitColor.setCursor(handCursor);
		
		backgroundPanel.setLayout(new BorderLayout());
		backgroundPanel.add(showBackground, BorderLayout.WEST);
		showBackground.setForeground(Color.WHITE);
		showBackground.setFont(pxFont2);
		backgroundColor.setFont(pxFont2);
		backgroundPanel.add(backgroundColor);
		showBackground.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundColor.setCursor(handCursor);

		userPanel.setLayout(new BorderLayout());
		userPanel.add(showUser, BorderLayout.WEST);
		showUser.setForeground(Color.WHITE);
		showUser.setFont(pxFont2);
		userColor.setFont(pxFont2);
		userPanel.add(userColor);
		showUser.setHorizontalAlignment(SwingConstants.CENTER);
		userColor.setCursor(handCursor);

		selectedPanel.setLayout(new FlowLayout());
		selectedPanel.add(backgroundPanel);
		selectedPanel.add(userPanel);
		selectedPanel.add(fruitPanel);
		
		topScore.setForeground(Color.WHITE);
		topScore.setFont(pxFont2);
		lastPanel.setLayout(new BorderLayout());
		lastPanel.add(topScore);
		topScore.setHorizontalAlignment(SwingConstants.CENTER);


		modeSelectedPanel.setBackground(Color.BLACK);
		firstPanel.setBackground(Color.BLACK);
		namePanel.setBackground(Color.BLACK);
		userPanel.setBackground(Color.BLACK);
		backgroundPanel.setBackground(Color.BLACK);
		fruitPanel.setBackground(Color.BLACK);
		selectedPanel.setBackground(Color.BLACK);
		lastPanel.setBackground(Color.BLACK);
		modePanel.setBackground(Color.BLACK);

		mainPanel.setLayout(new GridLayout(3,1));
		mainPanel.add(lastPanel);
		mainPanel.add(firstPanel);
		mainPanel.add(selectedPanel);
		mainPanel.setLocation(0, 370);
		mainPanel.setSize(500,90);
		setLayout(null);
		setBackground(Color.BLACK);
		add(mainPanel);
		name.addActionListener(this);
		userColor.addItemListener(this);
		fruitColor.addItemListener(this);
		backgroundColor.addItemListener(this);
		easy.addItemListener(this);
		normal.addItemListener(this);
		hard.addItemListener(this);
		name.addFocusListener(this);
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		checkUserData();
		
	}
	
	private void createFont() {
		try {
		    //create the font to use. Specify the size!
		    pxFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/DeterminationSansWebRegular-369X.ttf")).deriveFont(22f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(pxFont1);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		try {
		    //create the font to use. Specify the size!
		    pxFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/EightBitDragon-anqx.ttf")).deriveFont(9.5f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(pxFont2);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		Image img = new ImageIcon(this.getClass().getResource("/background-4.png")).getImage();
//		g.drawImage(img, 0, 0, this);
//		Image background = new ImageIcon(this.getClass().getResource("/fruitsBackground.png")).getImage();
//		g.drawImage(background, -3, 0, this);
		Image img = new ImageIcon(this.getClass().getResource("/title.png")).getImage();
		g.drawImage(img, 50, 145, this);
		g.setColor(Color.WHITE);
		g.setFont(pxFont1);
		metrics = g.getFontMetrics(g.getFont());
		g.drawString("PRESS SPACE BAR OR CLICK TO BEGIN", (500 - metrics.stringWidth(String.valueOf("PRESS SPACE BAR OR CLICK TO BEGIN")))/2, 230);
	}
	
	private void checkUserData() {
		if(!u.name.isEmpty()) {
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
			if(u.gameSpeed == 3){
				easy.setSelected(true);	normal.setSelected(false);		hard.setSelected(false);
			}
			if(u.gameSpeed == 5){
				normal.setSelected(true);	easy.setSelected(false);		hard.setSelected(false);
			}
			if(u.gameSpeed == 7){
				hard.setSelected(true);	easy.setSelected(false);	normal.setSelected(false);
			}
			if(u.fruitColor.equals(Banana))		fSelected = "banana";
			if(u.fruitColor.equals(Apple))		fSelected = "apple";
			if(u.fruitColor.equals(Melon))		fSelected = "melon";
			if(u.fruitColor.equals(Grape))		fSelected = "grape";
			if(u.fruitColor.equals(Orange))		fSelected = "orange";
			if(u.userColor.equals(Flint))		uSelected = "flint";
			if(u.userColor.equals(Stone))		uSelected = "stone";
			if(u.userColor.equals(Tiger))		uSelected = "tiger";
			if(u.userColor.equals(Honey))		uSelected = "honey";
			if(u.userColor.equals(Wine))		uSelected = "wine";
			if(u.userColor.equals(Rose))		uSelected = "rose";
			if(u.background == new ImageIcon(this.getClass().getResource("/city.png")).getImage())			bSelected = "city";
			if(u.background == new ImageIcon(this.getClass().getResource("/ramen.png")).getImage())			bSelected = "ramen";
			if(u.background == new ImageIcon(this.getClass().getResource("/sea.jpeg")).getImage())			bSelected = "sea";
			if(u.background == new ImageIcon(this.getClass().getResource("/mountain.png")).getImage())		bSelected = "mountain";
			setSelected();
		}
		else {
			u.userColor = new Color(154,168,199);
			u.fruitColor = new Color(255,204,0);
			u.background = new ImageIcon(this.getClass().getResource("/city.png")).getImage();
			easy.setSelected(false);
			normal.setSelected(true);
			hard.setSelected(false);
			name.setText("Anonymous");
			name.setForeground(Color.LIGHT_GRAY);
		}
	}
	
	void setSelected() {
		name.setText(u.name);
		name.setForeground(Color.LIGHT_GRAY);
		userColor.setSelectedItem(uSelected);
		fruitColor.setSelectedItem(fSelected);
		backgroundColor.setSelectedItem(bSelected);
	}
	
	public void gameStart() {
		System.out.println(name.getText());
		System.out.println(uColor);
		System.out.println(fColor);
		System.out.println(background);
		System.out.println(gameSpeed);
		System.out.println(u.userColor);
		display.gameStart(u);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == gameStart) {
			gameStart();
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == userColor) {
			if(userColor.getSelectedItem() == "flint") {
				u.userColor = new Color(107,104,147);
			}
			if(userColor.getSelectedItem() == "stone") {
				u.userColor = new Color(154,168,199);
			}
			if(userColor.getSelectedItem() == "tiger") {
				u.userColor = new Color(255,127,39);
			}
			if(userColor.getSelectedItem() == "honey") {
				u.userColor = new Color(254,198,72);
			}
			if(userColor.getSelectedItem() == "wine") {
				u.userColor = new Color(142,36,63);
			}
			if(userColor.getSelectedItem() == "rose") {
				u.userColor = new Color(223,58,64);
			}
			System.out.println("user's color changed to " + uColor);
		}
		if(e.getSource() == fruitColor) {
			if(fruitColor.getSelectedItem() == "banana") {
				u.fruitColor = new Color(255,204,0);
			}
			if(fruitColor.getSelectedItem().equals("apple")) {
				u.fruitColor = new Color(192,0,0);
			}
			if(fruitColor.getSelectedItem() == "watermelon") {
				u.fruitColor = new Color(0,98,66);
			}
			if(fruitColor.getSelectedItem().equals("grape")) {
				u.fruitColor = new Color(142,36,63);
			}
			if(fruitColor.getSelectedItem() == "orange") {
				u.fruitColor = new Color(255,127,39);
			}
			System.out.println("fruit's color changed to " + fColor);
		}
		if(e.getSource() == backgroundColor) {
			if(backgroundColor.getSelectedItem() == "city") {
				u.background = new ImageIcon(this.getClass().getResource("/city.png")).getImage();
			}
			if(backgroundColor.getSelectedItem() == "ramen") {
				u.background = new ImageIcon(this.getClass().getResource("/ramen.png")).getImage();
			}
			if(backgroundColor.getSelectedItem() == "sea") {
				u.background = new ImageIcon(this.getClass().getResource("/sea.jpeg")).getImage();
			}
			if(backgroundColor.getSelectedItem() == "mountain") {
				u.background = new ImageIcon(this.getClass().getResource("/mountain.png")).getImage();
			}
			System.out.println("background's color changed to " + backgroundColor.getSelectedItem());
		}
		if(e.getSource() == easy & e.getStateChange() == 1) {
			u.gameSpeed = 3;
			easy.setSelected(true);
			normal.setSelected(false);
			hard.setSelected(false);
		}
		if(e.getSource() == normal & e.getStateChange() == 1) {
			u.gameSpeed = 5;
			easy.setSelected(false);
			normal.setSelected(true);
			hard.setSelected(false);
		}
		if(e.getSource() == hard && e.getStateChange() == 1) {
			u.gameSpeed = 7;
			easy.setSelected(false);
			normal.setSelected(false);
			hard.setSelected(true);
		}
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 32) {
			u.name = name.getText();
			gameStart();
		}
		if(e.getKeyCode() == 69) {
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e) {}

	public void mouseClicked(MouseEvent e) {
		if(e.getY() < 365)	{
			u.name = name.getText();
			gameStart();
		}	
		if ((e.getSource().equals(name))) {
			name.setText("");
			name.setForeground(Color.black);
		}
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {
		if(e.getY() < 365)
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		else if(e.getY() >= 400 && e.getY() <= 430 && e.getX() >= 112 && e.getX() <= 227)	{
//			name.setText("");
//			name.setForeground(Color.black);
		}
		else {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}

	public void focusGained(FocusEvent e) {
		name.setText("");
		name.setForeground(Color.black);
	}

	public void focusLost(FocusEvent e) {}
	
}
