package fillmaterial;

import java.util.ArrayList;

import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * A FillMaterial leszármazottja, amikor aktív a virológus megnövelt készlettel rendelkezik, a Sack felszerelés okozza
 */
public class IncreasedMatter implements FillMaterial{
	
	private static int incAminoacid = 100;
	private static int incNucleotide = 100;

    /**
     * A paraméterként kapott virológus megnövelt nyersanyagkapacitásának maximális feltöltéséhez
     * @param v, a virológus, aki szeretne nyersanyagot
     */
	
	public void fillMaterial(Virologist v) {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(v);
		Logger.enter(this, "fillMaterial", par);
		
		v.setAminoAcid(incAminoacid);
		v.setNucleotide(incNucleotide);
		
		Logger.exit(this, "move", null);
	}
	
}
