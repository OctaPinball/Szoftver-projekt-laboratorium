package miscellaneous;

public class Game {
	private boolean randomEnabled;


	Game(){
		this.setRandomEnabled(true);
	}
	
    /**
     * A játék elindításáért felelős függvény
     */
	public void startGame() {
		
	}
	
    /**
     * A játék befejezéséért felelős függvény
     */
	public void endGame() {
		
	}
	
    /**
     * A pálya legenerálásáért felelős: létrehozza a mezőket és beállítja azok szomszédait
     */
	public void generateMap() {
		
	}
	
    /**
     * Szétszór mindenféle különböző tárgyat és megtanulható genetikai kódot a játéktér megfelelő mezőire
     */
	public void scatterObjects() {
		
	}

	public boolean isRandomEnabled() {
		return randomEnabled;
	}

	public void setRandomEnabled(boolean randomEnabled) {
		this.randomEnabled = randomEnabled;
	}
}
