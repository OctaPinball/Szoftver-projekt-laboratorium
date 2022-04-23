package movement;

import java.util.ArrayList;
import java.util.Random;

import field.Field;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * A movement interfész leszármazottja, ennél a mozgás típusnál a virológus véletlenszerűen mozog, a Chorea ágens hatása okozza.
 */
public class RandomMovement implements Movement{

	private final int priority = 1;
	
    /**
     * A paraméterként kapott virológus átlép egy random sorsolt szomszédos mezőre
     * @param v, a virológus, aki szeretne ellépni
     * @param target, itt nincs jelentősége
     */
	
	public boolean move(Virologist v, Field target) {
		ArrayList<Object> par = new ArrayList<>(); par.add(v); par.add(target);
		Logger.enter(this, "move", par);
		
		
		Field center = v.getField();
		ArrayList<Field> neighbor = center.getNeighbors();
		Random rand = new Random();
		int i = rand.nextInt() % neighbor.size();
		Field realtarget = neighbor.get(i);
		
		v.getField().removeVirologist();
		realtarget.stepOn(v);
		
		
		Logger.exit(this, "move", null);
		return true;
	}
	
	public int getPriority() {
		return priority;
	}
	
}
