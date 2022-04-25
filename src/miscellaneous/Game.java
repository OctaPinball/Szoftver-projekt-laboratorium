package miscellaneous;

import java.util.ArrayList;
import field.*;

public class Game {
	private static boolean randomEnabled = true;
	private static ArrayList<Field> allFields = new ArrayList<Field>();
	
    /**
     * A játék elindításáért felelős függvény
     */
	public static void startGame() {
		
	}
	
    /**
     * A játék befejezéséért felelős függvény
     */
	public static void endGame() {
		
	}
	
	public static void generateFieldMap(int width, int height) {
		for(int i = 0; i < height; i++) {
			
		}
	}
	
    /**
     * A pálya legenerálásáért felelős: létrehozza a mezőket és beállítja azok szomszédait
     */
	public static void generateMap(int width, int height) {
		
	}
	
    /**
     * Szétszór mindenféle különböző tárgyat és megtanulható genetikai kódot a játéktér megfelelő mezőire
     */
	public static void scatterObjects() {
		
	}

	public static boolean isRandomEnabled() {
		return randomEnabled;
	}

	public static void setRandomEnabled(boolean newrandomEnabled) {
		randomEnabled = newrandomEnabled;
	}
}
