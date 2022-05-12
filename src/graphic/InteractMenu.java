package graphic;

import agents.*;
import equipment.*;
import field.*;
import miscellaneous.*;
import movement.*;

public class InteractMenu {
	public InteractMenu(Field f) {
		
		Position relativepos = f.calculateCoordinates();
		
		for(Field field : RoundManager.getEntity().getField().getNeighbors())
		{
			if(field.equals(f))
			{
				if(f.getVirologist() == null)
				{
					
				}
				else if(!f.getVirologist().equals(RoundManager.getEntity()))
				{
					
					for(int i = 0; i < f.getVirologist().getAgents().size(); i++)
					{
						if(f.getVirologist().getAgents().get(i).getClass() == Chorea.class)
						{
								
						}
						if(f.getVirologist().getAgents().get(i).getClass() == ForgettingAgent.class)
						{
								
						}
						if(f.getVirologist().getAgents().get(i).getClass() == Protection.class)
						{
								
						}
						if(f.getVirologist().getAgents().get(i).getClass() == Stun.class)
						{
								
						}
					}
					if(f.getVirologist().getMovement().getClass() == Stunned.class)
					{
						for(int i = 0; i < f.getVirologist().getEquipments().size(); i++)
						{
							if(f.getVirologist().getEquipments().get(i).getClass() == Axe.class)
							{
								
							}
							if(f.getVirologist().getEquipments().get(i).getClass() == Cape.class)
							{
								
							}
							if(f.getVirologist().getEquipments().get(i).getClass() == Glove.class)
							{
								
							}
							if(f.getVirologist().getEquipments().get(i).getClass() == Sack.class)
							{
								
							}
						}
					}
				}
			}
		}
	}
}
