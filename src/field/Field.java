package field;

import java.util.ArrayList;
import miscellaneous.*;
import equipment.*;

public class Field {
	
	private Virologist virologistOnField;
	private Equipment equipmentOnField;

	private ArrayList<Field> neighbors;

	public Field() {
		neighbors = new ArrayList<Field>();
	}

	public void addVirologist(Virologist virologist) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "addVirologist", par);
		
		
		virologistOnField = virologist;
		
		
		Logger.exit(this, "addVirologist", null);
	}

	public void removeVirologist() {
		Logger.enter(this, "removeVirologist", null);
		
		
		virologistOnField = null;
		
		
		Logger.exit(this, "removeVirologist", null);
	}

	public boolean spawnEquipment(Equipment newEquipment) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(newEquipment);
		Logger.enter(this, "spawnEquipment", par);
		
		boolean canDrop = false;
		if(equipmentOnField != null) {
			equipmentOnField = newEquipment;
			canDrop = true;
		}
		
		Logger.exit(this, "spawnEquipment", canDrop);
		return canDrop;
	}

	public void removeEquipment() {
		Logger.enter(this, "removeEquipment", null);
		
		
		equipmentOnField = null;
		
		
		Logger.exit(this, "removeEquipment", null);
	}
	
	public void addNeighbor(Field neighbor) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(neighbor);
		Logger.enter(this, "addNeighbor", par);
		
		
		neighbors.add(neighbor);
		
		
		Logger.exit(this, "addNeighbor", null);
	}

	public void stepOn(Virologist virologist) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "stepOn", par);
		
		
		addVirologist(virologist);
		virologist.changeField(this);
		
		
		Logger.exit(this, "stepOn", null);
	}
	
	public Equipment getEquipment() {
		//Logger.enter(this, "getEquipment", null);
		
		//Logger.exit(this, "getEquipment", equipmentOnField);
		return equipmentOnField;
	}
	
	public ArrayList<Field> getNeighbors(){
		return neighbors;
	}
}
