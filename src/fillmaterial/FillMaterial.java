package fillmaterial;

import miscellaneous.Virologist;

public interface FillMaterial {
	
    /**
     * A param�terk�nt kapott virol�gus nyersanyagainak felt�lt�s�hez sz�ks�ges
     * @param v, a virol�gus, aki szeretne nyersanyagot
     */

	public abstract void fillMaterial(Virologist v);
	
}
