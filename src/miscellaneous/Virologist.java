package miscellaneous;

import java.util.ArrayList;

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
		
		activeagents = new ArrayList<Agent>();
		agents = new ArrayList<Agent>();
		equipments = new ArrayList<Equipment>();
		
		setAminoacid(0);
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
		if(!found) 
		{
			//a.activate();
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
			//e.getEffect();
		}
			
		Logger.exit(this, "addEquipment", !found);
		return !found;
	}
	
	public void loseEquipment(Equipment e) {
		ArrayList<Object> par = new ArrayList<>(); par.add(e);
		Logger.enter(this, "loseEquipment", par);
		
		
		boolean found = false;
		for (Equipment i : equipments)
		{
			if (i.getClass() == e.getClass()) 
			{
				equipments.remove(i);
				//i.loseEquipment();
			}
		}
			
		
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
		
		//e.dropEquipment();
		
		if (!v.addEquipment(e))
			success = false;
			
		
		Logger.exit(this, "stealEquipment", success);
		return success;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public FillMaterial getFillMaterial() {
		return fillmaterial;
	}

	public void setFillMaterial(FillMaterial fillMaterial) {
		this.fillmaterial = fillMaterial;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
	public void step() {
		Logger.enter(this, "step", null);
		for(Agent a : activeagents)
		{
			//a.setEffectTime(a.getEffectTime - 1);
		}
		Logger.exit(this, "step", null);
	}

	public int getAminoacid() {
		return aminoacid;
	}

	public void setAminoacid(int aminoacid) {
		this.aminoacid = aminoacid;
	}

	public int getNucleotide() {
		return nucleotide;
	}

	public void setNucleotide(int nucleotide) {
		this.nucleotide = nucleotide;
	}

	public Field getField() {
		return field;
	}
}
