package movement;

import java.util.ArrayList;

import field.Field;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * A movement interfész leszármazottja, amikor aktív a virológus egyáltalán nem képes mozogni.
 */
public class Stunned implements Movement{

	private final int priority = 2;
	
    /**
     * A paraméterként kapott virológus nem tud megmozdulni a jelenlegi mezőjéről
     * @param v, a virológus, aki szeretne ellépni
     * @param target, a mező, ahova lépni szeretne
     * @return boolean, a lépés sikerességét adja vissza
     */
	
	public boolean move(Virologist v, Field target) {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(v); par.add(target);
		Logger.enter(this, "move", par);
		
		
		Logger.exit(this, "move", null);
		return true;
	}
	
	/**
	 * A mozgás prioritási számát adja vissza
	 * @return int, a prioritás száma
	 */
	
	public int getPriority() {
		return priority;
	}
}
