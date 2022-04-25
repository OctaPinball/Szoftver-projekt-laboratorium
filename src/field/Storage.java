package field;

import java.util.ArrayList;

import miscellaneous.*;

/**
 * A Field oszt�ly lesz�rmazottja, az ilyen t�pus� mez�kre l�pve tudj�k a virol�gusok felt�lteni k�szleteiket.
 */
public class Storage extends Field{
	
	/**
	 * A Field oszt�ly stepOn f�ggv�ny�t kieg�sz�ti, azzal hogy felt�lti a virol�gus �sszes nyersanyag k�szlet�t
	 * @param virologist		a mez�re l�p� virol�gus
	 */
	@Override
	public void stepOn(Virologist virologist) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "stepOn", par);
		
		
		super.stepOn(virologist);
		virologist.getFillMaterial().fillMaterial(virologist);
		
		
		Logger.exit(this, "stepOn", null);
	}
	
	/**
	 * Lem�solja Field-k�nt a Storage oszt�lyon h�vott p�ld�nyt, lem�solja az �sszes �truh�zhat� attrib�tum�t
	 */
	public void copyStorage() {
		Logger.enter(this, "copyStorage", null);
		
		Field copyField = new Field();
		copyField.neighbors.addAll(neighbors);
		
		for(int i = 0; i < neighbors.size(); i++) {
			neighbors.get(i).addNeighbor(copyField);
		}	
		copyField.addVirologist(virologistOnField);
		copyField.spawnEquipment(equipmentOnField);
		
		this.destroy();
		
		Logger.exit(this, "copyStorage", null);
	}
	
	/**
	 * Megsz�nteti a mez� l�tez�s�t, a megfelel� kapcsolatok elv�g�s�val
	 */
	public void destroy() {
		Logger.enter(this, "destroy", null);
		
		for(int i = 0; i < neighbors.size(); i++) {
			neighbors.get(i).removeNeighbor(this);
		}	
		this.removeEquipment();
		this.removeVirologist();
		
		Logger.exit(this, "destroy", null);
	}
}
