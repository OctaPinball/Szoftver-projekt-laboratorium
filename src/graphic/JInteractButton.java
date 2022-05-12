package graphic;

import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

import field.Field;
import miscellaneous.Control;

public class JInteractButton implements MouseInputListener {

	private String command;
	private JLabel label;
	
	public JInteractButton(JLabel jl, String cmd) {
		label = jl;
		command = cmd;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			Control.runCommand(command);
		} catch (CloneNotSupportedException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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

}
