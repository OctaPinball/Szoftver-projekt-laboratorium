package field;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import miscellaneous.*;
import equipment.*;
import graphic.Position;
import graphic.View;
import graphic.Viewable;

/**
 * Egy mez�t reprezent�l a j�t�kban, ez az �soszt�ly ebb�l sz�rmaznak le a k�l�nb�z� mez� t�pusok
 * l�tezik sima mez� is, �gy p�ld�nyos�that� az oszt�ly, a mez�k�n kereszt�l mozoghatnak a p�ly�n a virol�gusok
 * egyszerre egy mez�n csak egy virol�gus tart�zkodhat, valamint egy felszerel�s is ledobhat� a mez�re.
 * A mez�k ismerik a szomsz�dos mez�ket, ezeket egy t�mbben t�rolj�k.
 */

public class Field implements Viewable{
	
	protected int id;
	protected Position pos;
	protected Virologist virologistOnField;
	protected Equipment equipmentOnField = null;

	protected ArrayList<Field> neighbors;
	
	ImageIcon field = new ImageIcon("res/Field_1.png");
	ImageIcon darkField = new ImageIcon("res/Field_1_dark.png");

	/**
	 * A Field oszt�ly konstruktora, ter�letet foglal a mez� szomsz�dainak
	 */
	public Field(int id, int x, int y) {
		neighbors = new ArrayList<Field>();
		this.id = id;
		pos = new Position(x, y);
	}

	/**
	 * Hozz�adja a param�terk�nt kapott virol�gust a mez�h�z.
	 * @param virologist a virol�gus akit hozz� kell adni a mez�h�z
	 */
	public void addVirologist(Virologist virologist) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "addVirologist", par);
		
		
		virologistOnField = virologist;
		
		
		Logger.exit(this, "addVirologist", null);
	}

	/**
	 * Leveszi a mez�r�l a virol�gust, amelyik �ppen rajta �ll.
	 */
	public void removeVirologist() {
		Logger.enter(this, "removeVirologist", null);
		
		
		virologistOnField = null;
		
		
		Logger.exit(this, "removeVirologist", null);
	}

	/**
	 * Hozz�adja a param�terk�nt kapott felszerel�st a mez�h�z, ha m�g a mez�n nincsen semmilyen felszerel�s.
	 * @param newEquipment	a felszerel�s amit hozz� kell adni a mez�h�z
	 * @return				ha a hozz�ad�s sikeres volt igaz, ellenkez� esetben hamis a visszat�r�si �rt�k
	 */
	public boolean spawnEquipment(Equipment newEquipment) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(newEquipment);
		Logger.enter(this, "spawnEquipment", par);
		
		boolean canDrop = false;
		if(equipmentOnField == null) {
			equipmentOnField = newEquipment;
			newEquipment.setCurrentField(this);
			canDrop = true;
		}
		
		Logger.exit(this, "spawnEquipment", canDrop);
		return canDrop;
	}

	/**
	 * Leveszi a mez�r�l a felszerel�st.
	 */
	public void removeEquipment() {
		Logger.enter(this, "removeEquipment", null);
		
		
		equipmentOnField = null;
		
		
		Logger.exit(this, "removeEquipment", null);
	}
	
	/**
	 * Hozz�adja a szomsz�dok t�mbj�hez a param�terk�nt kapott mez�t
	 * @param neighbor	a mez�, amit hozz� kell adni a t�mbh�z
	 */
	public void addNeighbor(Field neighbor) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(neighbor);
		Logger.enter(this, "addNeighbor", par);
		
		neighbors.add(neighbor);
		
		Logger.exit(this, "addNeighbor", null);
	}
	
	/**
	 * A param�terk�nt megkapott mez� szomsz�dait elt�vol�tja.
	 * @param neighbor	a mez�, amit el kell t�vol�tani a t�mbb�l
	 */
	public boolean removeNeighbor(Field neighbor) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(neighbor);
		Logger.enter(this, "removeNeighbor", par);
		
		if(neighbors.remove(neighbor))
		{
			Logger.exit(this, "removeNeighbor", true);
			return true;
		}
		
		Logger.exit(this, "removeNeighbor", false);
		return false;
	}

	/**
	 * Akkor h�v�dik, ha egy virol�gus r�l�p a mez�re, ekkor tov�bbi f�ggv�nyh�v�sokon kereszt�l
	 * hozz�adja azt a mez�h�z �s a virol�gus jelenlegi poz�ci�j�t is friss�ti
	 * @param virologist		a mez�re l�p� virol�gus
	 * @throws IOException 
	 * @throws CloneNotSupportedException 
	 */
	public void stepOn(Virologist virologist) throws CloneNotSupportedException, IOException {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "stepOn", par);
		
		addVirologist(virologist);
		virologist.changeField(this);
		
		Logger.exit(this, "stepOn", null);
	}
	
	/**
	 * Visszaadja a mez�n l�v� felszerel�st
	 * @return		a mez�n l�v� felszerel�s, ha nincs rajta semmi, akkor null
	 */
	public Equipment getEquipment() {
		//Logger.enter(this, "getEquipment", null);
		
		//Logger.exit(this, "getEquipment", equipmentOnField);
		return equipmentOnField;
	}
	
	/**
	 * Visszaadja a mez� szomsz�dainak t�mbj�t
	 * @return		a mez� szomsz�dainak t�mbje
	 */
	public ArrayList<Field> getNeighbors(){
		return neighbors;
	}
	
	public Virologist getVirologist() {
		return virologistOnField;
	}
	
	public void copyStorage() {
		
	}
	
	public void destroy() {
		
	}

	public String toString() {
		return "name:\t\t" + Control.getName(this)
				+ "\ntype:\t\tfield"
				+ "\nvirologist:\t" + Control.getName(virologistOnField)
				+ "\nequipment:\t" + Control.getName(equipmentOnField);
	}
	
	public String printName() {
		return Control.getName(this);
	}
	
	public String nToString() {
		int n = this.neighbors.size();
		String[] string = null;
		int i = 0;
		for(Field f: neighbors) {
			string[i] = "Neighbor " + (i+1) + ": \t" + f.neighbors.get(i).printName() + "\n";
			i++;
		}
		return "name:\t " + Control.getName(this) + "\n" + string.toString();
	}
	
	public int getID() {
		return id;
	}
	
	public Position calculateCoordinates() {
		return pos;
	}

	public ImageIcon getIMG() {
		return field;
	}
	
	public ImageIcon getDarkIMG() {
		return darkField;
	}

	@Override
	public void pickDraw(View v) {
		v.drawField(this);
	}
}
