package graphic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A főmenüt megvalósító osztály
 */
public class MainMenu {
	
	/**
	 * Az ActionListener interfészt megvalósító osztály
	 */
	public class OkButtonActionListener implements ActionListener{
		
		/**
		 * OkButtonActionListener default konstruktora
		 */
		
		public OkButtonActionListener() {}
		
		/**
		 * Event handler, ami lereagálja az ActionEvent ae-n keresztül lehallgatott eseményeket
		 * @param ae, amit a listener elkap, erre reagálhat a metódus
		 */
		
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("start_game")) 
			{
				GameSetup gamesetup = new GameSetup();
			}
			
			f.dispose();
		}
	}

	public JFrame f = new JFrame("Világtalan Virológusok");
	private JPanel p = new JPanel();
	private JButton b_start_game = new JButton("START GAME");
	private JButton b_exit = new JButton("EXIT");

	/**
	 * MainMenu default konstruktora, beállítja a főmenü szükséges paramétereit
	 */

	public MainMenu(){
		f.setSize(400,220);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b_start_game.setActionCommand("start_game");
		b_exit.setActionCommand("exit");
		ActionListener al = new OkButtonActionListener();
		b_start_game.addActionListener(al);
		b_exit.addActionListener(al);
		p.setLayout(new BorderLayout(50, 50));
		p.add(b_start_game, BorderLayout.NORTH);
		p.add(b_exit, BorderLayout.SOUTH);
		f.add(p);
		f.setVisible(true);
		f.setFocusable(true);
		f.requestFocus();
	}
}

