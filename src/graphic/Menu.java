package graphic;

import java.util.ArrayList;

/**
 * Men� interf�sz
 */
public interface Menu {
	
	/**
	 * Visszat�r a men�n tal�lhat� gombokkal
	 * @return ArrayList<JInteractButton>, a gombok t�rol�si list�ja
	 */
	
	public ArrayList<JInteractButton> getButtons();
	
	/**
	 * Visszat�r a men�n kiv�lasztott JField-del
	 * @return JField, visszat�r a JField �rt�k�vel
	 */
	
	public JField getJfield();
}
