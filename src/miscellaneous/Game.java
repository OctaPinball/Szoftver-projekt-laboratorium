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
import miscellaneous.*;

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
			if(f.getPosition().getY() % width != width - 1)
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
					Axe na = new Axe();
					allFields.get(i).spawnEquipment(na);
					Control.equipments.put("e_" + e_ID, na);
						break;
						
					case 1:
					Cape nc = new Cape();
					allFields.get(i).spawnEquipment(nc);
					Control.equipments.put("e_" + e_ID, nc);
						break;
						
					case 2:
					Glove ng = new Glove();
					allFields.get(i).spawnEquipment(ng);
					Control.equipments.put("e_" + e_ID, ng);
						break;
						
					case 3:
					Sack ns = new Sack();
					allFields.get(i).spawnEquipment(ns);
					Control.equipments.put("e_" + e_ID, ns);
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
						BearAgent nb = new BearAgent();
						((Laboratory) allFields.get(i)).addAgent(nb);
						Control.agents.put("a_" + a_ID, nb);
						break;
						
					case 1:
						Chorea nc = new Chorea();
						((Laboratory) allFields.get(i)).addAgent(nc);
						Control.agents.put("a_" + a_ID, nc);
						break;
						
					case 2:
						ForgettingAgent nf = new ForgettingAgent();
						((Laboratory) allFields.get(i)).addAgent(nf);
						Control.agents.put("a_" + a_ID, nf);
						break;
						
					case 3:
						Protection np = new Protection();
						((Laboratory) allFields.get(i)).addAgent(np);
						Control.agents.put("a_" + a_ID, np);
						break;
						
					case 4:
						Stun ns = new Stun();
						((Laboratory) allFields.get(i)).addAgent(ns);
						Control.agents.put("a_" + a_ID, ns);
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

	public static boolean isRandomEnabled() {
		return randomEnabled;
	}

	public static void setRandomEnabled(boolean newrandomEnabled) {
		randomEnabled = newrandomEnabled;
	}
	
	public static ArrayList<Field> getAllFields() {
		return allFields;
	}
}
