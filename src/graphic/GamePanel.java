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



/**
 * Megval�s�tja a j�t�k grafikus fel�let�t
 */
public class GamePanel extends JPanel implements Const{
	
	private GameFrame parent;
	//private ControlInput controls;
	private ArrayList<JLabel> labels;
	private Menu activemenu = null;
	private boolean menupriority = false;
	


	View view = null;
	
	/**
	 * GamePanel konstruktora
	 */
	public GamePanel(GameFrame frame) {
		parent = frame;
		this.setPreferredSize(new Dimension(PANEL_WIDH,PANEL_HEIGH));
		//this.addKeyListener(controls);
		//controls = controls_input;
		labels = new ArrayList<JLabel>();
	}
	
	/**
	 * T�rli a k�perny�n l�v� dolgokat
	 */
	public void clearLabels() {
		labels = new ArrayList<JLabel>();
	}
	
	/**
	 * Kirajzolja a bufferben l�v� dolgokat
	 */
	public void drawLabels() {
		for(JLabel l : labels)
		{
			l.setOpaque(true);
			this.add(l);
		}
		this.setVisible(true);
	}
	
	/**
	 * Hozz�ad a bufferbe egy kirajzoland� objektumot
	 */
	public void addLabel(Field f, ImageIcon i) {
				JLabel j = new JLabel();
				j.setIcon(i);
				j.setBounds(f.calculateCoordinates().getX(),f.calculateCoordinates().getY(),32,32);
				j.setOpaque(true);
				JField jf = new JField(j, f, view);
				j.addMouseListener(jf);
				labels.add(j);
	}

	public JLabel safe = null;
	
	/**
	 * Minden rajzol�st megh�v
	 */
	public void paint(Graphics g) {
		//super.paint(g);
		labels = new ArrayList<JLabel>();
		if(view == null)
			view = new View(this);
		if(RoundManager.getEntity() == null)
			RoundManager.nextRound();
		view.drawUI(g, RoundManager.getEntity());
		RoundManager.getEntity().pickDraw(view);
		view.drawMap();
		if(activemenu != null)
		{
			for(JInteractButton j : activemenu.getButtons())
			{
				labels.add(j.getLabel());
				safe = j.getLabel();
			}
		}
		parent.drawLabels(); //FINAL DRAW CALL******
	}
	
	/**
	 * A labels gettere
	 * @return labels
	 */
	public ArrayList<JLabel> getLabels() {
		return labels;
	}

	/**
	 * A activemenu gettere
	 * @return activemenu
	 */
	public Menu getActivemenu() {
		return activemenu;
	}

	/**
	 * A activemenu settere
	 * @param infoMenu
	 */
	public void setActivemenu(Menu infoMenu) {
		this.activemenu = infoMenu;
	}
	
	/**
	 * A menupriority gettere
	 * @return menupriority
	 */
	public boolean isMenupriority() {
		return menupriority;
	}

	/**
	 * A menupriority settere
	 * @param menupriority
	 */
	public void setMenupriority(boolean menupriority) {
		this.menupriority = menupriority;
	}

	
}
