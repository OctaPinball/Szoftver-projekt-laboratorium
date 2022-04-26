package miscellaneous;

import java.util.ArrayList;

public class RoundManager {
	private static ArrayList<Virologist> entity = new ArrayList<Virologist>();
	private static Virologist currentEntity;
	
	
	public static void nextRound() {
		if(currentEntity == null && !entity.isEmpty())
		{
			currentEntity = entity.get(0);
			return;
		}
		if(currentEntity == null)
		{
			return;
		}
		int currentIndex = entity.indexOf(currentEntity);
		if(currentIndex == entity.size() - 1)
		{
			currentEntity = entity.get(0);
			return;
		}
		currentEntity = entity.get(currentIndex + 1);
	}
	
	public static void addEntity(Virologist s) {
		entity.add(s);
	}
	
	public static Virologist getEntity() {
		return currentEntity;
	}
}
