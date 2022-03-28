package miscellaneous;

import java.util.ArrayList;
import java.util.Iterator;

import agents.*;
import block.*;
import equipment.*;
import field.*;
import fillmaterial.*;
import movement.*;


public class Virologist implements Steppable{
	private int aminoacid;
	private int nucleotide;
	private int actionpoint;
	
	private ArrayList<Agent> activeagents;
	private ArrayList<Agent> agents;
	
	private ArrayList<Equipment> equipments;
	
	private Field field;
	
	private Block block;
	private FillMaterial fillmaterial;
	private Movement movement;
	
	Virologist(){
		setBlock(new NoBlock());
		setFillMaterial(new NormalMatter());
		setMovement(new NormalMovement());
		Logger.register(this.getBlock(), "nob");
		Logger.register(this.getFillMaterial(), "nma");
		Logger.register(this.getMovement(), "nmo");
		
		activeagents = new ArrayList<Agent>();
		agents = new ArrayList<Agent>();
		equipments = new ArrayList<Equipment>();
		
		setAminoAcid(0);
		setNucleotide(0);
		actionpoint = 0;
		
		field = null;
	}
	
	public void learnAgent(Agent a) {
		ArrayList<Object> par = new ArrayList<>(); par.add(a);
		Logger.enter(this, "learnAgent", par);
		
		
		boolean found = false;
		for (Agent i : agents)
		{
			if (i.getClass() == a.getClass())
				found = true;
		}
		if(!found)
			agents.add(a);
			
		
		Logger.exit(this, "learnAgent", null);
	}
	
	public void forgetAllAgent() {
		Logger.enter(this, "forgetAllAgent", null);
		
		
		agents = new ArrayList<Agent>();
		
		
		Logger.exit(this, "forgetAllAgent", null);
	}
	
	public void addActiveAgent(Agent a) {
		ArrayList<Object> par = new ArrayList<>(); par.add(a);
		Logger.enter(this, "addActiveAgent", par);
		
		
		boolean found = false;
		for (Agent i : activeagents)
		{
			if (i.getClass() == a.getClass()) 
			{
				activeagents.remove(i);
				found = true;
			}
		}
		activeagents.add(a);
		a.setOwner(this);
		if(!found) 
		{
			a.activate();
		}
			
		
		Logger.exit(this, "addActiveAgent", null);
	}
	
	public boolean addEquipment(Equipment e) {
		ArrayList<Object> par = new ArrayList<>(); par.add(e);
		Logger.enter(this, "addEquipment", par);
		
		
		boolean found = false;
		for (Equipment i : equipments)
		{
			if (i.getClass() == e.getClass()) 
				found = true;
		}
		if(!found)
		{
			equipments.add(e);
			
			e.getEffect();
		}
			
		Logger.exit(this, "addEquipment", !found);
		return !found;
	}
	
	public void loseEquipment(Equipment e) {
		ArrayList<Object> par = new ArrayList<>(); par.add(e);
		Logger.enter(this, "loseEquipment", par);
		
		
		if(equipments.remove(e))
			e.loseEffect();
			
		
		Logger.exit(this, "loseEquipment", null);
	}
	
	public void changeField(Field f) {
		ArrayList<Object> par = new ArrayList<>(); par.add(f);;
		Logger.enter(this, "changeField", par);
		
		this.field = f;
		
		Logger.exit(this, "changeField", null);
	}
	
	public boolean stealEquipment(Equipment e, Virologist v) {
		ArrayList<Object> par = new ArrayList<>(); par.add(e); par.add(v);
		Logger.enter(this, "stealEquipment", par);
		
		boolean success = true;
		
		e.dropEquipment();
		
		if (!v.addEquipment(e))
			success = false;
			
		
		Logger.exit(this, "stealEquipment", success);
		return success;
	}

    /**
     * Getter a virológus blokkolásánakk kiderítésére
     * @return block
     */
	public Block getBlock() {
		return block;
	}

    /**
     * Setter a virológus blokkolásának beállítására
     * @param block
     */
	public void setBlock(Block block) {
		this.block = block;
	}

    /**
     * Getter a virológus maximálisan felvehető anyagmennyisének kiderítésére
     * @return fillmaterial
     */
	public FillMaterial getFillMaterial() {
		return fillmaterial;
	}

    /**
     * Setter a virológus maximálisan felvehető anyagmennyisének beállítására
     * @param fillmaterial
     */
	public void setFillMaterial(FillMaterial fillMaterial) {
		this.fillmaterial = fillMaterial;
	}

    /**
     * Getter a virológus mozgásának kiderítésére
     * @return movement
     */
	public Movement getMovement() {
		return movement;
	}

    /**
     * Setter a virológus mozgásának beállítására
     * @param movement
     */
	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
    /**
     * A steppable interfészt valósítja meg
     * Meghívásonként adott mennyiséggel csökkenti az aktív ágensek hatásidejét
     */
	public void step() {
		Logger.enter(this, "step", null);
		for(Agent a : activeagents)
		{
			a.stepEffectTime();
		}
		Logger.exit(this, "step", null);
	}

    /**
     * Getter a virológus aminosavának jelenlegi mennyiségének kiderítésére
     * @return aminoacid
     */
	public int getAminoacid() {
		return aminoacid;
	}

    /**
     * Setter a virológus aminosavának jelenlegi mennyiségének beállítására
     * @param aminoacid
     */
	public void setAminoAcid(int aminoacid) {
		this.aminoacid = aminoacid;
	}

    /**
     * Getter a virológus nukleotidának jelenlegi mennyiségének kiderítésére
     * @return nucleotide
     */
	public int getNucleotide() {
		return nucleotide;
	}

    /**
     * Setter a virológus nukleotidának jelenlegi mennyiségének beállítására
     * @param nucleotide
     */
	public void setNucleotide(int nucleotide) {
		this.nucleotide = nucleotide;
	}

    /**
     * Getter a virológus jelenlegi mezőjének kiderítésére
     * @return field
     */
	public Field getField() {
		return field;
	}
	
    /**
     * Getter a virológuson jelenleg hatást kifejtő ágensek kiderítésére
     * @return activeagents
     */
	public ArrayList<Agent> getActiveAgents(){
		return activeagents;
	}
}
