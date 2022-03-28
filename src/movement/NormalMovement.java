package movement;

import java.util.ArrayList;

import field.Field;
import miscellaneous.Logger;
import miscellaneous.Virologist;

public class NormalMovement implements Movement{

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
}
