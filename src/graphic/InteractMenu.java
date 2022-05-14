package graphic;

import java.util.ArrayList;

import javax.swing.JLabel;

import agents.*;
import equipment.*;
import field.*;
import miscellaneous.*;
import movement.*;

public class InteractMenu {
	
	private ArrayList<JInteractButton> buttons = new ArrayList<JInteractButton>();
	
	public InteractMenu(JField f) {
		int height = 0;

		
		Position relativepos = f.getField().calculateCoordinates();
		
		if(f.getField().equals(RoundManager.getEntity().getField()))
		{
			for(Equipment e : RoundManager.getEntity().getEquipments())//Drop
			{
				if(e.getClass() == Axe.class && f.getField().getEquipment() == null)
				{
					//Drop Axe
					
				}
				if(e.getClass() == Cape.class && f.getField().getEquipment() == null)
				{
					//Drop Cape
				}
				if(e.getClass() == Glove.class && f.getField().getEquipment() == null)
				{
					//Drop Glove
				}
				if(e.getClass() == Sack.class && f.getField().getEquipment() == null)
				{
					//Drop Sack
				}
			}
			if(f.getField().getEquipment() != null)//Pickup
			{
				if(f.getField().getEquipment().getClass() == Axe.class)
				{
					//Pickup Axe
				}
				if(f.getField().getEquipment().getClass() == Cape.class)
				{
					//Pickup Cape
				}
				if(f.getField().getEquipment().getClass() == Glove.class)
				{
					//Pickup Glove
				}
				if(f.getField().getEquipment().getClass() == Sack.class)
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
				if(field.equals(f.getField()))
				{
					if(f.getField().getVirologist() == null)//Move
					{
						//Move
					}
					else if(!f.getField().getVirologist().equals(RoundManager.getEntity()))
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
						if(f.getField().getVirologist().getMovement().getClass() == Stunned.class)//Steal
						{
							for(int i = 0; i < f.getField().getVirologist().getEquipments().size(); i++)
							{
								if(f.getField().getVirologist().getEquipments().get(i).getClass() == Axe.class)
								{
									//Steal Axe
								}
								if(f.getField().getVirologist().getEquipments().get(i).getClass() == Cape.class)
								{
									//Steal Cape
								}
								if(f.getField().getVirologist().getEquipments().get(i).getClass() == Glove.class)
								{
									//Steal Glove
								}
								if(f.getField().getVirologist().getEquipments().get(i).getClass() == Sack.class)
								{
									//Steal Sack
								}
							}
						}
					}
				}
			}
		}
		JLabel j = new JLabel();
		j.setBounds(0,0,96,height);
		j.setOpaque(true);
		JInteractButton base = new JInteractButton(j, "none");
		f.getParent().getGamepanel().setActivemenu(this);
	}
	
}
