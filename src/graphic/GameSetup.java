package graphic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miscellaneous.Control;
import miscellaneous.RoundManager;

public class GameSetup extends JFrame{

	public class OkButtonActionListener implements ActionListener{
		JTextField player;
		JTextField width;
		JTextField height;
		public OkButtonActionListener(JTextField player_in, JTextField width_in, JTextField height_in) {
			player = player_in;
			width = width_in;
			height = height_in;
		}
		
		public boolean isNumeric(String strNum) {
		    if (strNum == null) {
		        return false;
		    }
		    try {
		        int d = Integer.parseInt(strNum);
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		    return true;
		}
		
		public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("pushed")) {
			if(isNumeric(player.getText()) && Integer.parseInt(player.getText()) > 1)
			{
				int intplayernumber = Integer.parseInt(player.getText());
				if(isNumeric(width.getText()) && Integer.parseInt(width.getText()) > intplayernumber / 2 + 1)
				{
					int intwidth = Integer.parseInt(width.getText());
					if(isNumeric(height.getText()) && Integer.parseInt(height.getText()) > intplayernumber / 2 + 1)
					{
						int intheight = Integer.parseInt(height.getText());
						for(int i = 0; i < intplayernumber; i++)
						{
							int ID = i + 1;
							try {
								Control.runCommand("operator v Player_" + ID + " create"); //*****PARANCS
							} catch (CloneNotSupportedException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						try {
							Control.runCommand("operator g game generaterandommap " + intwidth + "x" + intheight); //*****PARANCS
						} catch (CloneNotSupportedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						GameFrame gameFrame = new GameFrame();
						RoundManager.nextRound();
					}
					else
					{
						height.setText("Invalid number!");
					}
				}
				else
				{
					width.setText("Invalid number!");
				}
			}
			else
			{
				player.setText("Invalid number!");
			}
		}
		}
	}
	


	private static final long serialVersionUID = 1L;
	public JFrame f = new JFrame("SwingLab");
	private JPanel p = new JPanel();
	private JButton b = new JButton("START GAME");
	//private JTextField playernumber = new JTextField("PlayerNumber");
	//private JTextField fieldwidth = new JTextField("MapWidth");
	//private JTextField fieldheight = new JTextField("MapHeight");
	private JTextField playernumber = new JTextField("2");
	private JTextField fieldwidth = new JTextField("20");
	private JTextField fieldheight = new JTextField("20");

	
	GameSetup(){
		

		
	    //f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setSize(400,150);
		f.setResizable(false);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fieldwidth.setEditable(true);
		fieldheight.setEditable(true);
		playernumber.setSize(20, 50);
		b.setActionCommand("pushed");
		ActionListener al = new OkButtonActionListener(playernumber, fieldwidth, fieldheight);
		b.addActionListener(al);
		p.setLayout(new BorderLayout(10, 20));
		p.add(playernumber, BorderLayout.SOUTH);
		p.add(b, BorderLayout.EAST);
		p.add(fieldwidth, BorderLayout.CENTER);
		p.add(fieldheight, BorderLayout.NORTH);
		f.add(p);
		f.setVisible(true);
		f.setFocusable(true);
		f.requestFocus();
		
	    addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(java.awt.event.WindowEvent e) {
	        	dispose();
				MainMenu mainmenu = new MainMenu();
				mainmenu.f.setVisible(true);
	        }
	    });
		
	}
	
}
