package miscellaneous;

import java.util.ArrayList;

/**
 *	A játék köreinek kezeléséért felelõs osztály, tárolja a játékban lévõ virológusokat
 */
public class RoundManager {
	private static ArrayList<Virologist> entities = new ArrayList<Virologist>();
	private static Virologist currentEntity;
	
	/**
	 * Elindítja a soron következõ virológus körét, ha már mindenki volt megint az elsõ virológus következik
	 */
	public static void nextRound() {
		if(currentEntity == null && !entities.isEmpty())
		{
			currentEntity = entities.get(0);
			currentEntity.newRound();
			return;
		}
		if(currentEntity == null)
		{
			return;
		}
		int currentIndex = entities.indexOf(currentEntity);
		if(currentIndex == entities.size() - 1)
		{
			currentEntity = entities.get(0);
			currentEntity.newRound();
			return;
		}
		currentEntity = entities.get(currentIndex + 1);
		currentEntity.newRound();
	}
	
	/**
	 * Hozzáad egy virológust a virológusok tömbjéhez
	 * @param s		A hozzáadandó virológus
	 */
	public static void addEntity(Virologist s) {
		entities.add(s);
	}
	
	/**
	 * @return		Visszaadja a virológusok tömbjét
	 */
	public static ArrayList<Virologist> getVriologists(){
		return entities;
	}
	
	/**
	 * @return		Visszadja az éppen soron lévõ virológust
	 */
	public static Virologist getEntity() {
		return currentEntity;
	}
}
