package field;

import miscellaneous.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import equipment.*;
import graphic.View;

/**
 * A Field osztály leszármazottja, az ilyen típusú mezõkön szerezhetõek alap esetben felszerelések.
 * A játék kezdetekor minden óvóhely tartalmaz egy felszerelést, amit a mezõre lépve a virológus felvehet.
 */
public class Shelter extends Field{
	
	ImageIcon shelter = new ImageIcon("res/Field_2.png");
	ImageIcon darkShelter = new ImageIcon("res/Field_2.png");
	
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

	/**
	 * Visszaadja stringként a mezõn tartózkodó virológust, 
	 * felszerelést és a mezõ típusát
	 * @return		az említett adatok stringként
	 */
	public String toString() {
		return "name:\t\t" + Control.getName(this)
		+ "\ntype:\t\tshelter"
		+ "\nvirologist:\t" + Control.getName(virologistOnField)
		+ "\nequipment:\t" + Control.getName(equipmentOnField);
	}
	
	/**
	 * Visszaadja a világos óvóhely mezõ képét
	 * @return		világos óvóhely mezõ ImageIcon-ja
	 */
	public ImageIcon getIMG() {
		return shelter;
	}
	
	/**
	 * Visszaadja a sötét mezõ képét
	 * @return		sötét mezõ ImageIcon-ja
	 */
	public ImageIcon getDarkIMG() {
		return darkShelter;
	}

	/**
     *  Kiválasztja az shelter-hoz szükséges rajzolást
     */
	@Override
	public void pickDraw(View v) {
		v.drawShelter(this);
	}
}
