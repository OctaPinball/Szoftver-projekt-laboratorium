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
 * Egy mezõt reprezentál a játékban, ez az õsosztály ebbõl származnak le a különbözõ mezõ típusok
 * létezik sima mezõ is, így példányosítható az osztály, a mezõkön keresztül mozoghatnak a pályán a virológusok
 * egyszerre egy mezõn csak egy virológus tartózkodhat, valamint egy felszerelés is ledobható a mezõre.
 * A mezõk ismerik a szomszédos mezõket, ezeket egy tömbben tárolják.
 */

public class Field implements Viewable, Const{
	
	protected int id;
	protected Position pos;
	protected Virologist virologistOnField;
	protected Equipment equipmentOnField = null;

	protected ArrayList<Field> neighbors;
	
	ImageIcon field = new ImageIcon("res/Field_1.png");
	ImageIcon darkField = new ImageIcon("res/Field_1_dark.png");

	/**
	 * A Field osztály konstruktora, területet foglal a mezõ szomszédainak
	 */
	public Field(int id, int x, int y) {
		neighbors = new ArrayList<Field>();
		this.id = id;
		pos = new Position(x, y);
	}

	/**
	 * Hozzáadja a paraméterként kapott virológust a mezõhöz.
	 * @param virologist a virológus akit hozzá kell adni a mezõhöz
	 */
	public void addVirologist(Virologist virologist) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "addVirologist", par);
		
		
		virologistOnField = virologist;
		
		
		Logger.exit(this, "addVirologist", null);
	}

	/**
	 * Leveszi a mezõrõl a virológust, amelyik éppen rajta áll.
	 */
	public void removeVirologist() {
		Logger.enter(this, "removeVirologist", null);
		
		
		virologistOnField = null;
		
		
		Logger.exit(this, "removeVirologist", null);
	}

	/**
	 * Hozzáadja a paraméterként kapott felszerelést a mezõhöz, ha még a mezõn nincsen semmilyen felszerelés.
	 * @param newEquipment	a felszerelés amit hozzá kell adni a mezõhöz
	 * @return				ha a hozzáadás sikeres volt igaz, ellenkezõ esetben hamis a visszatérési érték
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
	 * Leveszi a mezõrõl a felszerelést.
	 */
	public void removeEquipment() {
		Logger.enter(this, "removeEquipment", null);
		
		
		equipmentOnField = null;
		
		
		Logger.exit(this, "removeEquipment", null);
	}
	
	/**
	 * Hozzáadja a szomszédok tömbjéhez a paraméterként kapott mezõt
	 * @param neighbor	a mezõ, amit hozzá kell adni a tömbhöz
	 */
	public void addNeighbor(Field neighbor) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(neighbor);
		Logger.enter(this, "addNeighbor", par);
		
		neighbors.add(neighbor);
		
		Logger.exit(this, "addNeighbor", null);
	}
	
	/**
	 * A paraméterként megkapott mezõ szomszédait eltávolítja.
	 * @param neighbor	a mezõ, amit el kell távolítani a tömbbõl
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
	 * Akkor hívódik, ha egy virológus rálép a mezõre, ekkor további függvényhívásokon keresztül
	 * hozzáadja azt a mezõhöz és a virológus jelenlegi pozícióját is frissíti
	 * @param virologist		a mezõre lépõ virológus
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
	 * Visszaadja a mezõn lévõ felszerelést
	 * @return		a mezõn lévõ felszerelés, ha nincs rajta semmi, akkor null
	 */
	public Equipment getEquipment() {
		//Logger.enter(this, "getEquipment", null);
		
		//Logger.exit(this, "getEquipment", equipmentOnField);
		return equipmentOnField;
	}
	
	/**
	 * Visszaadja a mezõ szomszédainak tömbjét
	 * @return		a mezõ szomszédainak tömbje
	 */
	public ArrayList<Field> getNeighbors(){
		return neighbors;
	}
	
	/**
	 * Visszaadja a mezõn tartózkodó virológust
	 * @return		a mezõn tartózkodó virológus
	 */
	public Virologist getVirologist() {
		return virologistOnField;
	}
	
	public void copyStorage() {
		
	}
	
	public void destroy() {
		
	}

	/**
	 * Visszaadja stringként a mezõn tartózkodó virológust, 
	 * felszerelést és a mezõ típusát
	 * @return		az említett adatok stringként
	 */
	public String toString() {
		return "name:\t\t" + Control.getName(this)
				+ "\ntype:\t\tfield"
				+ "\nvirologist:\t" + Control.getName(virologistOnField)
				+ "\nequipment:\t" + Control.getName(equipmentOnField);
	}
	
	/**
	 * Visszaadja stringként a mezõt
	 * @return		a mezõ
	 */
	public String printName() {
		return Control.getName(this);
	}
	
	/**
	 * Visszaadja egy mezõ szomszédjait stringként
	 * @return		a mezõ szomszédai
	 */
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
	
	/**
	 * Visszaadja a mezõ azonosítóját
	 * @return		azonosító
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Kiszámolja egy mezõ x és y koordinátáit
	 * @return		a mezõ pozíciója
	 */
	public Position calculateCoordinates() {
		if(RoundManager.getEntity() != null && RoundManager.getEntity().getField() != null)
		{
			Position origo = RoundManager.getEntity().getField().getPosition();
			int deltaX = this.getPosition().getX() - origo.getX();
			int deltaY = this.getPosition().getY() - origo.getY();
			
			int relativeX = ((PANEL_WIDH / 2) - 16);
			int relativeY = ((MAP_HEIGHT / 2) - 16);
			
			return new Position(relativeX + deltaX * 32, relativeY + deltaY * 32);
			
		}
		return null;
	}

	/**
	 * Visszaadja a világos mezõ képét
	 * @return		világos mezõ ImageIcon-ja
	 */
	public ImageIcon getIMG() {
		return field;
	}
	
	/**
	 * Visszaadja a sötét mezõ képét
	 * @return		sötét mezõ ImageIcon-ja
	 */
	public ImageIcon getDarkIMG() {
		return darkField;
	}

	/**
	 * Visszaadja a mezõ pozícióját
	 * @return		pozíció
	 */
	public Position getPosition() {
		return pos;
	}
	
	/**
	 * Összehasinlítja a mezõ pozícióját egy paraméterben átvett másik mezõével
	 * @param 		a másik mezõ
	 * @return		igazzal vagy hamissal tér vissza
	 */
	public boolean PosEquals(Field f) {
		return this.getPosition().Equals(f.getPosition());
	}

	/**
     *  Kiválasztja az field-hez szükséges rajzolást
     */
	@Override
	public void pickDraw(View v) {
		v.drawField(this);
	}
}
