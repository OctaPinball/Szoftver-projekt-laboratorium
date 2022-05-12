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

import field.*;
import miscellaneous.*;

public class GamePanel extends JPanel implements Const{
	
	private GameFrame parent;
	private ControlInput controls;
	private ArrayList<JLabel> labels;
	


	View view = null;
	
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
			l.setOpaque(true);
			this.add(l);
		}
		this.setVisible(true);
	}
	
	public void addLabel(Position p, ImageIcon i) {
		ArrayList<Field> fields = Game.getAllFields();
		for(Field f : fields)
		{
			if(f.calculateCoordinates().Equals(p))
			{
				JLabel j = new JLabel();
				j.setIcon(i);
				j.setBounds(p.getX(),p.getY(),32,32);
				j.setOpaque(true);
				JField jf = new JField(j, f);
				j.addMouseListener(jf);
				labels.add(j);
			}
		}

		
		/*
		JLabel j = new JLabel();
		j.setIcon(i);
		j.setBounds(p.getX(),p.getY(),32,32);
		j.setOpaque(true);
		j.addMouseListener(new ControlInput());
		labels.add(j);
		*/
	}
	
	public void paint(Graphics g) {
		if(view == null)
			view = new View();
		if(RoundManager.getEntity() == null)
			RoundManager.nextRound();
		view.drawUI(g, RoundManager.getEntity());
		view.drawMap();
		//drawLabels();
		parent.drawLabels();
		parent.prepareShit();
		parent.drawShit();
	}
	
	public ArrayList<JLabel> getLabels() {
		return labels;
	}

	
}
