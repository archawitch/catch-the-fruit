
package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import character.gameData;
import character.*;

public class game extends JPanel implements ActionListener,KeyListener{
	
	double gameSpeed;
	public double moveX;
	public double moveLeft;
	public double moveRight;
	static int point = 0;
	boolean firstTime = true;
	boolean end = false;
	boolean drawHit = false;
	int backgroundBlack = 0;
	private Timer userTimer = new Timer (20,this);
	private Timer fruitTimer;
	private Timer hitTimer;
	double randx = Math.floor(Math.random()*450);
	user user;
	fruit fruit;
	private double defaultGameSpeed;
	private Color userColor;
	private Color fruitColor;
	private Color fontColor = Color.WHITE;
	static String userName;
	public static String highestScore[] = {"No recorded", "0"};
	gameData u;
	Font scoreFont;
	Font hitFont;
	Font playingFont;
	
	public game(gameData u1) {
		
		this.u = u1;
		createFont();
		checkGameSpeed();
		checkUserName();
		setSizeAndLocation();
		this.setBounds(0, 0, 500, 500);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setLayout(null);
		addKeyListener(this);
		this.setBackground(Color.BLACK);
		fruitColor = u.fruitColor;
		userColor = u.userColor;
		fruitMove();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Image img = new ImageIcon(this.getClass().getResource("/city.png")).getImage();
		if(backgroundBlack % 4 == 0)	g.drawImage(u.background, 0, 0, this);
		g.setColor(fruitColor);
		//fruitPaint(g);
		//userPaint(g);
		Image chadchart = new ImageIcon(this.getClass().getResource("/chadchart.png")).getImage();
		g.drawImage(chadchart, user.x, user.y-100, this);
		Image banana = new ImageIcon(this.getClass().getResource("/banana.png")).getImage();
		g.drawImage(banana, fruit.x, fruit.y-90, this);
		g.setColor(fontColor);
		g.setFont(scoreFont);
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		g.drawString(String.valueOf(point), (getWidth() - metrics.stringWidth(String.valueOf(point))) - 15, 45);
		if(drawHit)	{
			g.setFont(hitFont);
			FontMetrics metrics1 = g.getFontMetrics(g.getFont());
			g.drawString("catch!", (getWidth() - metrics1.stringWidth(String.valueOf("catch!")))/2, 460);
		}
		if(point < 1) {
			g.setFont(hitFont);
			FontMetrics metrics2 = g.getFontMetrics(g.getFont());
			g.drawString("Press A or D button to move...", (getWidth() - metrics2.stringWidth("Press A or S button to move..."))/2, 460);
		}
		textPaint(g);
	}
	
	private void userPaint(Graphics g) {
		g.setColor(userColor);
		point pUser = (point) user;
		g.fillRect(pUser.x,pUser.y-user.h,(user.w/4),user.h);
		g.fillRect(pUser.x+(3*(user.w/4)),pUser.y-user.h,(user.w/4),user.h);
		g.fillRect(pUser.x,pUser.y,user.w,user.h);
		g.fillRect(pUser.x+(user.w/4)+2,pUser.y,(user.w/4)-4,user.h);
		g.fillRect(pUser.x+(2*(user.w/4))+2,pUser.y,(user.w/4)-4,user.h);
		g.fillRect(pUser.x+(3*(user.w/4))+2,pUser.y,(user.w/4)-2,user.h);
		g.setColor(Color.BLACK);
		g.drawLine(pUser.x, pUser.y+user.h, pUser.x+user.w, pUser.y+user.h);
		g.drawLine(pUser.x, pUser.y-user.h, pUser.x, pUser.y+user.h);
		g.drawLine(pUser.x+user.w, pUser.y-user.h, pUser.x+user.w, pUser.y+user.h);
		g.drawLine(pUser.x, pUser.y-user.h, pUser.x+(user.w/4), pUser.y-user.h);
		g.drawLine(pUser.x+user.w, pUser.y-user.h, pUser.x+(3*(user.w/4)), pUser.y-user.h);
		g.drawLine(pUser.x+(user.w/4), pUser.y-user.h, pUser.x+(user.w/4), pUser.y);
		g.drawLine(pUser.x+(3*(user.w/4)), pUser.y-user.h, pUser.x+(3*(user.w/4)), pUser.y);
		g.drawLine(pUser.x+(user.w/4), pUser.y, pUser.x+(3*(user.w/4)), pUser.y);
	}
	
	private void fruitPaint(Graphics g) {
		point pFruit = (point) fruit;
		g.fillOval(pFruit.x, pFruit.y,fruit.radius,fruit.radius);
		g.setColor(Color.BLACK);
		g.drawOval(pFruit.x, pFruit.y,fruit.radius,fruit.radius);
	}
	
	private void textPaint(Graphics g) {
		if(point <= 10) {
			g.setFont(playingFont);
			g.drawString(u.name + " is playing...", 10, 15);
		}
		else if(point <= 20) {
			g.setFont(playingFont);
			g.drawString("so chill...", 10, 15);
		}
		else if(point <= 30) {
			g.setFont(playingFont);
			g.drawString("Okay...", 10, 15);
		}
		else if(point <= 40) {
			g.setFont(playingFont);
			g.drawString("Amazing mate...", 10, 15);
		}
		else if(point <= 50) {
			g.setFont(playingFont);
			g.drawString("Yeahhh...", 10, 15);
		}
		else if(point <= 60) {
			g.setFont(playingFont);
			g.drawString("Yeahhh...", 10, 15);
		}
		else if(point <= 70) {
			g.setFont(playingFont);
			g.drawString("Hard..?", 10, 15);
		}
		else if(point <= 80) {
			g.setFont(playingFont);
			g.drawString("WOWWWWW...", 10, 15);
		}
		else if(point <= 90) {
			g.setFont(playingFont);
			g.drawString("MORE MORE MORE...", 10, 15);
		}
		else {
			g.setFont(playingFont);
			g.drawString("GOD...", 10, 15);
		}
	}
	
	private void createFont() {
		try {
		    //create the font to use. Specify the size!
		   scoreFont = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/DeterminationSansWebRegular-369X.ttf")).deriveFont(50f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(scoreFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		try {
		    //create the font to use. Specify the size!
		   hitFont = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/DeterminationSansWebRegular-369X.ttf")).deriveFont(22f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(hitFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		try {
		    //create the font to use. Specify the size!
		   playingFont = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/DeterminationSansWebRegular-369X.ttf")).deriveFont(15f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(playingFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
	}
	private void setSizeAndLocation() {
		if(u.gameSpeed == 3) {
			user = new user(200,420,100,22);
			fruit = new fruitData((int)randx,-50, 30,gameSpeed);
		}
		if(u.gameSpeed == 5) {
			user = new user(210,420,80,18);
			fruit = new fruitData((int)randx,-50, 25,gameSpeed);
		}
		if(u.gameSpeed == 7) {
			user = new user(220,420,60,14);
			fruit = new fruitData((int)randx,-50, 20,gameSpeed);
		}
		
	}
	
	private void checkUserName() {
		if(u.name.isEmpty())	u.name = "Anonymous";
		if(u.name.equals("chadchart")){
			highestScore[0] = "chadchart";
			highestScore[1] = "9999";
			point = 9999;
		}
	}
	
	private void checkGameSpeed() {
		if(u.gameSpeed == 3)	{
			gameSpeed = defaultGameSpeed = 3;
			moveLeft = -3;
			moveRight = 3;
		}
		if(u.gameSpeed == 5)	{
			gameSpeed = defaultGameSpeed = 5;
			moveLeft = -4;
			moveRight = 4;
		}
		if(u.gameSpeed == 7)	{
			gameSpeed = defaultGameSpeed = 7;
			moveLeft = -7;
			moveRight = 7;
		}
	}
	
	private void fruitMove() {
		fruitTimer = new Timer(20, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(checkHit()) {
					Hit();
					System.out.println("hit " + fruit.x + " " + user.x);
					double randx = Math.floor(Math.random()*450);
					fruit.x = (int) randx;
					fruit.y = fruit.startY;
					if(point < 9999)	point++;
					speedUp();
				}
				else if(fruit.y > 500) {
					fruitTimer.stop();
					System.out.println("end");
					highestScore(point, u.name);
					display.menu(u);
				}
				fruit.y += gameSpeed;
				repaint();
			}
		});
		fruitTimer.start();
	}
	
	public void highestScore(int score, String name) {
		int top = Integer.parseInt(highestScore[1]);
		if(score >= top) {
			highestScore[0] = name;
			highestScore[1] = String.valueOf(score);
		}	
	}
	
	public void Hit() {
		userColor = u.fruitColor;
		drawHit = true;
		hitTimer = new Timer(250, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userColor = u.userColor;
				drawHit = false;
			}
		}); 
		hitTimer.setRepeats(false);
		hitTimer.start();
	}
	
	public boolean checkHit() {
		if(fruit.x <= user.x + user.w && fruit.x + fruit.radius >= user.x && fruit.y + fruit.radius >= user.y && fruit.y <= user.y + user.h)
			return true;
		else	return false;
	}
	
	public void speedUp() {
		if(defaultGameSpeed == 3 && gameSpeed < 10) {
			gameSpeed += 0.3;
			if(moveRight < 10) {
				moveLeft -= 0.3;
				moveRight += 0.3;
			}
		}
		if(defaultGameSpeed == 5 && gameSpeed < 15) {
			gameSpeed += 0.4;
			if(moveRight < 15) {
				moveLeft -= 0.5;
				moveRight += 0.5;
			}
		}
		if(defaultGameSpeed == 7 && gameSpeed < 20) {
			gameSpeed += 0.5;
			if(moveRight < 20) {
				moveLeft -= 0.7;
				moveRight += 0.7;
			}
		}
		System.out.println(moveRight);
		System.out.println(gameSpeed);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(user.x < 0)		user.x = 0;
		if(user.x > 500-user.w)	user.x = 500-user.w;
		user.x += moveX;
		repaint();
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == 32) {
			backgroundBlack++;
		}
		if(e.getKeyCode() == 65) {
			userTimer.start();
			if(firstTime) {
				moveX = moveLeft;
				firstTime = false;
			}
			else{
				moveX = 1.04*moveX;
			}
		}
		if(e.getKeyCode() == 65) {
			userTimer.start();
			if(firstTime) {
				moveX = moveLeft;
				firstTime = false;
			}
			else{
				moveX = 1.04*moveX;
			}
		}
		if(e.getKeyCode() == 69) {
			System.exit(0);
		}
		else if(e.getKeyCode() == 68) {
			userTimer.start();
			if(firstTime) {
				moveX = moveRight;
				firstTime = false;
			}
			else{
				moveX = 1.04*moveX;
			}
		}
		else if(e.getKeyCode() == 27) {
			fruitTimer.stop();
			System.out.println("end");
			highestScore(point, u.name);
			display.menu(u);
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 65 || e.getKeyCode() == 68) {
			userTimer.stop();
			moveX = 0;
			firstTime = true;
		}
	}
	
}
	
	

