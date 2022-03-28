package movement;

import field.Field;
import miscellaneous.Virologist;

public interface Movement {
	
    /**
     * A paraméterként kapott virológus szeretne átlépni egy szomszédos mezőre
     * @param v, a virológus, aki szeretne ellépni
     * @param target, a mező, ahova lépni szeretne
     */
	
	public abstract void move(Virologist v, Field target);

}
