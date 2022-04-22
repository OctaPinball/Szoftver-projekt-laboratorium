package movement;

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
     */
	
	public void move(Virologist v, Field target) {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(v); par.add(target);
		Logger.enter(this, "move", par);
		
		v.getField().removeVirologist();
		target.stepOn(v);
		target.addVirologist(v);
		v.changeField(target);
		
		Logger.exit(this, "move", null);
	}
	
	public int getPriority() {
		return priority;
	}
}
