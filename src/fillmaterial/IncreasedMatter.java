package fillmaterial;

import java.util.ArrayList;

import miscellaneous.Logger;
import miscellaneous.Virologist;

public class IncreasedMatter implements FillMaterial{
	
	private static int incAminoacid = 100;
	private static int incNucleotide = 100;

	public void fillMaterial(Virologist v) {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(v);
		Logger.enter(this, "fillMaterial", par);
		
		v.setAminoacid(incAminoacid);
		v.setNucleotide(incNucleotide);
		
		Logger.exit(this, "move", null);
	}
	
}
