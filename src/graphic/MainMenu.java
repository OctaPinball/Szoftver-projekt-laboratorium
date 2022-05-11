package graphic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MainMenu {
	public class OkButtonActionListener implements ActionListener{
		public OkButtonActionListener() {}
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("start_game")) 
			{
				//GameFrame gameFrame = new GameFrame();
				GameSetup gamesetup = new GameSetup();
				//mainFrame.getPanel().initLevel();
			}
			if (ae.getActionCommand().equals("leaderboard")) 
			{
				//Leaderboard leaderboard = new Leaderboard();
				//leaderboard.openLeaderboard();
			}
			f.dispose();
		}
	}


	public JFrame f = new JFrame("Vil�gtalan Virol�gusok");
	private JPanel p = new JPanel();
	private JButton b_start_game = new JButton("START GAME");
	private JButton b_exit = new JButton("EXIT");
	private JButton b_leaderboard = new JButton("LEADERBOARD");


	
	public MainMenu(){
		f.setSize(400,220);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b_start_game.setActionCommand("start_game");
		b_leaderboard.setActionCommand("leaderboard");
		b_exit.setActionCommand("exit");
		ActionListener al = new OkButtonActionListener();
		b_start_game.addActionListener(al);
		b_leaderboard.addActionListener(al);
		b_exit.addActionListener(al);
		p.setLayout(new BorderLayout(50, 50));
		p.add(b_start_game, BorderLayout.NORTH);
		p.add(b_leaderboard, BorderLayout.CENTER);
		p.add(b_exit, BorderLayout.SOUTH);
		f.add(p);
		f.setVisible(true);
		f.setFocusable(true);
		f.requestFocus();
	}
}

