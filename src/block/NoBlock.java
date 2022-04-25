package block;

import java.util.ArrayList;

import agents.Agent;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * Megvalósítja a Block interfészt, amelyik virológuson aktív ez a hatás az nem immunis a vírusokra(lényegében az alapállapot).
 */
public class NoBlock implements Block{

	private final int priority = 0;
	
	/**
	 *A függvény hatására a virológus nem immunis semmilyen vírusra. Hamis értékkel tér vissza, mivel a blockolás nem sikerült.
	 * @param s, a támadó virológus(sender)
	 * @param t, a védekező virológus(target)
	 * @param a, a támadásnál használt ágens
	 * @return false
	 * @throws CloneNotSupportedException
	 */
	@Override
	public boolean block(Virologist s, Virologist t, Agent a) {

		ArrayList<Object> par = new ArrayList<>(); par.add(s); par.add(t); par.add(a);
		Logger.enter(this, "block", par);
		
		
		Logger.exit(this, "block", false);
		return false;
	}

	public int getPriority() {
		return priority;
	}
}
