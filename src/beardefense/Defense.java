package beardefense;

import miscellaneous.Virologist;
import equipment.*;

import java.io.IOException;

import beardefense.*;

/**
 * A BearDefense lesz�rmazottja, amikor akt�v a virol�gus elh�r�tja a medve t�mad�s�t egy Axe haszn�lat�val
 */
public class Defense implements BearDefense{
	
	private final int priority = 1;

	/**
	 * A virol�gus elhaszn�lja (kicsorb�tja) a n�la l�v� fejsz�t �s meg�li a medv�t
	 * @param	bear	A t�mad� medve
	 * @param	target	A megt�madott virol�gus
	 * @throws CloneNotSupportedException
	 * @throws IOException
	 */
	public void bearAttack(Virologist bear, Virologist target) {
		
		target.getEquipments();
		for(int i = 0; i < target.getEquipments().size(); i++) {
			if(target.getEquipments().get(i).equals(Axe.class)) {
				
				target.getEquipments().get(i).usedLife();
				target.getEquipments().get(i).loseEffect();
				bear.Die();
				
			}
		}
		bear.Die();
		
	}

	/**
	 * @return	Visszadja a v�dekez�s priorit�s�t
	 */
	public int getPriority() {
		return priority;
	}
}
