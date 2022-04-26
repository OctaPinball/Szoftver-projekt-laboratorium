package beardefense;

import java.io.IOException;

import agents.BearAgent;
import miscellaneous.Virologist;

public class NoDefense implements BearDefense{
	
	private final int priority = 0;

	public void bearAttack(Virologist bear, Virologist target) throws CloneNotSupportedException, IOException {

		BearAgent ba = new BearAgent();
		
		ba.cast(target);
		
	}

	public int getPriority() {
		return priority;
	}
}
