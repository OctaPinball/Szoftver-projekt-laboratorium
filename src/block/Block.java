package block;

import java.io.IOException;

import agents.Agent;
import miscellaneous.Virologist;

/**
 * Egy olyan interfész, ami kezeli a virológusok ágensekkel szembeni védekezését, ezt teszi úgy,
 * hogy váltogatja a védekezési formákat a helyzetnek megfelelően.
 */
public interface Block {

	/**
	 * Egy másik játékostól származó ágenses kenést követően végrehajtandó művelet, mely a virológus védekezését írja le.
	 * @param s, a támadó virológus(sender)
	 * @param t, a védekező virológus(target)
	 * @param a, a támadásnál használt ágens
	 * @return
	 * @throws CloneNotSupportedException
	 * @throws IOException 
	 */
	public abstract boolean block(Virologist s, Virologist t, Agent a) throws CloneNotSupportedException, IOException;

	/**
	 * @return	Visszaadja az ágens védekezés prioritását
	 */
	public abstract int getPriority();
	
}
