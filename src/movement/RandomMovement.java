package movement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import field.Field;
import miscellaneous.Control;
import miscellaneous.Game;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * A movement interfész leszármazottja, ennél a mozgás típusnál a virológus véletlenszerűen mozog, a Chorea ágens hatása okozza.
 */
public class RandomMovement implements Movement{

	private final int priority = 1;
	
    /**
     * A paraméterként kapott virológus átlép egy random sorsolt szomszédos mezőre
     * @param v, a virológus, aki szeretne ellépni
     * @param target, itt nincs jelentősége
     * @throws CloneNotSupportedException 
     * @throws IOException 
     */
	
	public boolean move(Virologist v, Field target) throws CloneNotSupportedException, IOException {
		ArrayList<Object> par = new ArrayList<>(); par.add(v); par.add(target);
		Logger.enter(this, "move", par);
		
		
		Field center = v.getField();
		ArrayList<Field> neighbor = center.getNeighbors();
		
		Field realtarget = null;
		if(Game.isRandomEnabled())
		{
			boolean hasFreePos = false;
			for(int j = 0; j < neighbor.size(); j++)
			{
				if(neighbor.get(j).getVirologist() != null)
				{
					hasFreePos = true;
				}
			}
			if(!hasFreePos)
			{
				return false;
			}
			while(true)
			{
				Random rand = new Random();
				int i = rand.nextInt() % neighbor.size();
				realtarget = neighbor.get(i);
				if(realtarget.getVirologist() == null)
					break;
			}
		}
		else
		{
			boolean first = true;
			String all = "";
			for(Field f : neighbor)
			{
				String name = (String) Control.getKey(Control.getHashMap("f"), f);
				if(first)
				{
					first = false;
				}
				else
				{
					all += "/";
				}
				all += name;
			}
			System.out.println(all);
			realtarget = Control.getField(neighbor);
		}
		
		
		v.getField().removeVirologist();
		realtarget.stepOn(v);
		
		
		Logger.exit(this, "move", null);
		return true;
	}
	
	public int getPriority() {
		return priority;
	}
	
}
