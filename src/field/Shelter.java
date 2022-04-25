package field;

import miscellaneous.*;
import equipment.*;

/**
 * A Field oszt�ly lesz�rmazottja, az ilyen t�pus� mez�k�n szerezhet�ek alap esetben felszerel�sek.
 * A j�t�k kezdetekor minden �v�hely tartalmaz egy felszerel�st, amit a mez�re l�pve a virol�gus felvehet.
 */
public class Shelter extends Field{
	
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
	
	public String toString() {
		return "name:\t " + Control.getName(this)
				+ "type:\t shelter"
				+ "virologist:\t " + Control.getName(virologistOnField)
				+ "equipment" + Control.getName(equipmentOnField);
	}
}
