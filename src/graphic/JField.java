package graphic;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

import field.*;

public class JField implements MouseInputListener{
	
	private JLabel label;
	private Field field;
	private View parent;
	
	public JField(JLabel jl, Field f, View p) {
		parent = p;
		label = jl;
		field = f;
	}
	
	/**
	 * Érzékeli ha rákattintanak egy mezőre
	 * @param e
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if(parent.getGamepanel().getActivemenu().getJfield() != null && parent.getGamepanel().getActivemenu().getJfield().equals(this))
		{
			parent.getGamepanel().setMenupriority(false);
		}
		else
		{
			InteractMenu menu = new InteractMenu(this);
			parent.getGamepanel().setMenupriority(true);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Érzékeli ha ráviszik az egeret egy mezőre
	 * @param e
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if(!parent.getGamepanel().isMenupriority())
		{
			InfoMenu menu = new InfoMenu(this);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * A field gettere
	 * @return field
	 */
	public Field getField() {
		return field;
	}

	/**
	 * A parent gettere
	 * @return parent
	 */
	public View getParent() {
		return parent;
	}
	
}
