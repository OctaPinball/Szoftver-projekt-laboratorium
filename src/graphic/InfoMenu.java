package graphic;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import equipment.*;
import field.*;
import miscellaneous.Control;
import miscellaneous.RoundManager;

/**
 * InfoMenu megvalósítása
 */
public class InfoMenu implements Menu{
	private ArrayList<JInteractButton> buttons = new ArrayList<JInteractButton>();
	
	private JField jfield;

	/**
	 * Amennyiben a felhasználó ráviszi az egér kurzort a virológus karakterére,
	 * megjelenik az InfoMenu, ami különbözõ információkat jelenít meg a képernyõn
	 */
	public InfoMenu(JField f) {
		int height = 0;
		
		
		if(f.getField().getClass() == Laboratory.class)
		{
			ImageIcon i = new ImageIcon("res/b_labor.png");
			JLabel j = new JLabel();
			j.setIcon(i);
			j.setBounds(0,height,96,32);
			height += 32;
			j.setOpaque(true);
			String cmd = " ";
			JInteractButton jf = new JInteractButton(j, cmd, f);
			j.addMouseListener(jf);
			buttons.add(jf);
		}
		else if(f.getField().getClass()== Shelter.class)
		{
			ImageIcon i = new ImageIcon("res/b_shelter.png");
			JLabel j = new JLabel();
			j.setIcon(i);
			j.setBounds(0,height,96,32);
			height += 32;
			j.setOpaque(true);
			String cmd = " ";
			JInteractButton jf = new JInteractButton(j, cmd, f);
			j.addMouseListener(jf);
			buttons.add(jf);
		}
		else if(f.getField().getClass() == Storage.class)
		{
			ImageIcon i = new ImageIcon("res/b_storage.png");
			JLabel j = new JLabel();
			j.setIcon(i);
			j.setBounds(0,height,96,32);
			height += 32;
			j.setOpaque(true);
			String cmd = " ";
			JInteractButton jf = new JInteractButton(j, cmd, f);
			j.addMouseListener(jf);
			buttons.add(jf);
		}
		else
		{
			ImageIcon i = new ImageIcon("res/b_field.png");
			JLabel j = new JLabel();
			j.setIcon(i);
			j.setBounds(0,height,96,32);
			height += 32;
			j.setOpaque(true);
			String cmd = " ";
			JInteractButton jf = new JInteractButton(j, cmd, f);
			j.addMouseListener(jf);
			buttons.add(jf);
		}
		for(Field fn : RoundManager.getEntity().getField().getNeighbors())
		{
			if(fn.equals(f.getField()))
			{
				if(f.getField().getEquipment() != null)
				{
					ImageIcon i = new ImageIcon("res/b_equipment.png");
					JLabel j = new JLabel();
					j.setIcon(i);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = " ";
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
					
					if(f.getField().getEquipment().getClass() == Axe.class)
					{
						ImageIcon in = new ImageIcon("res/Axe.png");
						JLabel jn = new JLabel();
						jn.setIcon(in);
						jn.setBounds(0,height,32,32);
						height += 32;
						jn.setOpaque(true);
						String cmdn = " ";
						JInteractButton jfn = new JInteractButton(jn, cmdn, f);
						jn.addMouseListener(jfn);
						buttons.add(jfn);
					}
					else if(f.getField().getEquipment().getClass() == Cape.class)
					{
						ImageIcon in = new ImageIcon("res/Cape.png");
						JLabel jn = new JLabel();
						jn.setIcon(in);
						jn.setBounds(0,height,32,32);
						height += 32;
						jn.setOpaque(true);
						String cmdn = " ";
						JInteractButton jfn = new JInteractButton(jn, cmdn, f);
						jn.addMouseListener(jfn);
						buttons.add(jfn);
					}
					else if(f.getField().getEquipment().getClass() == Glove.class)
					{
						ImageIcon in = new ImageIcon("res/Glove.png");
						JLabel jn = new JLabel();
						jn.setIcon(in);
						jn.setBounds(0,height,32,32);
						height += 32;
						jn.setOpaque(true);
						String cmdn = " ";
						JInteractButton jfn = new JInteractButton(jn, cmdn, f);
						jn.addMouseListener(jfn);
						buttons.add(jfn);
					}
					else if(f.getField().getEquipment().getClass() == Sack.class)
					{
						ImageIcon in = new ImageIcon("res/Sack.png");
						JLabel jn = new JLabel();
						jn.setIcon(in);
						jn.setBounds(0,height,32,32);
						height += 32;
						jn.setOpaque(true);
						String cmdn = " ";
						JInteractButton jfn = new JInteractButton(jn, cmdn, f);
						jn.addMouseListener(jfn);
						buttons.add(jfn);
					}
				}
				
				if(f.getField().getVirologist() != null)
				{
					ImageIcon i = new ImageIcon("res/b_virologist.png");
					JLabel j = new JLabel();
					j.setIcon(i);
					j.setBounds(0,height,96,32);
					height += 32;
					j.setOpaque(true);
					String cmd = " ";
					JInteractButton jf = new JInteractButton(j, cmd, f);
					j.addMouseListener(jf);
					buttons.add(jf);
					for(Equipment e : f.getField().getVirologist().getEquipments())
					{
						
						if(e.getClass() == Axe.class)
						{
							ImageIcon in = new ImageIcon("res/Axe.png");
							JLabel jn = new JLabel();
							jn.setIcon(in);
							jn.setBounds(0,height,32,32);
							height += 32;
							jn.setOpaque(true);
							String cmdn = " ";
							JInteractButton jfn = new JInteractButton(jn, cmdn, f);
							jn.addMouseListener(jfn);
							buttons.add(jfn);
						}
						if(e.getClass() == Cape.class)
						{
							ImageIcon in = new ImageIcon("res/Cape.png");
							JLabel jn = new JLabel();
							jn.setIcon(in);
							jn.setBounds(0,height,32,32);
							height += 32;
							jn.setOpaque(true);
							String cmdn = " ";
							JInteractButton jfn = new JInteractButton(jn, cmdn, f);
							jn.addMouseListener(jfn);
							buttons.add(jfn);
						}
						if(e.getClass() == Glove.class)
						{
							ImageIcon in = new ImageIcon("res/Glove.png");
							JLabel jn = new JLabel();
							jn.setIcon(in);
							jn.setBounds(0,height,32,32);
							height += 32;
							jn.setOpaque(true);
							String cmdn = " ";
							JInteractButton jfn = new JInteractButton(jn, cmdn, f);
							jn.addMouseListener(jfn);
							buttons.add(jfn);
						}
						if(e.getClass() == Sack.class)
						{
							ImageIcon in = new ImageIcon("res/Sack.png");
							JLabel jn = new JLabel();
							jn.setIcon(in);
							jn.setBounds(0,height,32,32);
							height += 32;
							jn.setOpaque(true);
							String cmdn = " ";
							JInteractButton jfn = new JInteractButton(jn, cmdn, f);
							jn.addMouseListener(jfn);
							buttons.add(jfn);
						}
					}
				}
			}
		}
		
		JLabel j = new JLabel();
		j.setBounds(0,0,96,height);
		j.setOpaque(true);
		JInteractButton base = new JInteractButton(j, " ", f);
		f.getParent().getGamepanel().setActivemenu(this);

	}
	
	/**
	 * A buttons gettere
	 * @return buttons
	 */
	public ArrayList<JInteractButton> getButtons() {
		return buttons;
	}
	
	/**
	 * A jfield gettere
	 * @return jfield
	 */
	public JField getJfield() {
		return jfield;
	}
	
}
