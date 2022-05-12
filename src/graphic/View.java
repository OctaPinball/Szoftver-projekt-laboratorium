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
		//if()
		RoundManager.getEntity().getField().getID();
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
		
		if(v != null) {
			if(v.getEquipments() != null) {
				for(int i = 0; i < v.getEquipments().size(); i++) {
					g2D.drawString(v.getEquipments().get(i).toString(), 40, 592 + 32 * (i+1));
					g2D.drawImage(v.getEquipments().get(i).getIMG().getImage(), 40, 592 + 32 * (i+2), null);
				}
			}
			
			if(v.getAgents() != null) {
				for(int i = 0; i < v.getAgents().size(); i++) {
					g2D.drawString(v.getAgents().get(i).toString(), 40, 592 + 32 * (i+1));
					//g2D.drawImage(v, 40, 592 + 32 * (i+2), null);
				}
			}
			
			if(v.getActiveAgents() != null) {
				for(int i = 0; i < v.getActiveAgents().size(); i++) {
					g2D.drawString(v.getActiveAgents().get(i).toString(), 40, 592 + 32 * (i+1));
					//g2D.drawImage(v, 40, 592 + 32 * (i+2), null);
				}
			}
			
			if(v.getFillMaterial() != null) {
				g2D.drawString("Nucleotids: " + v.getNucleotide(), 40, 592 + 32);
				g2D.drawString("Amino acids: : " + v.getAminoacid(), 40, 592 + 32*2);
			}	
		}
		
		
		
	}
	
	public static void drawField(Field f) {
		
		ImageIcon i = null;	
			
		for(int l = 0; l < f.getNeighbors().size(); l++) {
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++) {
				
				if(RoundManager.getEntity().getField().getNeighbors().get(k).equals(f.getNeighbors().get(l))) {
					i = f.getIMG();
				}
				else {
					i = f.getDarkIMG();
				}
			}
		}
		
		Position p = f.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
		
	public static void drawShelter(Shelter s) {
			
		ImageIcon i = null;
		
		for(int l = 0; l < s.getNeighbors().size(); l++) {
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++) {
				
				if(RoundManager.getEntity().getField().getNeighbors().get(k).equals(s.getNeighbors().get(l))) {
					i = s.getIMG();
				}
				else {
					i = s.getDarkIMG();
				}
			}
		}
		
		Position p = s.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
		
	public static void drawStorage(Storage s) {
			
		ImageIcon i = null;
		
		for(int l = 0; l < s.getNeighbors().size(); l++) {
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++) {
				
				if(RoundManager.getEntity().getField().getNeighbors().get(k).equals(s.getNeighbors().get(l))) {
					i = s.getIMG();
				}
				else {
					i = s.getDarkIMG();
				}
			}
		}
		
		Position p = s.calculateCoordinates();
		gamepanel.addLabel(p, i);
	}
	
	public static void drawLaboratory(Laboratory l) {
		ImageIcon i = null;
		
		for(int n = 0; n < l.getNeighbors().size(); n++) {
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++) {
				
				if(RoundManager.getEntity().getField().getNeighbors().get(k).equals(l.getNeighbors().get(n))) {
					i = l.getIMG();
				}
				else {
					i = l.getDarkIMG();
				}
			}
		}
		
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