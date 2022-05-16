package miscellaneous;

import java.util.ArrayList;

/**
 *	A j�t�k k�reinek kezel�s��rt felel�s oszt�ly, t�rolja a j�t�kban l�v� virol�gusokat
 */
public class RoundManager {
	private static ArrayList<Virologist> entities = new ArrayList<Virologist>();
	private static Virologist currentEntity;
	
	/**
	 * Elind�tja a soron k�vetkez� virol�gus k�r�t, ha m�r mindenki volt megint az els� virol�gus k�vetkezik
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
	 * Hozz�ad egy virol�gust a virol�gusok t�mbj�hez
	 * @param s		A hozz�adand� virol�gus
	 */
	public static void addEntity(Virologist s) {
		entities.add(s);
	}
	
	/**
	 * @return		Visszaadja a virol�gusok t�mbj�t
	 */
	public static ArrayList<Virologist> getVriologists(){
		return entities;
	}
	
	/**
	 * @return		Visszadja az �ppen soron l�v� virol�gust
	 */
	public static Virologist getEntity() {
		return currentEntity;
	}
}
