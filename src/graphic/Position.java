package graphic;

/**
 * Position oszt�ly, a pozici�k t�rol�s�ra
 */
public class Position {
	private int x;
	private int y;
	
	/**
	 * Position konstruktora, be�ll�tja a megadott pozic��t
	 */
	
	public Position(int x_in, int y_in){
		setX(x_in);
		setY(y_in);
	}
	
	/**
	 * Visszat�r a poz�ci� x-�rt�k�vel
	 * @return int, az x-�rt�ke
	 */

	public int getX() {
		return x;
	}
	
	/**
	 * Be�ll�tja a poz�ci� x-�rt�k�t
	 * @param x, az x k�v�nt �rt�ke
	 */

	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Visszat�r a poz�ci� y-�rt�k�vel
	 * @return int, az y-�rt�ke
	 */
	
	public int getY() {
		return y;
	}

	/**
	 * Be�ll�tja a poz�ci� y-�rt�k�t
	 * @param x, az y k�v�nt �rt�ke
	 */
	
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Visszat�r a k�t poz�ci� egyez�s�vel vagy nem egyez�s�vel
	 * @param p, az �sszehasonl�tand� poz�ci�
	 * @return boolean, az egyez�s visszat�r�si �rt�ke
	 */
	
	public boolean Equals(Position p) {
		return this.x == p.x && this.y == p.y;
	}
	
}
