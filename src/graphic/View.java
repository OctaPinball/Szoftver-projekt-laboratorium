package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import equipment.*;
import field.*;
import miscellaneous.*;

public class View {
	private Position origo;
	private ArrayList<Viewable> viewable;
	private static GamePanel gamepanel;
	
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
//		Graphics2D g2D = (Graphics2D)g;
//		g2D.setPaint(Color.red);
//		g2D.setFont(new Font("Arial", Font.BOLD, 16));
//		g2D.drawString("Inventory", 40, 592);
//		g2D.drawString("Agent", 194, 592);
//		g2D.drawString("Active agent", 312, 592);
//		g2D.drawString("Materials", 467, 592);
//		g2D.drawLine(144, 576, 144, 768);
//		g2D.drawLine(288, 576, 288, 768);
//		g2D.drawLine(432, 576, 432, 768);
//		
//		for(int i = 0; i < v.getEquipments().size(); i++) {
//			
//			g2D.drawString(v.getEquipments().get(i).toString(), 40, 592 + 32 * (i+1));
//		}
		
	}
	
		public static void drawField(Field f) {
		ImageIcon i = null;
		Position p = f.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
		
		public static void drawShelter(Shelter s) {
		ImageIcon i = null;
		Position p = s.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
		
		public static void drawStorage(Storage s) {
		ImageIcon i = null;
		Position p = s.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
		public static void drawLaboratory(Laboratory l) {
		ImageIcon i = null;
		Position p = l.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
		
	public static void drawVirologist(Virologist v) {
		ImageIcon i = null;
		Position p = v.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawEquipment(Equipment e) {
		ImageIcon i = null;
		Position p = e.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawSack(Sack s) {
		ImageIcon i = null;
		Position p = s.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawAxe(Axe a) {
		ImageIcon i = null;
		Position p = a.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawCape(Cape c) {
		ImageIcon i = null;
		Position p = c.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawGlove(Glove g) {
		ImageIcon i = null;
		Position p = g.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
}
