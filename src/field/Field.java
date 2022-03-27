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
		virologistOnField = virologist;
	}

	public void removeVirologist() {
		virologistOnField = null;
	}

	public boolean spawnEquipment(Equipment newEquipment) {
		if(equipmentOnField == null)
			return false;
		equipmentOnField = newEquipment;
		return true;
	}

	public void removeEquipment() {
		equipmentOnField = null;
	}
	
	public void addNeighbor(Field neighbor) {
		neighbors.add(neighbor);
	}

	public void stepOn(Virologist virologist) {
		addVirologist(virologist);
		virologist.changeField(this);
	}
	
	public Equipment getEquipment() {
		return equipmentOnField;
	}
}
