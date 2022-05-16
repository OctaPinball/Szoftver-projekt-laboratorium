package beardefense;

import java.io.IOException;

import agents.BearAgent;
import miscellaneous.Virologist;

/**a
 * A BearDefense leszármazottja, az alapvetõ védekezést jelenti, ekkor a támadást nem tudja fejszével hárítani, így a védekezés
 * teljes mértékben a védekezõ ágensektõl függ
 */
public class NoDefense implements BearDefense{
	
	private final int priority = 0;

	/**
	 * Egy BearAgent ágenst castol a virológusra
	 * @param	bear
	 * @param	target
	 * @throws CloneNotSupportedException
	 * @throws IOException
	 */
	public void bearAttack(Virologist bear, Virologist target) throws CloneNotSupportedException, IOException {

		BearAgent ba = new BearAgent();
		ba.setOwner(bear);
		
		ba.cast(target);
		
	}

	/**
	 * @return	Visszadja a védekezés prioritását
	 */
	public int getPriority() {
		return priority;
	}
}
