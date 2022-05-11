package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import miscellaneous.*;

public class View {
	private Position origo;
	private ArrayList<Viewable> viewable;
	
	public void updteDraw() {
		
	}
	
	public void drawVisible(Virologist v) {
		
	}
	
	public void drawMap() {
		
	}
	
	public void setOrigo(Position o) {
		origo = o;
	}
	
	public void drawUI(Graphics g, Virologist v) {
		Graphics2D g2D = (Graphics2D)g;
		g2D.setPaint(Color.red);
		g2D.setFont(new Font("Arial", Font.BOLD, 16));
		g2D.drawString("Inventory", 40, 592);
		g2D.drawString("Agent", 194, 592);
		g2D.drawString("Active agent", 312, 592);
		g2D.drawString("Materials", 467, 592);
		g2D.drawLine(144, 576, 144, 768);
		g2D.drawLine(288, 576, 288, 768);
		g2D.drawLine(432, 576, 432, 768);
		
	}
	
	
	
	
}
