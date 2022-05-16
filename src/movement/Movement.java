package movement;

import java.io.IOException;

import field.Field;
import miscellaneous.Virologist;

/**
 * A virológus mozgását jellemző interfész.
 */
public interface Movement {
	
    /**
     * A paraméterként kapott virológus szeretne átlépni egy szomszédos mezőre
     * @param v, a virológus, aki szeretne ellépni
     * @param target, a mező, ahova lépni szeretne
     * @return boolean, a lépés sikerességét adja vissza
     * @throws CloneNotSupportedException 
     * @throws IOException 
     */
	
	public abstract boolean move(Virologist v, Field target) throws CloneNotSupportedException, IOException;

	/**
	 * A mozgás prioritási számát adja vissza
	 * @return int, a prioritás száma
	 */
	
	public abstract int getPriority();

}
