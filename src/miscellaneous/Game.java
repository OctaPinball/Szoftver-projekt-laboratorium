package miscellaneous;

import java.util.ArrayList;
import java.util.Random;

import agents.*;
import beardefense.*;
import block.*;
import equipment.*;
import field.*;
import fillmaterial.*;
import movement.*;
import beardefense.*;

public class Game {
	private static boolean randomEnabled = true;
	private static ArrayList<Field> allFields = new ArrayList<Field>();
	public static int width;
	public static int height;
	
    /**
     * A játék elindításáért felelős függvény
     */
	public static void startGame(int width, int height) {
		generateFieldMap(width, height);
		scatterObjects();
	}
	
    /**
     * A játék befejezéséért felelős függvény
     */
	public static void endGame() {
		
	}
	
	public static void generateFieldMap(int width, int height) {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				allFields.add(new Field(i*width + j));
			}
		}
		
		for(Field f : allFields) {
			if(0 <= f.getID()-width)
				f.addNeighbor(allFields.get(f.getID() - width));
			if(f.getID()+width < width * height)
				f.addNeighbor(allFields.get(f.getID() + width));
			if(f.getID() % (width + 1) == 0)
				f.addNeighbor(allFields.get(f.getID() - 1));
			if(f.getID() + 1 % (width + 1) == 1)
					f.addNeighbor(allFields.get(f.getID() + 1));
		}
	}
	
    /**
     * A pálya legenerálásáért felelős: létrehozza a mezőket és beállítja azok szomszédait
     */
	public static void generateMap(int width, int height) {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				Random rand = new Random();
				int fieldType = rand.nextInt(4);
				
				switch(fieldType) {
					case 0: allFields.add(new Field(i*width + j));
						break;
						
					case 1: allFields.add(new Laboratory(i*width + j));
						break;
						
					case 2: allFields.add(new Shelter(i*width + j));
						break;
						
					case 3: allFields.add(new Storage(i*width + j));
						break;
				}
				allFields.add(new Field(i*width + j));
			}
		}
		
		for(Field f : allFields) {
			if(0 <= f.getID()-width)
				f.addNeighbor(allFields.get(f.getID() - width));
			if(f.getID()+width < width * height)
				f.addNeighbor(allFields.get(f.getID() + width));
			if(f.getID() % (width + 1) == 0 && f.getID() != 0)
				f.addNeighbor(allFields.get(f.getID() - 1));
			if(f.getID() + 1 % (width + 1) == 1)
					f.addNeighbor(allFields.get(f.getID() + 1));
		} 
	}
	
    /**
     * Szétszór mindenféle különböző tárgyat és megtanulható genetikai kódot a játéktér megfelelő mezőire
     */
	public static void scatterObjects() {
		for(int i = 0; i < allFields.size(); i++) {
			if(allFields.get(i).getClass() == Shelter.class) {
				Random rand = new Random();
				int equipmentType = rand.nextInt(4);
				
				switch(equipmentType) {
					case 0: allFields.get(i).spawnEquipment(new Axe());
						break;
						
					case 1: allFields.get(i).spawnEquipment(new Cape());
						break;
						
					case 2: allFields.get(i).spawnEquipment(new Glove());
						break;
						
					case 3: allFields.get(i).spawnEquipment(new Sack());
						break;
				}
			}
		}
	}

	public static boolean isRandomEnabled() {
		return randomEnabled;
	}

	public static void setRandomEnabled(boolean newrandomEnabled) {
		randomEnabled = newrandomEnabled;
	}
}
