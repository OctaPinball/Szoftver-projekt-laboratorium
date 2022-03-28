package movement;

import java.util.ArrayList;

import field.Field;
import miscellaneous.Logger;
import miscellaneous.Virologist;

public class Stunned implements Movement{

    /**
     * A paraméterként kapott virológus nem tud megmozdulni a jelenlegi mezőjéről
     * @param v, a virológus, aki szeretne ellépni
     * @param target, a mező, ahova lépni szeretne
     */
	
	public void move(Virologist v, Field target) {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(v); par.add(target);
		Logger.enter(this, "move", par);
		
		
		Logger.exit(this, "move", null);
	}
}
