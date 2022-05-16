package graphic;

import java.util.ArrayList;

/**
 * Menü interfész
 */
public interface Menu {
	
	/**
	 * Visszatér a menün található gombokkal
	 * @return ArrayList<JInteractButton>, a gombok tárolási listája
	 */
	
	public ArrayList<JInteractButton> getButtons();
	
	/**
	 * Visszatér a menün kiválasztott JField-del
	 * @return JField, visszatér a JField értékével
	 */
	
	public JField getJfield();
}
