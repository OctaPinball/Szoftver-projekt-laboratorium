package beardefense;

import miscellaneous.Virologist;
import equipment.*;

import java.io.IOException;

import beardefense.*;

/**
 * A BearDefense leszármazottja, amikor aktív a virológus elhárítja a medve támadását egy Axe használatával
 */
public class Defense implements BearDefense{
	
	private final int priority = 1;

	/**
	 * A virológus elhasználja (kicsorbítja) a nála lévõ fejszét és megöli a medvét
	 * @param	bear	A támadó medve
	 * @param	target	A megtámadott virológus
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
	 * @return	Visszadja a védekezés prioritását
	 */
	public int getPriority() {
		return priority;
	}
}
