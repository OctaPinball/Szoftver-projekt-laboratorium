package field;

import java.util.ArrayList;
import miscellaneous.*;
import equipment.*;

/**
 * Egy mez�t reprezent�l a j�t�kban, ez az �soszt�ly ebb�l sz�rmaznak le a k�l�nb�z� mez� t�pusok
 * l�tezik sima mez� is, �gy p�ld�nyos�that� az oszt�ly, a mez�k�n kereszt�l mozoghatnak a p�ly�n a virol�gusok
 * egyszerre egy mez�n csak egy virol�gus tart�zkodhat, valamint egy felszerel�s is ledobhat� a mez�re.
 * A mez�k ismerik a szomsz�dos mez�ket, ezeket egy t�mbben t�rolj�k.
 */

public class Field {
	
	protected Virologist virologistOnField;
	protected Equipment equipmentOnField;

	protected ArrayList<Field> neighbors;

	/**
	 * A Field oszt�ly konstruktora, ter�letet foglal a mez� szomsz�dainak
	 */
	public Field() {
		neighbors = new ArrayList<Field>();
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
	
	public String toString() {
		return "name:\t " + Control.getName(this)
				+ "type:\t field"
				+ "virologist:\t " + Control.getName(virologistOnField)
				+ "equipment" + Control.getName(equipmentOnField);
	}
}
