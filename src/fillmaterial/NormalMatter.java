package fillmaterial;

import java.util.ArrayList;

import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * A FillMaterial lesz�rmazottja, alapesetben ez akt�v �s a norm�l k�szletet jelenti
 */
public class NormalMatter implements FillMaterial{
	
	private static int normAminoacid = 100;
	private static int normNucleotide = 100;
	
    /**
     * A param�terk�nt kapott virol�gus norm�l nyersanyagkapacit�s�nak maxim�lis felt�lt�s�hez
     * @param v, a virol�gus, aki szeretne nyersanyagot
     */

	public void fillMaterial(Virologist v) {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(v);
		Logger.enter(this, "fillMaterial", par);
		
		v.setAminoAcid(normAminoacid);
		v.setNucleotide(normNucleotide);
		
		Logger.exit(this, "move", null);
	}
	
}
