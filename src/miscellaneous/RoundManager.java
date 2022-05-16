package miscellaneous;

import java.util.ArrayList;

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
	
	public static void addEntity(Virologist s) {
		entities.add(s);
	}
	
	public static ArrayList<Virologist> getVriologists(){
		return entities;
	}
	
	public static Virologist getEntity() {
		return currentEntity;
	}
}
