package field;

import java.util.ArrayList;

import miscellaneous.*;

public class Storage extends Field{
	
	public void stepOn(Virologist virologist) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "stepOn", par);
		
		
		super.stepOn(virologist);
		virologist.getFillMaterial().fillMaterial();
		
		
		Logger.exit(this, "stepOn", null);
	}
}
