package movement;

import java.util.ArrayList;
import java.util.Random;

import field.Field;
import miscellaneous.Logger;
import miscellaneous.Virologist;

public class RandomMovement implements Movement{

	public void move(Virologist v, Field target) {
		ArrayList<Object> par = new ArrayList<>(); par.add(v); par.add(target);
		Logger.enter(this, "move", par);
		
		
		Field center = v.getField();
		ArrayList<Field> neighbor = center.getNeighbors();
		Random rand = new Random();
		int i = rand.nextInt() % neighbor.size();
		Field realtarget = neighbor.get(i);
		
		v.getField().removeVirologist();
		realtarget.stepOn(v);
		
		
		Logger.exit(this, "move", null);
	}
	
}
