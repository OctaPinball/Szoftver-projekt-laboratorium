package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.ImageIcon;

import equipment.*;
import field.*;
import miscellaneous.*;
import movement.BearDance;

/**
 * A Const interfészt megvalósító, grafikus felület kezeléséért felelős singleton osztály. Tárolja az összes kirajzolható objektumot.
 */
public class View implements Const{
	private Position origo;
	private ArrayList<Viewable> viewable;
	private static GamePanel gamepanel;

	private HashMap<Class, ImageIcon> images;
	
	/**
	 * A View osztály default konstruktora.
	 * @param p, átveszi a GamePanel-t
	 */
	
	public View(GamePanel p) {
		gamepanel = p;
		images = new HashMap<Class, ImageIcon>();
		images.put(Axe.class, new ImageIcon("res/Axe.png"));
		images.put(Cape.class, new ImageIcon("res/Cape.png"));
		images.put(Glove.class, new ImageIcon("res/Glove.png"));
		images.put(Sack.class, new ImageIcon("res/Sack.png"));
	}
	
	/**
	 * Frissítí a kirajzolást.
	 */
	
	public void updateDraw() {
		
	}
	
	/**
	 * A kirajzolás láthatóságát állítja.
	 * @param v, átveszi a virológust
	 */
	
	public void drawVisible(Virologist v) {
		
	}
	
	/**
	 * Kirajzolja a pályát a képernyőre.
	 */
	
	public void drawMap() {
		if(RoundManager.getEntity().getField() != null) {
			Position entityPos = RoundManager.getEntity().getField().getPosition();
			int diffX = ((PANEL_WIDH / 32) - 1) / 2;
			int diffY = ((MAP_HEIGHT / 32) - 1) / 2;
			for(Field f : Game.getAllFields())
				if(entityPos.getX() - diffX <= f.getPosition().getX() || f.getPosition().getX() <= entityPos.getX() + diffX)
					if(entityPos.getY() - diffY <= f.getPosition().getY() || f.getPosition().getY() <= entityPos.getY() + diffY)
						f.pickDraw(this);
		}
	}
	
	/**
	 * Beállítja a rajzolás origóját az átvett pozícióra.
	 * @param o, átveszi az origó pozícióját
	 */
	
	public void setOrigo(Position o) {
		origo = o;
	}
	
	/**
	 * Kiírja a képernyőre a felhasználói interfész elemeit (birtokolt felszerelések, megtanult/aktív ágensek, akciópontok, nyersanyag mennyiségek).
	 * @param g, a Graphics-ot veszi át
	 * @param v, a virológust veszi át
	 */
	
	public void drawUI(Graphics g, Virologist v) {
		Graphics2D g2D = (Graphics2D)g;
		g2D.setPaint(Color.black);
		g2D.setFont(new Font("Arial", Font.BOLD, 16));
		g2D.drawString("Inventory", 40, 624);
		g2D.drawString("Agent", 258, 624);
		g2D.drawString("Active agent", 453, 624);
		//g2D.drawString("Materials", 40, 824);
		g2D.drawString("Action Points: " + v.getActionPoint(), 40, 822);
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
				g2D.drawString("Amino acids: " + v.getAminoacid(), 242, 822);
				g2D.drawString("Nucleotids: " + v.getNucleotide(), 437, 822);
				
			}	
		}
	}
	
	/**
	 * Kirajzolja a paraméterként átvett mezőt a képernyőre.
	 * @param f, a kirajzolni kívánt Field
	 */
	
	public  void drawField(Field f) {
		
		ImageIcon i = new ImageIcon("res/Field_1_dark.png");
		
			
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++)
			{
				if(RoundManager.getEntity().getField().getNeighbors().get(k).PosEquals(f)) {
					if(RoundManager.getEntity().getField().getNeighbors().get(k).getVirologist() != null)
					{
						i = new ImageIcon("res/v_field_1.png");
						if(RoundManager.getEntity().getMovement().getClass() == BearDance.class)
							i = new ImageIcon("res/vb_field_1.png");
						gamepanel.addLabel(f, i);
						return;
					}
					i = new ImageIcon("res/Field_1.png");
				}
			}

		
		//Position p = f.calculateCoordinates();
		gamepanel.addLabel(f, i);
	}
	
	/**
	 * Kirajzolja a paraméterként átvett óvóhelyet a képernyőre.
	 * @param s, a kirajzolni kívánt Shelter
	 */
		
	public void drawShelter(Shelter s) {
			
		ImageIcon i = new ImageIcon("res/Field_2_dark.png");

		
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++) {
				
				if(RoundManager.getEntity().getField().getNeighbors().get(k).PosEquals(s)) {
					if(RoundManager.getEntity().getField().getNeighbors().get(k).getVirologist() != null)
					{
						i = new ImageIcon("res/v_field_2.png");
						if(RoundManager.getEntity().getMovement().getClass() == BearDance.class)
							i = new ImageIcon("res/vb_field_2.png");
						gamepanel.addLabel(s, i);
						return;
					}
					i = new ImageIcon("res/Field_2.png");
				}
			}
		
		Position p = s.calculateCoordinates();
		gamepanel.addLabel(s, i);
	}
	
	/**
	 * Kirajzolja a paraméterként átvett raktárat a képernyőre.
	 * @param s, a kirajzolni kívánt Storage
	 */
		
	public void drawStorage(Storage s) {
			
		ImageIcon i = new ImageIcon("res/Field_4_dark.png");
		
		
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++) {
				
				if(RoundManager.getEntity().getField().getNeighbors().get(k).PosEquals(s)) {
					if(RoundManager.getEntity().getField().getNeighbors().get(k).getVirologist() != null)
					{
						i = new ImageIcon("res/v_field_4.png");
						if(RoundManager.getEntity().getMovement().getClass() == BearDance.class)
							i = new ImageIcon("res/vb_field_4.png");
						gamepanel.addLabel(s, i);
						return;
					}
					i = new ImageIcon("res/Field_4.png");
				}
			}
		
		Position p = s.calculateCoordinates();
		gamepanel.addLabel(s, i);
	}
	
	/**
	 * Kirajzolja a paraméterként átvett laboratóriumot a képernyőre.
	 * @param l, a kirajzolni kívánt Laboratory
	 */
	
	public void drawLaboratory(Laboratory l) {
		ImageIcon i = new ImageIcon("res/Field_3_dark.png");
		

		
			for(int k = 0; k < RoundManager.getEntity().getField().getNeighbors().size(); k++) {
				
				if(RoundManager.getEntity().getField().getNeighbors().get(k).PosEquals(l)) {
					if(RoundManager.getEntity().getField().getNeighbors().get(k).getVirologist() != null)
					{
						i = new ImageIcon("res/v_field_3.png");
						if(RoundManager.getEntity().getMovement().getClass() == BearDance.class)
							i = new ImageIcon("res/vb_field_3.png");
						gamepanel.addLabel(l, i);
						return;
					}
					i = new ImageIcon("res/Field_3.png");
				}
			}
		
		Position p = l.calculateCoordinates();
		gamepanel.addLabel(l, i);
	}
	
	/**
	 * Kirajzolja a paraméterként átvett virológust a képernyőre.
	 * @param v, a kirajzolni kívánt virológus
	 */
		
	public void drawVirologist(Virologist v) {
		ImageIcon i = new ImageIcon("res/Virologist.png");	
		if(v.getField().getClass() == Field.class)
			if(v.getMovement().getClass() == BearDance.class)
				i = new ImageIcon("res/vb_field_1.png");
			else
				i = new ImageIcon("res/v_field_1.png");
		if(v.getField().getClass() == Shelter.class)
			if(v.getMovement().getClass() == BearDance.class)
				i = new ImageIcon("res/vb_field_2.png");
			else
				i = new ImageIcon("res/v_field_2.png");
		if(v.getField().getClass() == Laboratory.class)
			if(v.getMovement().getClass() == BearDance.class)
				i = new ImageIcon("res/vb_field_3.png");
			else
				i = new ImageIcon("res/v_field_3.png");
		if(v.getField().getClass() == Storage.class)
			if(v.getMovement().getClass() == BearDance.class)
				i = new ImageIcon("res/vb_field_4.png");
			else
				i = new ImageIcon("res/v_field_4.png");
		Position p = v.calculateCoordinates();
		gamepanel.addLabel(v.getField(), i);
	}
	
	/**
	 * Kirajzolja a paraméterként átvett eszközt a képernyőre.
	 * @param e, a kirajzolni kívánt eszköz
	 */
	
	public void drawEquipment(Equipment e) {
		ImageIcon i = null;
		Position p = e.calculateCoordinates();
		gamepanel.addLabel(e.getCurrentField(), i);
	}
	
	/**
	 * Kirajzolja a paraméterként átvett zsákot a képernyőre.
	 * @param s, a kirajzolni kívánt zsák
	 */
	
	public void drawSack(Sack s) {
		ImageIcon i = new ImageIcon("res/Sack.png");
		Position p = s.calculateCoordinates();
		gamepanel.addLabel(s.getCurrentField(), i);
	}
	
	/**
	 * Kirajzolja a paraméterként átvett fejszét a képernyőre.
	 * @param a, a kirajzolni kívánt fejsze
	 */
	
	public void drawAxe(Axe a) {
		ImageIcon i = a.getIMG();
		Position p = a.calculateCoordinates();
		gamepanel.addLabel(a.getCurrentField(), i);
	}
	
	/**
	 * Kirajzolja a paraméterként átvett köpenyt a képernyőre.
	 * @param c, a kirajzolni kívánt köpeny
	 */
	
	public void drawCape(Cape c) {
		ImageIcon i = c.getIMG();
		Position p = c.calculateCoordinates();
		gamepanel.addLabel(c.getCurrentField(), i);
	}
	
	/**
	 * Kirajzolja a paraméterként átvett kesztyűt a képernyőre.
	 * @param g, a kirajzolni kívánt kesztyű
	 */
	
	public void drawGlove(Glove g) {
		ImageIcon i = g.getIMG();
		Position p = g.calculateCoordinates();
		gamepanel.addLabel(g.getCurrentField(), i);
	}
	
	/**
	 * Visszatér a gamepanel értékével
	 * return GamePanel, a gamepanel értéke
	 */
	
	public GamePanel getGamepanel() {
		return gamepanel;
	}

}
