package miscellaneous;

import java.io.IOException;
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
import miscellaneous.*;

/**
 * A játékért felelős osztály
 */
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
				allFields.add(new Field(i*width + j, j, i));
			}
		}
		
		for(Field f : allFields) {
			if(f.calculateCoordinates().getY() != 0)
				f.addNeighbor(allFields.get(f.getID() - width));
			if(f.getID() < width * (height - 1))
				f.addNeighbor(allFields.get(f.getID() + width));
			if(f.calculateCoordinates().getX() % width != 0)
				f.addNeighbor(allFields.get(f.getID() - 1));
			if(f.calculateCoordinates().getY() % width != width - 1)
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
				int ID = i*width + j;
				
				switch(fieldType) {
					case 0:
						Field f0 = new Field(i*width + j, j, i);
						Control.fields.put("f_" + ID, f0);
						allFields.add(f0);
						break;
						
					case 1: 
						Laboratory f1 = new Laboratory(i*width + j, j, i);
						Control.fields.put("f_" + ID, f1);
						allFields.add(f1);
						break;
						
					case 2: 
						Shelter f2 = new Shelter(i*width + j, j, i);
						Control.fields.put("f_" + ID, f2);
						allFields.add(f2);
						break;
						
					case 3: 
						Storage f3 = new Storage(i*width + j, j, i);
						Control.fields.put("f_" + ID, f3);
						allFields.add(f3);
						break;
				}
				//allFields.add(new Field(i*width + j, j, i));
			}
		}
		
		for(Field f : allFields) {
			if(f.getPosition().getY() != 0)
				f.addNeighbor(allFields.get(f.getID() - width));
			if(f.getID() < width * (height - 1))
				f.addNeighbor(allFields.get(f.getID() + width));
			if(f.getPosition().getX() % width != 0)
				f.addNeighbor(allFields.get(f.getID() - 1));
			if(f.getPosition().getX() % width != width - 1)
				f.addNeighbor(allFields.get(f.getID() + 1));
		}
	}
	
    /**
     * Szétszór mindenféle különböző tárgyat és megtanulható genetikai kódot a játéktér megfelelő mezőire
     */
	public static void scatterObjects() {
		int e_ID = 0;
		int a_ID = 0;
		for(int i = 0; i < allFields.size(); i++) {
			if(allFields.get(i).getClass() == Shelter.class) {
				Random rand = new Random();
				e_ID++;
				int equipmentType = rand.nextInt(4);
				
				switch(equipmentType) {
					case 0:
						try {
							Control.runCommand("operator e e_" + e_ID + " create axe");
						} catch (CloneNotSupportedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							Control.runCommand("operator e e_" + e_ID + " move " + Control.getKey(Control.fields, allFields.get(i)));
						} catch (CloneNotSupportedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					case 1:
						try {
							Control.runCommand("operator e e_" + e_ID + " create cape");
						} catch (CloneNotSupportedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							Control.runCommand("operator e e_" + e_ID + " move " + Control.getKey(Control.fields, allFields.get(i)));
						} catch (CloneNotSupportedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					case 2:
						try {
							Control.runCommand("operator e e_" + e_ID + " create glove");
						} catch (CloneNotSupportedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							Control.runCommand("operator e e_" + e_ID + " move " + Control.getKey(Control.fields, allFields.get(i)));
						} catch (CloneNotSupportedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					case 3:
						try {
							Control.runCommand("operator e e_" + e_ID + " create sack");
						} catch (CloneNotSupportedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							Control.runCommand("operator e e_" + e_ID + " move " + Control.getKey(Control.fields, allFields.get(i)));
						} catch (CloneNotSupportedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
				}
			}
			if(allFields.get(i).getClass() == Laboratory.class)
			{
				Random rand = new Random();
				a_ID++;
				int equipmentType = rand.nextInt(5);
				
				switch(equipmentType) {
					case 0:
						try {
							Control.runCommand("operator a a_" + a_ID + " create bearagent");
						} catch (CloneNotSupportedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							Control.runCommand("operator a a_" + a_ID + " move " + Control.getKey(Control.fields, allFields.get(i)));
						} catch (CloneNotSupportedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					case 1:
							try {
								Control.runCommand("operator a a_" + a_ID + " create chorea");
							} catch (CloneNotSupportedException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								Control.runCommand("operator a a_" + a_ID + " move " + Control.getKey(Control.fields, allFields.get(i)));
							} catch (CloneNotSupportedException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						
					case 2:
							try {
								Control.runCommand("operator a a_" + a_ID + " create forgettingagent");
							} catch (CloneNotSupportedException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								Control.runCommand("operator a a_" + a_ID + " move " + Control.getKey(Control.fields, allFields.get(i)));
							} catch (CloneNotSupportedException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						
					case 3:
							try {
								Control.runCommand("operator a a_" + a_ID + " create stun");
							} catch (CloneNotSupportedException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								Control.runCommand("operator a a_" + a_ID + " move " + Control.getKey(Control.fields, allFields.get(i)));
							} catch (CloneNotSupportedException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						
					case 4:
							try {
								Control.runCommand("operator a a_" + a_ID + " create protection");
							} catch (CloneNotSupportedException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								Control.runCommand("operator a a_" + a_ID + " move " + Control.getKey(Control.fields, allFields.get(i)));
							} catch (CloneNotSupportedException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
				}
			}
		}
		int i = 0;
		while(i < RoundManager.getVriologists().size()) //Virológusok elhelyezése
		{
			RoundManager.getVriologists().get(i);
			Random rand = new Random();
			int fieldrandom = rand.nextInt(allFields.size());
			if(allFields.get(fieldrandom).getVirologist() == null)
			{
				allFields.get(fieldrandom).addVirologist(RoundManager.getVriologists().get(i));
				RoundManager.getVriologists().get(i).changeField(allFields.get(fieldrandom));
				i++;
			}
			
		}
		
	}

	/**
	 * A randomEnabled gettere
	 * @return randomEnabled
	 */
	public static boolean isRandomEnabled() {
		return randomEnabled;
	}

	/**
	 * A randomEnabled settere
	 * @param newrandomEnabled
	 */
	public static void setRandomEnabled(boolean newrandomEnabled) {
		randomEnabled = newrandomEnabled;
	}
	
	/**
	 * A allFields gettere
	 * @return allFields
	 */
	public static ArrayList<Field> getAllFields() {
		return allFields;
	}
}
