package movement;

import java.io.IOException;

import field.Field;
import field.Storage;
import miscellaneous.Virologist;

public class BearDance extends RandomMovement{
	
	private final int priority = 3;
	
	public boolean move(Virologist v, Field target) throws CloneNotSupportedException, IOException {
		
		super.move(v, target);
		
		
		
		for(int i = 0; i < v.getField().getNeighbors().size(); i++) {
			if(v.getField().getNeighbors().get(i).getVirologist() != null)
				v.getDefense().bearAttack(v, v.getField().getNeighbors().get(i).getVirologist());
		}
		return true;
	}
	
	public int getPriority() {
		return priority;
	}
}
