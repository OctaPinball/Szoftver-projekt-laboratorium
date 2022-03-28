package block;

import java.util.ArrayList;

import agents.Agent;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * Megvalósítja a Block interfészt, amelyik virológuson aktív ez a hatás az immunis a vírusok 82,3%-ra
 */
public class PartialBlock implements Block{

	/**
	 *A függvény hatására a felkent vírusnak 82,3%-os eséllyel nem lesz hatása a virológusra.
	 * Igaz értékkel tér vissza ha a blockolás sikeres, ellenkező esetben hamissal.
	 * @param s, a támadó virológus(sender)
	 * @param t, a védekező virológus(target)
	 * @param a, a támadásnál használt ágens
	 * @return result
	 * @throws CloneNotSupportedException
	 */
	@Override
	public boolean block(Virologist s, Virologist t, Agent a) {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(s); par.add(t); par.add(a);
		Logger.enter(this, "block", par);
		
		boolean result = true;
		
		double rnd = Math.random();
		
		if(rnd < 0.823);
		else result = false;
		
		Logger.exit(this, "block", result);
		return result;
	}

}
