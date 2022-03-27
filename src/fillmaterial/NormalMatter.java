package fillmaterial;

import java.util.ArrayList;

import miscellaneous.Logger;
import miscellaneous.Virologist;

public class NormalMatter implements FillMaterial{
	
	private static int normAminoacid = 100;
	private static int normNucleotide = 100;

	public void fillMaterial(Virologist v) {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(v);
		Logger.enter(this, "fillMaterial", par);
		
		v.setAminoacid(normAminoacid);
		v.setNucleotide(normNucleotide);
		
		Logger.exit(this, "move", null);
	}
	
}
