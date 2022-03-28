package block;

import java.util.ArrayList;

import agents.Agent;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * A Block interface-t valósítja meg. Ha egy virológuson aktív ez a hatás és megpróbálják valamilyen ágenssel megfertőzni,
 * akkor blokkolja a “támadást” és visszafordítja az ágens hatását támadóra.
 */
public class BlockAndReturn implements Block{
	/**
	 * Számolja, hogy hanyadjára dobják vissza a kenést.
	 */
	private int counter;
	private BlockAndReturn bar = new BlockAndReturn();
	
	public BlockAndReturn() {
		counter = 0;
	}

	/**
	 * A függvény hatására a vírus hatását amit megpróbáltak felkenni a virológusra, visszafordítja a támadóra.
	 * @param s, a támadó virológus(sender)
	 * @param t, a védekező virológus(target)
	 * @param a, a támadásnál használt ágens
	 * @return result
	 * @throws CloneNotSupportedException
	 */
	public boolean block(Virologist s, Virologist t, Agent a) throws CloneNotSupportedException {

		ArrayList<Object> par = new ArrayList<>(); par.add(s); par.add(t); par.add(a);
		Logger.enter(this, "block", par);
		
		boolean result = true;
		
		if(bar.counter < 2) {
			a.cast(t, bar.counter++);
			
			block(t, s, a);		
			return true;
		}
		else result = false;
		
		Logger.exit(this, "block", result);
		return result;
	}
}
