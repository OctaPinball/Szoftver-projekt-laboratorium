package graphic;

import java.util.ArrayList;

import javax.swing.ImageIcon;
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
					ImageIcon i = new ImageIcon("res/b_dropaxe.png");
					JLabel j = new JLabel();
					j.setIcon(i);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "dropequipment " + Control.getKey(Control.equipments,e);
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
				}
				if(e.getClass() == Cape.class && f.getField().getEquipment() == null)
				{
					ImageIcon i = new ImageIcon("res/b_dropcape.png");
					JLabel j = new JLabel();
					j.setIcon(i);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "dropequipment " + Control.getKey(Control.equipments,e);
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
				}
				if(e.getClass() == Glove.class && f.getField().getEquipment() == null)
				{
					ImageIcon i = new ImageIcon("res/b_dropglove.png");
					JLabel j = new JLabel();
					j.setIcon(i);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "dropequipment " + Control.getKey(Control.equipments,e);
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
				}
				if(e.getClass() == Sack.class && f.getField().getEquipment() == null)
				{
					ImageIcon i = new ImageIcon("res/b_dropsack.png");
					JLabel j = new JLabel();
					j.setIcon(i);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "dropequipment " + Control.getKey(Control.equipments,e);
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
				}
			}
			if(f.getField().getEquipment() != null)//Pickup
			{
				if(f.getField().getEquipment().getClass() == Axe.class)
				{
					ImageIcon i = new ImageIcon("res/b_pickupaxe.png");
					JLabel j = new JLabel();
					j.setIcon(i);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "pickupequipment " + Control.getKey(Control.equipments,f.getField().getEquipment());
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
				}
				if(f.getField().getEquipment().getClass() == Cape.class)
				{
					ImageIcon i = new ImageIcon("res/b_pickupcape.png");
					JLabel j = new JLabel();
					j.setIcon(i);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "pickupequipment " + Control.getKey(Control.equipments,f.getField().getEquipment());
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
				}
				if(f.getField().getEquipment().getClass() == Glove.class)
				{
					ImageIcon i = new ImageIcon("res/b_pickupglove.png");
					JLabel j = new JLabel();
					j.setIcon(i);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "pickupequipment " + Control.getKey(Control.equipments,f.getField().getEquipment());
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
				}
				if(f.getField().getEquipment().getClass() == Sack.class)
				{
					ImageIcon i = new ImageIcon("res/b_pickupsack.png");
					JLabel j = new JLabel();
					j.setIcon(i);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "pickupequipment " + Control.getKey(Control.equipments,f.getField().getEquipment());
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
				}
			}
			for(int i = 0; i < RoundManager.getEntity().getAgents().size(); i++) //SelfCast
			{
				if(RoundManager.getEntity().getAgents().get(i).getClass() == Chorea.class)
				{
					ImageIcon im = new ImageIcon("res/b_selfcast_chorea.png");
					JLabel j = new JLabel();
					j.setIcon(im);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "cast " + Control.getKey(Control.virologists, RoundManager.getEntity()) + " " + Control.getKey(Control.agents, RoundManager.getEntity().getAgents().get(i));
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
				}
				if(RoundManager.getEntity().getAgents().get(i).getClass() == ForgettingAgent.class)
				{
					ImageIcon im = new ImageIcon("res/b_selfcast_forget.png");
					JLabel j = new JLabel();
					j.setIcon(im);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "cast " + Control.getKey(Control.virologists, RoundManager.getEntity()) + " " + Control.getKey(Control.agents, RoundManager.getEntity().getAgents().get(i));
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
				}
				if(RoundManager.getEntity().getAgents().get(i).getClass() == Protection.class)
				{
					ImageIcon im = new ImageIcon("res/b_selfcast_protect.png");
					JLabel j = new JLabel();
					j.setIcon(im);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "cast " + Control.getKey(Control.virologists, RoundManager.getEntity()) + " " + Control.getKey(Control.agents, RoundManager.getEntity().getAgents().get(i));
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
				}
				if(RoundManager.getEntity().getAgents().get(i).getClass() == Stun.class)
				{
					ImageIcon im = new ImageIcon("res/b_selfcast_stun.png");
					JLabel j = new JLabel();
					j.setIcon(im);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = "cast " + Control.getKey(Control.virologists, RoundManager.getEntity()) + " " + Control.getKey(Control.agents, RoundManager.getEntity().getAgents().get(i));
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
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
						ImageIcon i = new ImageIcon("res/b_move.png");
						JLabel j = new JLabel();
						j.setIcon(i);
						j.setBounds(0,height,96,32);
						height += 32;
						j.setOpaque(true);
						String cmd = "move " + Control.getKey(Control.fields,f.getField());
						JInteractButton jf = new JInteractButton(j, cmd, f);
						j.addMouseListener(jf);
						buttons.add(jf);
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
		JInteractButton base = new JInteractButton(j, "none", f);
		f.getParent().getGamepanel().setActivemenu(this);
	}
	
	public ArrayList<JInteractButton> getButtons() {
		return buttons;
	}
	
}
