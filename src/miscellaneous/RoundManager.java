package miscellaneous;

import java.util.ArrayList;

/**
 * A játék köreinek kezeléséért felelõs osztály
 */
public class RoundManager {
	private static ArrayList<Virologist> entities = new ArrayList<Virologist>();
	private static Virologist currentEntity;
	
	
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
	 * A entities listához új elemet ad
	 * @param s
	 */
	public static void addEntity(Virologist s) {
		entities.add(s);
	}
	
	/**
	 * A entities gettere
	 * @return entities
	 */
	public static ArrayList<Virologist> getVriologists(){
		return entities;
	}
	
	/**
	 * A currentEntity gettere
	 * @return currentEntity
	 */
	public static Virologist getEntity() {
		return currentEntity;
	}
}
