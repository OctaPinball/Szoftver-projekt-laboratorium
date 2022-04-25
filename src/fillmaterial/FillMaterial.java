package fillmaterial;

import miscellaneous.Virologist;

/**
 * A virol�gus anyaggy�jt� k�pess�g�t jellemz� interf�sz
 */

public interface FillMaterial {
	
    /**
     * A param�terk�nt kapott virol�gus nyersanyagainak felt�lt�s�hez sz�ks�ges
     * @param v, a virol�gus, aki szeretne nyersanyagot
     */

	public abstract void fillMaterial(Virologist v);

	public abstract int getPriority();
	
}
