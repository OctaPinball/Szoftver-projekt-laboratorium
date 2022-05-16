package graphic;

/**
 * A megjeleníthető elemek interfésze
 */
public interface Viewable {
	
	/**
	 * Paraméterül kap egy View-t, amin meghívja az adott elem draw függvényét
	 * @param v, a View paraméter
	 */
	
	public void pickDraw(View v);
	
	/**
	 * Visszatér az elem koordinátájával, pozíciójával
	 * @return Position, a pozíció visszatérési értéke
	 */
	
	public Position calculateCoordinates();
}

