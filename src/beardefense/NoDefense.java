package beardefense;

import java.io.IOException;

import agents.BearAgent;
import miscellaneous.Virologist;

/**a
 * A BearDefense lesz�rmazottja, az alapvet� v�dekez�st jelenti, ekkor a t�mad�st nem tudja fejsz�vel h�r�tani, �gy a v�dekez�s
 * teljes m�rt�kben a v�dekez� �gensekt�l f�gg
 */
public class NoDefense implements BearDefense{
	
	private final int priority = 0;

	/**
	 * Egy BearAgent �genst castol a virol�gusra
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
	 * @return	Visszadja a v�dekez�s priorit�s�t
	 */
	public int getPriority() {
		return priority;
	}
}
