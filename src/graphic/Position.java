package graphic;

/**
 * Position osztály, a poziciók tárolására
 */
public class Position {
	private int x;
	private int y;
	
	/**
	 * Position konstruktora, beállítja a megadott pozicíót
	 */
	
	public Position(int x_in, int y_in){
		setX(x_in);
		setY(y_in);
	}
	
	/**
	 * Visszatér a pozíció x-értékével
	 * @return int, az x-értéke
	 */

	public int getX() {
		return x;
	}
	
	/**
	 * Beállítja a pozíció x-értékét
	 * @param x, az x kívánt értéke
	 */

	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Visszatér a pozíció y-értékével
	 * @return int, az y-értéke
	 */
	
	public int getY() {
		return y;
	}

	/**
	 * Beállítja a pozíció y-értékét
	 * @param x, az y kívánt értéke
	 */
	
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Visszatér a két pozíció egyezésével vagy nem egyezésével
	 * @param p, az összehasonlítandó pozíció
	 * @return boolean, az egyezés visszatérési értéke
	 */
	
	public boolean Equals(Position p) {
		return this.x == p.x && this.y == p.y;
	}
	
}
