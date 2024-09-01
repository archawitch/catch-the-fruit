package Game;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

import character.gameData;

public class display extends JFrame{
	
	static gameData u;
	static display d = new display();
	private Image i;
	
	display(){
		super("catch the fruit");
		getImage();
		u = new gameData("", new Color(107,104,147),new Color(255,204,0), i, 5.0);	//defaultSetting
	}
	
	void getImage(){
		i = new ImageIcon(this.getClass().getResource("/city.png")).getImage();
	}
	
	public static void main (String[] arg) {
		startMenu(u);
	}
	
	public static void startMenu(gameData u1) {
		JPanel p = new startMenu(u);
		d.add(p);
		p.requestFocus();
		d.setSize(500,500);
		d.setResizable(false);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setLocation(480, 190);
		d.setVisible(true);
	}
	
	public static void gameStart(gameData u1) {
		d.getContentPane().removeAll();
		d.getContentPane().repaint();
		u = new gameData(u1.name, u1.userColor, u1.fruitColor, u1.background, u1.gameSpeed);
		game game = new game(u);
		d.add(game);
		game.requestFocus();
	}
	
	public static void menu(gameData u1) {
		d.getContentPane().removeAll();
		d.getContentPane().repaint();
		u = new gameData(u1.name, u1.userColor, u1.fruitColor, u1.background, u1.gameSpeed);
		menu m = new menu(u);
		d.add(m);
		m.requestFocus();
	}
	
	public static void setting(gameData u1) {
		d.getContentPane().removeAll();
		d.getContentPane().repaint();
		u = new gameData(u1.name, u1.userColor, u1.fruitColor, u1.background, u1.gameSpeed);
		setting s = new setting(u);
		d.add(s);
		s.requestFocus();
	}
	
}
