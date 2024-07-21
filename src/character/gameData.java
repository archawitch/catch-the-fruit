package character;

import java.awt.Color;
import java.awt.Image;

public class gameData {
	public String name;
	public Color userColor;
	public Color fruitColor;
	public double gameSpeed;
	public Image background;

	public gameData(String name, Color userColor, Color fruitColor, Image background, double gameSpeed){
		this.name = name;
		this.userColor = userColor;
		this.fruitColor = fruitColor;
		this.gameSpeed = gameSpeed;
		this.background = background;
	}
	
}
