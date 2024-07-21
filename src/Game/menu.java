package Game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import character.gameData;

public class menu extends JPanel implements MouseListener,MouseMotionListener,KeyListener{
	
	Color restartColor = Color.RED;
	FontMetrics metrics;
	String lose = "You lose!";
	String tryAgain = "Try again";
	String mainMenu = "Main menu";
	String yourScore = "Your score was " + game.point + ".";
	String topScore = "Top score is " + game.highestScore[1] + ".";
	Font scoreFont;
	Font restartFont;
	Font settingFont;
	Cursor defaultCursor;
	gameData u;
	
	public menu(gameData u) {
		
		this.u = u;
		
		createFont();
		this.setBounds(0, 0, 500, 500);
		setSize(500,500);
		setBackground(Color.BLACK);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
		
	}
	
	private void createFont() {
		try {
		    //create the font to use. Specify the size!
		   scoreFont = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/DeterminationSansWebRegular-369X.ttf")).deriveFont(60f);
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
		   restartFont = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/DeterminationSansWebRegular-369X.ttf")).deriveFont(22f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(restartFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		try {
		    //create the font to use. Specify the size!
		   settingFont = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/DeterminationSansWebRegular-369X.ttf")).deriveFont(15f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(settingFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(scoreFont);
		metrics = g.getFontMetrics(g.getFont());
		g.drawString(lose, (500 - metrics.stringWidth(String.valueOf(lose)))/2, 210);
		g.setColor(Color.white);
		g.setFont(restartFont);
		metrics = g.getFontMetrics(g.getFont());
		g.drawString(tryAgain, (500 - metrics.stringWidth(String.valueOf(tryAgain)))/2, 280);
		g.drawString(mainMenu, (500 - metrics.stringWidth(String.valueOf(mainMenu)))/2, 305);
		metrics = g.getFontMetrics(g.getFont());
		g.drawString(yourScore, 30, 450);
		g.drawString(topScore, (470 - metrics.stringWidth(String.valueOf(topScore))), 450);
		g.setFont(settingFont);
		metrics = g.getFontMetrics(g.getFont());
		g.drawString("PRESS SPACE BAR TO SETTING", 10, 15);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if(e.getX() >= 210 && e.getX() <= 290 & e.getY() >= 265 && e.getY() <= 285) {
			System.out.println("clicked");	System.out.println(e.getX());
			System.out.println(e.getY());
			game.point = 0;
			System.out.println(display.u.name);
			System.out.println(display.u.gameSpeed);
			display.gameStart(display.u);
			}
		if(e.getX() >= 207 && e.getX() <= 290 & e.getY() >= 289 && e.getY() <= 309) {
			System.out.print("restart clicked :");
			System.out.println(e.getY());
			game.point = 0;
			display.d.getContentPane().removeAll();
			display.d.getContentPane().repaint();
			display.startMenu(u);
		}
		
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {
		if(e.getX() >= 210 && e.getX() <= 290 & e.getY() >= 265 && e.getY() <= 285) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		else if(e.getX() >= 207 && e.getX() <= 290 & e.getY() >= 289 && e.getY() <= 309) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		else	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 32) {
			System.out.println("name: " + display.u.name);
			display.d.getContentPane().removeAll();
			display.d.getContentPane().repaint();
			display.setting(u);
		}
		if(e.getKeyCode() == 69) {
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e) {}

}
