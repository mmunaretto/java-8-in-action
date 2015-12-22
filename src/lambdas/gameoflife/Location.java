package lambdas.gameoflife;

public class Location {

	private int x;
	private int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void equals(Location otherLocation, IfEqual action) {
		otherLocation.equals(this.x, this.y, action);
	}

	public void equals(int otherX, int otherY, IfEqual action) {
		if (x == otherX && y == otherY) 
			action.doSomething();
	}
}
