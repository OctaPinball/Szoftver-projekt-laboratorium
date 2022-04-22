package field;

import java.util.ArrayList;
import miscellaneous.*;
import equipment.*;

/**
 * Egy mezõt reprezentál a játékban, ez az õsosztály ebbõl származnak le a különbözõ mezõ típusok
 * létezik sima mezõ is, így példányosítható az osztály, a mezõkön keresztül mozoghatnak a pályán a virológusok
 * egyszerre egy mezõn csak egy virológus tartózkodhat, valamint egy felszerelés is ledobható a mezõre.
 * A mezõk ismerik a szomszédos mezõket, ezeket egy tömbben tárolják.
 */

public class Field {
	
	protected Virologist virologistOnField;
	protected Equipment equipmentOnField;

	protected ArrayList<Field> neighbors;

	/**
	 * A Field osztály konstruktora, területet foglal a mezõ szomszédainak
	 */
	public Field() {
		neighbors = new ArrayList<Field>();
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
	 */
	public void stepOn(Virologist virologist) {
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
	
	public String toString() {
		return "name:\t " + Control.getName(this)
				+ "type:\t field"
				+ "virologist:\t " + Control.getName(virologistOnField)
				+ "equipment" + Control.getName(equipmentOnField);
	}
}
