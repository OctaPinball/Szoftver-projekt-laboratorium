package field;

import java.io.IOException;
import java.util.ArrayList;

import miscellaneous.*;

/**
 * A Field osztály leszármazottja, az ilyen típusú mezõkre lépve tudják a virológusok feltölteni készleteiket.
 */
public class Storage extends Field{
	
	public Storage(int id) {
		super(id);
	}

	/**
	 * A Field osztály stepOn függvényét kiegészíti, azzal hogy feltölti a virológus összes nyersanyag készletét
	 * @param virologist		a mezõre lépõ virológus
	 * @throws IOException 
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public void stepOn(Virologist virologist) throws CloneNotSupportedException, IOException {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "stepOn", par);
		
		
		super.stepOn(virologist);
		virologist.getFillMaterial().fillMaterial(virologist);
		
		
		Logger.exit(this, "stepOn", null);
	}
	
	/**
	 * Lemásolja Field-ként a Storage osztályon hívott példányt, lemásolja az összes átruházható attribútumát
	 */
	public void copyStorage() {
		Logger.enter(this, "copyStorage", null);
		
		Field copyField = new Field(this.getID());
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
	 * Megszünteti a mezõ létezését, a megfelelõ kapcsolatok elvágásával
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
	
	public String toString() {
		return "name:\t\t" + Control.getName(this)
		+ "\ntype:\t\tstorage"
		+ "\nvirologist:\t" + Control.getName(virologistOnField)
		+ "\nequipment:\t" + Control.getName(equipmentOnField);
	}
}
