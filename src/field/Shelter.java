package field;

import miscellaneous.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import equipment.*;
import graphic.View;

/**
 * A Field oszt�ly lesz�rmazottja, az ilyen t�pus� mez�k�n szerezhet�ek alap esetben felszerel�sek.
 * A j�t�k kezdetekor minden �v�hely tartalmaz egy felszerel�st, amit a mez�re l�pve a virol�gus felvehet.
 */
public class Shelter extends Field{
	
	ImageIcon shelter = new ImageIcon("res/Field_2.png");
	ImageIcon darkShelter = new ImageIcon("res/Field_2.png");
	
	// m�g most nincs r� sz�ks�g, mert l�nyeg�ben ugyan�gy viselkedik, mint egy sima mez�
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
	
	public ImageIcon getIMG() {
		return shelter;
	}
	
	public ImageIcon getDarkIMG() {
		return darkShelter;
	}
	
	@Override
	public void pickDraw(View v) {
		v.drawShelter(this);
	}
}
