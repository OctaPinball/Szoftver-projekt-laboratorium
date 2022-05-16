package block;

import java.io.IOException;
import java.util.ArrayList;

import agents.Agent;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * A Block interface-t valósítja meg. Ha egy virológuson aktív ez a hatás és megpróbálják valamilyen ágenssel megfertőzni,
 * akkor blokkolja a “támadást” és visszafordítja az ágens hatását támadóra.
 */
public class BlockAndReturn implements Block{
	
	private final int priority = 3;
	
	/**
	 * Számolja, hogy hanyadjára dobják vissza a kenést.
	 */
	
	public BlockAndReturn() {
	}

	/**
	 * A függvény hatására a vírus hatását amit megpróbáltak felkenni a virológusra, visszafordítja a támadóra.
	 * @param s, a támadó virológus(sender)
	 * @param t, a védekező virológus(target)
	 * @param a, a támadásnál használt ágens
	 * @return result
	 * @throws CloneNotSupportedException
	 * @throws IOException 
	 */
	public boolean block(Virologist s, Virologist t, Agent a) throws CloneNotSupportedException, IOException {

		ArrayList<Object> par = new ArrayList<>(); par.add(s); par.add(t); par.add(a);
		Logger.enter(this, "block", par);
		
		if(!s.equals(t)) {
			a.cast(s);
		}
		
		Logger.exit(this, "block", true);
		return true;
	}
	
	/**
	 * @return	Visszaadja a BlockAndReturn prioritását
	 */
	public int getPriority() {
		return priority;
	}
}
