package graphic;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import field.*;
import miscellaneous.*;

public class View {
	private static Position origo;
	private static ArrayList<Viewable> viewable;
	private static GamePanel gamepanel;
	
	public static void drawFieldInfo(Field f, Position p) {
		
	}
	
	public static void updteDraw() {
		
	}
	
	public static void drawVisible(Virologist v) {
		
	}
	
	public static void drawMap() {
		
	}
	
	public static void setOrigo(Position o) {
		origo = o;
	}
	
	public static void drawUI(Virologist v) {
		
	}
	
	public static void drawVirologist(Virologist v) {
		ImageIcon i = null;
		Position p = new Position(10,10);
		gamepanel.addLabel(p, i);
	}
	
	
}
