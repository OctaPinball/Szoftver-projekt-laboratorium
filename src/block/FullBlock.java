package block;

import java.util.ArrayList;

import agents.Agent;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * Megvalósítja a Block interfészt. Amelyik virológuson aktív ez a hatás az immunis minden vírusra.
 */
public class FullBlock implements Block{

	/**
	 *A függvény hatására a felkent vírusnak nincs hatása a virológusra. Igaz értékkel tér vissza, mivel blockolta a vírust.
	 * @param s, a támadó virológus(sender)
	 * @param t, a védekező virológus(target)
	 * @param a, a támadásnál használt ágens
	 * @return true
	 * @throws CloneNotSupportedException
	 */
	@Override
	public boolean block(Virologist s, Virologist t, Agent a) {

		ArrayList<Object> par = new ArrayList<>(); par.add(s); par.add(t); par.add(a);
		Logger.enter(this, "block", par);
		
		
		Logger.exit(this, "block", true);
		return true;
	}

}
