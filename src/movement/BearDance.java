package movement;

import field.Field;
import field.Storage;
import miscellaneous.Virologist;

public class BearDance extends RandomMovement{
	
	private final int priority = 3;
	
	public void move(Virologist v, Field target) {
		
		super.move(v, target);
		
		if(v.getField().equals(Storage.class))
			v.getField().Destroy();
		
		for(int i = 0; i < v.getField().getNeighbors().size(); i++) {
			
			v.getField().getNeighbors().get(i).BearAttack(v);
		}
	}
	
	public int getPriority() {
		return priority;
	}
}
