package beardefense;

import miscellaneous.Virologist;

public class Defense implements BearDefense{
	
	private final int priority = 1;

	public void bearAttack(Virologist bear) {
		
		this.getEquipment().UsedLife();
		bear.Die();
		
	}

	public int getPriority() {
		return priority;
	}
}
