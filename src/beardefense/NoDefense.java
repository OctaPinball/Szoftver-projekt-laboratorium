package beardefense;

import miscellaneous.Virologist;

public class NoDefense implements BearDefense{
	
	private final int priority = 0;

	public void bearAttack(Virologist bear, Virologist target) {

		BearAgent ba;
		
		ba.cast(this);
		
	}

	public int getPriority() {
		return priority;
	}
}
