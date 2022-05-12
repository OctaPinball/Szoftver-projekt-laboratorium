package graphic;

import agents.*;
import field.*;
import miscellaneous.RoundManager;

public class InteractMenu {
	public InteractMenu(Field f) {
		
		for(Field field : RoundManager.getEntity().getField().getNeighbors())
		{
			if(field.equals(f))
			{
				if(f.getVirologist() == null)
				{
					
				}
				else
				{
					if(!f.getVirologist().equals(RoundManager.getEntity()))
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
					}
				}
			}
		}
	}
}
