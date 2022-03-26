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

	public void addVirologist(Virologist virologist) { // lehet boollal kéne visszatérni
		virologistOnField = virologist;
	}

	public void removeVirologist() {
		virologistOnField = null;
	}

	public void spawnEquipment(Equipment newEquipment) {
		if(equipmentOnField == null)
			return false;
		equipmentOnField = newEquipment;
		return true;
	}

	public void removeEquipment() { // nem kell átvenni paraméterben
		equipmentOnField = null;
	}
	
	public void addNeighbor(Field neighbor) {
		neighbors.Add(neighbor);
	}

	public void stepOn(Virologist virologist) {

	}
}
