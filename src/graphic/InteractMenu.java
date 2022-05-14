package graphic;

import java.util.ArrayList;

import agents.*;
import equipment.*;
import field.*;
import miscellaneous.*;
import movement.*;

public class InteractMenu {
	
	private ArrayList<JInteractButton> buttons = new ArrayList<JInteractButton>();
	
	public InteractMenu(Field f) {
		
		Position relativepos = f.calculateCoordinates();
		
		if(f.equals(RoundManager.getEntity().getField()))
		{
			for(Equipment e : RoundManager.getEntity().getEquipments())//Drop
			{
				if(e.getClass() == Axe.class && f.getEquipment() == null)
				{
					//Drop Axe
				}
				if(e.getClass() == Cape.class && f.getEquipment() == null)
				{
					//Drop Cape
				}
				if(e.getClass() == Glove.class && f.getEquipment() == null)
				{
					//Drop Glove
				}
				if(e.getClass() == Sack.class && f.getEquipment() == null)
				{
					//Drop Sack
				}
			}
			if(f.getEquipment() != null)//Pickup
			{
				if(f.getEquipment().getClass() == Axe.class)
				{
					//Pickup Axe
				}
				if(f.getEquipment().getClass() == Cape.class)
				{
					//Pickup Cape
				}
				if(f.getEquipment().getClass() == Glove.class)
				{
					//Pickup Glove
				}
				if(f.getEquipment().getClass() == Sack.class)
				{
					//Pickup Sack
				}
			}
			for(int i = 0; i < RoundManager.getEntity().getAgents().size(); i++) //SelfCast
			{
				if(RoundManager.getEntity().getAgents().get(i).getClass() == Chorea.class)
				{
					//SelfCast Chorea	
				}
				if(RoundManager.getEntity().getAgents().get(i).getClass() == ForgettingAgent.class)
				{
					//SelfCast Forgetting
				}
				if(RoundManager.getEntity().getAgents().get(i).getClass() == Protection.class)
				{
					//SelfCast Protection
				}
				if(RoundManager.getEntity().getAgents().get(i).getClass() == Stun.class)
				{
					//SelfCast Stun
				}
			}
		}
		else
		{
			for(Field field : RoundManager.getEntity().getField().getNeighbors())
			{
				if(field.equals(f))
				{
					if(f.getVirologist() == null)//Move
					{
						//Move
					}
					else if(!f.getVirologist().equals(RoundManager.getEntity()))
					{
						
						for(int i = 0; i < RoundManager.getEntity().getAgents().size(); i++)//Cast
						{
							if(RoundManager.getEntity().getAgents().get(i).getClass() == Chorea.class) //Material Check Need!!!!!!
							{
								//Cast Chorea	
							}
							if(RoundManager.getEntity().getAgents().get(i).getClass() == ForgettingAgent.class)
							{
								//Cast Forgetting
							}
							if(RoundManager.getEntity().getAgents().get(i).getClass() == Protection.class)
							{
								//Cast Protection
							}
							if(RoundManager.getEntity().getAgents().get(i).getClass() == Stun.class)
							{
								//Cast Stun
							}
						}
						if(f.getVirologist().getMovement().getClass() == Stunned.class)//Steal
						{
							for(int i = 0; i < f.getVirologist().getEquipments().size(); i++)
							{
								if(f.getVirologist().getEquipments().get(i).getClass() == Axe.class)
								{
									//Steal Axe
								}
								if(f.getVirologist().getEquipments().get(i).getClass() == Cape.class)
								{
									//Steal Cape
								}
								if(f.getVirologist().getEquipments().get(i).getClass() == Glove.class)
								{
									//Steal Glove
								}
								if(f.getVirologist().getEquipments().get(i).getClass() == Sack.class)
								{
									//Steal Sack
								}
							}
						}
					}
				}
			}
		}
	}
}
