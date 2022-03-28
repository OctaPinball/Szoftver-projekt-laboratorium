package field;

import java.util.ArrayList;

import miscellaneous.*;

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
}
