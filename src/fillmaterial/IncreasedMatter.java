package fillmaterial;

import java.util.ArrayList;

import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * A FillMaterial lesz�rmazottja, amikor akt�v a virol�gus megn�velt k�szlettel rendelkezik, a Sack felszerel�s okozza
 */
public class IncreasedMatter implements FillMaterial{
	
	private static int incAminoacid = 100;
	private static int incNucleotide = 100;

    /**
     * A param�terk�nt kapott virol�gus megn�velt nyersanyagkapacit�s�nak maxim�lis felt�lt�s�hez
     * @param v, a virol�gus, aki szeretne nyersanyagot
     */
	
	public void fillMaterial(Virologist v) {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(v);
		Logger.enter(this, "fillMaterial", par);
		
		v.setAminoAcid(incAminoacid);
		v.setNucleotide(incNucleotide);
		
		Logger.exit(this, "move", null);
	}
	
}
