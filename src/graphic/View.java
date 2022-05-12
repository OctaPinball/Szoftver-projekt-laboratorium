package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

import equipment.*;
import field.*;
import miscellaneous.*;

public class View implements Const{
	private Position origo;
	private ArrayList<Viewable> viewable;
	private static GamePanel gamepanel;
	private static HashMap<Class, ImageIcon> images;
	
	static {
		images.put(Axe.class, new ImageIcon("res/Axe.png"));
		images.put(Cape.class, new ImageIcon("res/Cape.png"));
		images.put(Glove.class, new ImageIcon("res/Glove.png"));
		images.put(Sack.class, new ImageIcon("res/Sack.png"));
	}
	
	public void updteDraw() {
		
	}
	
	public void drawVisible(Virologist v) {
		
	}
	
	public void drawMap() {
		Position entityPos = RoundManager.getEntity().getField().getPos();
		int diffX = ((PANEL_WIDH / 32) - 1) / 2;
		int diffY = ((PANEL_HEIGH / 32) - 1) / 2;
		for(Field f : Game.getAllFields())
			if(entityPos.getX() - diffX <= f.getPos().getX() || f.getPos().getX() <= entityPos.getX() + diffX)
				if(entityPos.getY() - diffY <= f.getPos().getY() || f.getPos().getY() <= entityPos.getY() + diffY)
					f.pickDraw(this);
	}
	
	public void setOrigo(Position o) {
		origo = o;
	}
	
	public void drawUI(Graphics g, Virologist v) {
		Graphics2D g2D = (Graphics2D)g;
		g2D.setPaint(Color.black);
		g2D.setFont(new Font("Arial", Font.BOLD, 16));
		g2D.drawString("Inventory", 40, 624);
		g2D.drawString("Agent", 258, 624);
		g2D.drawString("Active agent", 453, 624);
		//g2D.drawString("Materials", 40, 824);
		g2D.drawString("Action Points: " + v.getActionPoint(), 40, 824);
		g2D.drawLine(170, 608, 170, 800);
		g2D.drawLine(389, 608, 389, 800);
		g2D.drawLine(0, 800, 608, 800);
		//g2D.drawLine(432, 608, 432, 800);
		
		if(v != null) {
			if(v.getEquipments() != null) {
				for(int i = 0; i < v.getEquipments().size(); i++) {
					g2D.drawString(v.getEquipments().get(i).toString(), 64, 624 + 32 * (i+1));
					g2D.drawImage(images.get(v.getEquipments().get(i).getClass()).getImage(), 16, 624 + 10 + 32 * (i), null);
					
				}
			}
			
			if(v.getAgents() != null) {
				for(int i = 0; i < v.getAgents().size(); i++) {
					g2D.drawString(v.getAgents().get(i).toString(), 234, 624 + 32 * (i+1));
					//g2D.drawImage(v, 40, 592 + 32 * (i+2), null);
				}
			}
			
			if(v.getActiveAgents() != null) {
				for(int i = 0; i < v.getActiveAgents().size(); i++) {
					g2D.drawString(v.getActiveAgents().get(i).toString(), 453, 624 + 32 * (i+1));
					//g2D.drawImage(v, 40, 592 + 32 * (i+2), null);
				}
			}
			
			if(v.getFillMaterial() != null) {
				g2D.drawString("Amino acids: " + v.getAminoacid(), 242, 824);
				g2D.drawString("Nucleotids: " + v.getNucleotide(), 437, 824);
				
			}	
		}
		
		
		
	}
	
	public static void drawField(Field f) {
		
		ImageIcon i = null;	
			
		for(int l = 0; l < f.getNeighbors().size(); l++) {
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++) {
				
				if(RoundManager.getEntity().getField().getNeighbors().get(k).equals(f.getNeighbors().get(l))) {
					i = new ImageIcon("res/Field_1.png");
				}
				else {
					i = new ImageIcon("res/Field_1_dark.png");
				}
			}
		}
		
		Position p = f.getPos();
		gamepanel.addLabel(p, i);
	}
		
	public static void drawShelter(Shelter s) {
			
		ImageIcon i = null;
		
		for(int l = 0; l < s.getNeighbors().size(); l++) {
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++) {
				
				if(RoundManager.getEntity().getField().getNeighbors().get(k).equals(s.getNeighbors().get(l))) {
					i = new ImageIcon("res/Field_2.png");
				}
				else {
					i = new ImageIcon("res/Field_2_dark.png");
				}
			}
		}
		
		Position p = s.getPos();
		gamepanel.addLabel(p, i);
	}
		
	public static void drawStorage(Storage s) {
			
		ImageIcon i = null;
		
		for(int l = 0; l < s.getNeighbors().size(); l++) {
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++) {
				
				if(RoundManager.getEntity().getField().getNeighbors().get(k).equals(s.getNeighbors().get(l))) {
					i = new ImageIcon("res/Field_4.png");
				}
				else {
					i = new ImageIcon("res/Field_4_dark.png");
				}
			}
		}
		
		Position p = s.getPos();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawLaboratory(Laboratory l) {
		ImageIcon i = null;
		
		for(int n = 0; n < l.getNeighbors().size(); n++) {
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++) {
				
				if(RoundManager.getEntity().getField().getNeighbors().get(k).equals(l.getNeighbors().get(n))) {
					i = new ImageIcon("res/Field_3.png");
				}
				else {
					i = new ImageIcon("res/Field_3_dark.png");
				}
			}
		}
		
		Position p = l.getPos();
		gamepanel.addLabel(p, i);
	}
		
	public static void drawVirologist(Virologist v) {
		ImageIcon i = v.getIMG();
		Position p = v.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawEquipment(Equipment e) {
		ImageIcon i = e.getIMG();
		Position p = e.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawSack(Sack s) {
		ImageIcon i = s.getIMG();
		Position p = s.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawAxe(Axe a) {
		ImageIcon i = a.getIMG();
		Position p = a.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawCape(Cape c) {
		ImageIcon i = c.getIMG();
		Position p = c.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawGlove(Glove g) {
		ImageIcon i = g.getIMG();
		Position p = g.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
}
