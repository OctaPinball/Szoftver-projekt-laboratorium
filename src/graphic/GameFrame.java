package graphic;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.*;


public class GameFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private GamePanel panel;
	private ControlInput controls;
	private ArrayList<JLabel> removeable = new ArrayList<JLabel>();
	
	public GameFrame(){
		controls = new ControlInput();
		panel = new GamePanel(controls, this);
		setPanel(panel);
		
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	dispose();
				MainMenu mainmenu = new MainMenu();
				mainmenu.f.setVisible(true);
            }
        });
	
		add(getPanel());
		setTitle("Világtalan Virológusok");
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setFocusable(true);
		requestFocus();
		
		this.setLayout(null);
		
	}
	
	JLabel label;
	JLabel label2;
	
	public void drawLabels() {

		for (JLabel jl : removeable) {
			jl.setVisible(false);
			panel.remove(jl);  
		}
		removeable = new ArrayList<JLabel>();

		revalidate();
		repaint();
		
		setResizable(false);
		this.setLayout(null);
		for(JLabel l : panel.getLabels())
		{
			l.setVisible(true);
			this.add(l);
			removeable.add(l);
		}
		this.setVisible(true);
	}

	/**
	 * A panel gettere
	 * 
	 * @return panel
	 */
	public GamePanel getPanel() {
		return panel;
	}

	/**A panel settere
	 * 
	 * @param panel
	 */
	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}
	
}

