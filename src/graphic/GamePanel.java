package graphic;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import miscellaneous.*;

public class GamePanel extends JPanel implements Const{
	
	private GameFrame parent;
	private Controls controls;
	
	public GamePanel(Controls controls_input, GameFrame frame) {
		parent = frame;
		this.setPreferredSize(new Dimension(PANEL_WIDH,PANEL_HEIGH));
		this.addKeyListener(controls);
		controls = controls_input;
	}

}
