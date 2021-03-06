package beardefense;

import java.io.IOException;

import miscellaneous.Virologist;

/**
 * A virológus medve támadások elleni védekező képességét jellemző interfész
 */
public interface BearDefense {

	/**
	 * A védekezés módját határozza meg, a leszármazottakban kell implementálni.
	 * @param bear		A támadó "virológus" (medve)
	 * @param target	A megtámadott (védekező) virológus	
	 * @throws CloneNotSupportedException
	 * @throws IOException
	 */
	public abstract void bearAttack(Virologist bear, Virologist target) throws CloneNotSupportedException, IOException;

	/**
	 * @return	A védekezési mód priopritását adja meg
	 */
	public abstract int getPriority();
}
