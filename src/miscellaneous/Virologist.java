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
	
	Virolo00gist(){
		setBlock(new NoBlock());
		setFillMaterial(new NormalMatter());
		setMovement(new NormalMovement());
		
		activeagents = new ArrayList<Agent>();
		agents = new ArrayList<Agent>();
		equipments = new ArrayList<Equipment>();
		
		aminoacid = 0;
		nucleotide = 0;
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
			//a.activate();
			
		
		Logger.exit(this, "addActiveAgent", null);
	}
	
	public void addEquipment(Equipment e) {
		ArrayList<Object> par = new ArrayList<>(); par.add(e);
		Logger.enter(this, "addEquipment", par);
		
		
		boolean found = false;
		for (Equipment i : equipments)
		{
			if (i.getClass() == e.getClass()) 
			{
				equipments.remove(i);
				found = true;
			}
		}
		equipments.add(e);
		if(!found)
			//e.getEffect();
			
		
		Logger.exit(this, "addEquipment", null);
	}
	
	public void loseEquipment(Equipment e) {
		ArrayList<Object> par = new ArrayList<>(); par.add(e);
		Logger.enter(this, "addEquipment", par);
		
		
		boolean found = false;
		for (Equipment i : equipments)
		{
			if (i.getClass() == e.getClass()) 
			{
				equipments.remove(i);
				found = true;
			}
		}
		equipments.add(e);
		if(!found)
			//e.getEffect();
			
		
		Logger.exit(this, "addEquipment", null);
	}
	
	public void changeField(Field f) {
		this.field = f;
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
	
	public void Step() {
		
	}
}
