package graphic;

import javax.swing.*;


public class GameFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private GamePanel panel;
	private Controls controls;
	
	public GameFrame(){
		controls = new Controls();
		setPanel(new GamePanel(controls, this));
		
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	dispose();
            	//getPanel().stopTimer();
				MainMenu mainmenu = new MainMenu();
				mainmenu.f.setVisible(true);
            }
        });
		

		add(getPanel());
		setTitle("Világtalan Virológusok");
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		addKeyListener(controls);
		setVisible(true);
		setFocusable(true);
		requestFocus();
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

