package field;

import miscellaneous.*;
import equipment.*;

/**
 * A Field osztály leszármazottja, az ilyen típusú mezõkön szerezhetõek alap esetben felszerelések.
 * A játék kezdetekor minden óvóhely tartalmaz egy felszerelést, amit a mezõre lépve a virológus felvehet.
 */
public class Shelter extends Field{
	
	// még most nincs rá szükség, mert lényegében ugyanúgy viselkedik, mint egy sima mezõ
	/*
	public void stepOn(Virologist virologist) {
		super.stepOn(virologist);
		
		Equipment temp = getEquipment();
		if(temp != null) {
			//temp.pickupEquipment(virologist);
			removeEquipment();
			virologist.addEquipment(temp);
			//temp.getEffect();
		}
	}
	*/
	
	public String toString() {
		return "name:\t " + Control.getName(this)
				+ "type:\t shelter"
				+ "virologist:\t " + Control.getName(virologistOnField)
				+ "equipment" + Control.getName(equipmentOnField);
	}
}
