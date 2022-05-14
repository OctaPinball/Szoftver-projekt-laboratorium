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
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		InteractMenu menu = new InteractMenu(this);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	
	public Field getField() {
		return field;
	}

	public View getParent() {
		return parent;
	}
	
}
