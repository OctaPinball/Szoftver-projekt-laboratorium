package movement;

import field.Field;
import field.Storage;
import miscellaneous.Virologist;

public class BearDance extends RandomMovement{
	
	private final int priority = 3;
	
	public boolean move(Virologist v, Field target) throws CloneNotSupportedException {
		
		super.move(v, target);
		
		for(int i = 0; i < v.getField().getNeighbors().size(); i++) {
			
			v.getDefense().bearAttack(v, v.getField().getNeighbors().get(i).getVirologist());
		}
		return true;
	}
	
	public int getPriority() {
		return priority;
	}
}
