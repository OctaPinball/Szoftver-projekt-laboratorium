package field;

import java.util.ArrayList;

import miscellaneous.*;

/**
 * A Field osztály leszármazottja, az ilyen típusú mezõkre lépve tudják a virológusok feltölteni készleteiket.
 */
public class Storage extends Field{
	
	/**
	 * A Field osztály stepOn függvényét kiegészíti, azzal hogy feltölti a virológus összes nyersanyag készletét
	 * @param virologist		a mezõre lépõ virológus
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
	 * Lemásolja Field-ként a Storage osztályon hívott példányt, lemásolja az összes átruházható attribútumát
	 */
	public void copyStorage() {
		Logger.enter(this, "copyStorage", null);
		
		Field copyField = new Field();
		for(int i = 0; i < this.neighbors.size(); i++) {
			copyField.neighbors[i] = this.neighbors[i];
		}	
		
		Logger.exit(this, "copyStorage", null);
	}
	
	/**
	 * Megszünteti a mezõ létezését, a megfelelõ kapcsolatok elvágásával
	 */
	public void destroy() {
		Logger.enter(this, "destroy", null);
		
		
		
		Logger.exit(this, "destroy", null);
	}
}
