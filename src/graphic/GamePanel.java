package graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	
	public void drawLabels() {
		for(JLabel l : labels)
		{
			this.add(l);
		}
	}
	
	public void addLabel(Position p, ImageIcon i) {
		JLabel j = new JLabel();
		j.setIcon(i);
		j.setBounds(p.getX(),p.getY(),32,32);
		j.setOpaque(true);
		labels.add(j);
	}
	
	public void paint(Graphics g) {
	Graphics2D g2D = (Graphics2D)g;
	g2D.setPaint(Color.red);
	g2D.setFont(new Font("Arial", Font.BOLD, 16));
	g2D.drawString("Inventory", 20, 576);
	g2D.drawString("Agent", 200, 576);
	g2D.drawString("Active agent", 300, 576);
	g2D.drawString("materials", 420, 576);
	
}

}
