package fillmaterial;

import java.util.ArrayList;

import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * A FillMaterial leszármazottja, alapesetben ez aktív és a normál készletet jelenti
 */
public class NormalMatter implements FillMaterial{
	
	private static int normAminoacid = 100;
	private static int normNucleotide = 100;
	
    /**
     * A paraméterként kapott virológus normál nyersanyagkapacitásának maximális feltöltéséhez
     * @param v, a virológus, aki szeretne nyersanyagot
     */

	public void fillMaterial(Virologist v) {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(v);
		Logger.enter(this, "fillMaterial", par);
		
		v.setAminoAcid(normAminoacid);
		v.setNucleotide(normNucleotide);
		
		Logger.exit(this, "move", null);
	}
	
}
