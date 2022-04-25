package fillmaterial;

import miscellaneous.Virologist;

/**
 * A virológus anyaggyûjtõ képességét jellemzõ interfész
 */

public interface FillMaterial {
	
    /**
     * A paraméterként kapott virológus nyersanyagainak feltöltéséhez szükséges
     * @param v, a virológus, aki szeretne nyersanyagot
     */

	public abstract void fillMaterial(Virologist v);

	public abstract int getPriority();
	
}
