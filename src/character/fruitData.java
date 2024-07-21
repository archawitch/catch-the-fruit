package character;

public class fruitData extends fruit{
	
	public int radius;
	public int startY;
	double gameSpeed;
	
	public fruitData(int x, int y, int radius, double gameSpeed) {
		super(x,y,radius);
		this.startY = y;
		this.gameSpeed = gameSpeed;
	}
	
}
