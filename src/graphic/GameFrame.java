package graphic;

import java.awt.Color;

import javax.swing.*;


public class GameFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private GamePanel panel;
	private ControlInput controls;
	
	public GameFrame(){
		controls = new ControlInput();
		panel = new GamePanel(controls, this);
		setPanel(panel);
		
		
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
		//addKeyListener(controls);
		setVisible(true);
		setFocusable(true);
		requestFocus();
		
		this.setLayout(null);
		
		/*
		JLabel label;
		JLabel label2;
		
		label = new JLabel();
		label2 = new JLabel();
		
		label2.setBounds(50, 50, 100, 100);
		label2.setBackground(Color.red);
		label2.setOpaque(true);
		label2.addMouseListener(new JField(label2, null));
		
		label.setBounds(0, 0, 200, 200);
		label.setBackground(Color.blue);
		label.setOpaque(true);
		label.addMouseListener(new JField(label, null));
		

		//label2.isOptimizedDrawingEnabled()
		
		
		this.add(label2);
		this.add(label);
		//setComponentZOrder(label, 1);
		//setComponentZOrder(label2, 0);
		this.setVisible(true);
		
		*/
	}
	
	JLabel label;
	JLabel label2;
	public void drawShit() {

		
		//add(getPanel());
		//setTitle("Világtalan Virológusok");
		//pack();
		//setLocationRelativeTo(null);
		setResizable(false);
		//addKeyListener(controls);
		//setVisible(true);
		//setFocusable(true);
		//requestFocus();
		
		this.setLayout(null);
		
		

		//label2.isOptimizedDrawingEnabled()
		
		
		this.add(label2);
		this.add(label);
		//setComponentZOrder(label, 1);
		//setComponentZOrder(label2, 0);
		this.setVisible(true);
		
		
		
	}
	
	public void prepareShit() {

		
		label = new JLabel();
		label2 = new JLabel();
		
		label2.setBounds(50, 50, 100, 100);
		label2.setBackground(Color.red);
		label2.setOpaque(true);
		label2.addMouseListener(new JField(label2, null));
		
		label.setBounds(0, 0, 200, 200);
		label.setBackground(Color.blue);
		label.setOpaque(true);
		label.addMouseListener(new JField(label, null));
		
	}
	
	public void drawLabels() {
		setResizable(false);
		this.setLayout(null);
		if(panel.getLabels().isEmpty())
			System.out.println("jej");
		for(JLabel l : panel.getLabels())
		{
			//l.setOpaque(true);
			this.add(l);
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

