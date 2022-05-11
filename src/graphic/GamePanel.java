package graphic;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miscellaneous.*;

public class GamePanel extends JPanel implements Const{
	
	private GameFrame parent;
	private ControlInput controls;
	private ArrayList<JLabel> labels;
	
	public GamePanel(ControlInput controls_input, GameFrame frame) {
		parent = frame;
		this.setPreferredSize(new Dimension(PANEL_WIDH,PANEL_HEIGH));
		//this.addKeyListener(controls);
		controls = controls_input;
		labels = new ArrayList<JLabel>();
	}
	
	public void clearLabels() {
		labels = new ArrayList<JLabel>();
	}
	
	public void addLabel(Position p, ImageIcon i) {
		JLabel j = new JLabel();
	}

}
