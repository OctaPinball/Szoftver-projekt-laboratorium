package miscellaneous;

import java.util.ArrayList;

public class RoundManager {
	private static ArrayList<Virologist> entity;
	private static Virologist currentEntity;
	
	
	public static void nextRound() {
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
