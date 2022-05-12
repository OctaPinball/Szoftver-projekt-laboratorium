package graphic;

public class Position {
	private int x;
	private int y;
	
	public Position(int x_in, int y_in){
		setX(x_in);
		setY(y_in);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public boolean Equals(Position p) {
		return this.x == p.x && this.y == p.y;
	}
	
}
