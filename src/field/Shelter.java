package field;

import miscellaneous.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import equipment.*;

/**
 * A Field osztály leszármazottja, az ilyen típusú mezõkön szerezhetõek alap esetben felszerelések.
 * A játék kezdetekor minden óvóhely tartalmaz egy felszerelést, amit a mezõre lépve a virológus felvehet.
 */
public class Shelter extends Field{
	
	Image shelter = new ImageIcon("Field_2.png").getImage();
	Image darkShelter = new ImageIcon("Field_2.png").getImage();
	
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
	
	public Shelter(int id, int x, int y) {
		super(id, x, y);
	}

	public String toString() {
		return "name:\t\t" + Control.getName(this)
		+ "\ntype:\t\tshelter"
		+ "\nvirologist:\t" + Control.getName(virologistOnField)
		+ "\nequipment:\t" + Control.getName(equipmentOnField);
	}
}
