package movement;

import java.io.IOException;
import java.util.ArrayList;

import field.Field;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * A movement interfész leszármazottja, ez az alapvető mozgás, amikor éppen nem aktív semmilyen mozgás befolysoló hatás a virológuson
 */
public class NormalMovement implements Movement{

	private final int priority = 0;
	
    /**
     * A paraméterként kapott virológus szeretne átlépni a paraméterként kapott mezőre
     * @param v, a virológus, aki szeretne ellépni
     * @param target, a mező, ahova lépni szeretne
     * @return boolean, a lépés sikerességét adja vissza
     * @throws IOException 
     * @throws CloneNotSupportedException 
     */
	
	public boolean move(Virologist v, Field target) throws CloneNotSupportedException, IOException {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(v); par.add(target);
		Logger.enter(this, "move", par);
		
		if(!v.getField().getNeighbors().contains(target))
			return false;
		v.getField().removeVirologist();
		target.stepOn(v);
		target.addVirologist(v);
		v.changeField(target);
		
		Logger.exit(this, "move", true);
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
