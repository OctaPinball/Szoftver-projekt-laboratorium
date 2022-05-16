package movement;

import java.io.IOException;

import field.Field;
import field.Storage;
import miscellaneous.Virologist;


/**
 * A movement interfész leszármazottja, ezt a mozgatást kapja meg a virológus, mikor medvévé változik.
 */
public class BearDance extends RandomMovement{
	
	private final int priority = 3;
	
    /**
     * A paraméterként kapott virológus szeretne átlépni a paraméterként kapott mezőre
     * @param v, a virológus, aki szeretne ellépni
     * @param target, a mező, ahova lépni szeretne
     * @return boolean, a lépés sikerességét adja vissza
     * @throws IOException 
     * @throws CloneNotSupportedException 
     */
	
	public boolean move(Virologist v, Field target) throws CloneNotSupportedException, IOException {
		
		super.move(v, target);
		
		for(int i = 0; i < v.getField().getNeighbors().size(); i++) {
			if(v.getField().getNeighbors().get(i).getVirologist() != null)
				v.getDefense().bearAttack(v, v.getField().getNeighbors().get(i).getVirologist());
		}
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
