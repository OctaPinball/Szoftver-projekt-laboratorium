package block;

import java.io.IOException;
import java.util.ArrayList;

import agents.Agent;
import miscellaneous.Control;
import miscellaneous.Game;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * Megvalósítja a Block interfészt, amelyik virológuson aktív ez a hatás az immunis a vírusok 82,3%-ra
 */
public class PartialBlock implements Block{

	private final int priority = 1;
	
	/**
	 *A függvény hatására a felkent vírusnak 82,3%-os eséllyel nem lesz hatása a virológusra.
	 * Igaz értékkel tér vissza ha a blockolás sikeres, ellenkező esetben hamissal.
	 * @param s, a támadó virológus(sender)
	 * @param t, a védekező virológus(target)
	 * @param a, a támadásnál használt ágens
	 * @return result
	 * @throws IOException 
	 * @throws CloneNotSupportedException
	 */
	@Override
	public boolean block(Virologist s, Virologist t, Agent a) throws IOException {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(s); par.add(t); par.add(a);
		Logger.enter(this, "block", par);
		
		boolean result = true;
		
		double rnd = Math.random();
		
		if(Game.isRandomEnabled())
		{
			if(rnd < 0.823);
			else result = false;
		}
		else
		{
			System.out.println("block: true/false\n");
			result = Control.getBoolean();
		}
		
		Logger.exit(this, "block", result);
		return result;
	}

	public int getPriority() {
		return priority;
	}
}
