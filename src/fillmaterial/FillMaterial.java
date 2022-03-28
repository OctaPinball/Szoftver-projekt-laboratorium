package fillmaterial;

import miscellaneous.Virologist;

public interface FillMaterial {
	
    /**
     * A paraméterként kapott virológus nyersanyagainak feltöltéséhez szükséges
     * @param v, a virológus, aki szeretne nyersanyagot
     */

	public abstract void fillMaterial(Virologist v);
	
}
