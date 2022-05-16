package field;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import graphic.View;
import miscellaneous.*;

/**
 * A Field oszt�ly lesz�rmazottja, az ilyen t�pus� mez�kre l�pve tudj�k a virol�gusok felt�lteni k�szleteiket.
 */
public class Storage extends Field{
	
	ImageIcon storage = new ImageIcon("res/Field_4.png");
	ImageIcon darkStorage = new ImageIcon("res/Field_4_dark.png");
	
	public Storage(int id, int x, int y) {
		super(id, x, y);
	}

	/**
	 * A Field oszt�ly stepOn f�ggv�ny�t kieg�sz�ti, azzal hogy felt�lti a virol�gus �sszes nyersanyag k�szlet�t
	 * @param virologist		a mez�re l�p� virol�gus
	 * @throws IOException 
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public void stepOn(Virologist virologist) throws CloneNotSupportedException, IOException {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "stepOn", par);
		
		
		super.stepOn(virologist);
		virologist.getFillMaterial().fillMaterial(virologist);
		
		
		Logger.exit(this, "stepOn", null);
	}
	
	/**
	 * Lem�solja Field-k�nt a Storage oszt�lyon h�vott p�ld�nyt, lem�solja az �sszes �truh�zhat� attrib�tum�t
	 */
	public void copyStorage() {
		Logger.enter(this, "copyStorage", null);
		
		Field copyField = new Field(this.getID(), pos.getX(), pos.getY());
		copyField.neighbors.addAll(neighbors);
		
		for(int i = 0; i < neighbors.size(); i++) {
			neighbors.get(i).addNeighbor(copyField);
		}	
		copyField.addVirologist(virologistOnField);
		copyField.spawnEquipment(equipmentOnField);
		
		this.destroy();
		
		Logger.exit(this, "copyStorage", null);
	}
	
	/**
	 * Megsz�nteti a mez� l�tez�s�t, a megfelel� kapcsolatok elv�g�s�val
	 */
	public void destroy() {
		Logger.enter(this, "destroy", null);
		
		for(int i = 0; i < neighbors.size(); i++) {
			neighbors.get(i).removeNeighbor(this);
		}	
		this.removeEquipment();
		this.removeVirologist();
		
		Logger.exit(this, "destroy", null);
	}
	
	/**
	 * Visszaadja stringk�nt a mez�n tart�zkod� virol�gust, 
	 * felszerel�st �s a mez� t�pus�t
	 * @return		az eml�tett adatok stringk�nt
	 */
	public String toString() {
		return "name:\t\t" + Control.getName(this)
		+ "\ntype:\t\tstorage"
		+ "\nvirologist:\t" + Control.getName(virologistOnField)
		+ "\nequipment:\t" + Control.getName(equipmentOnField);
	}
	
	/**
	 * Visszaadja a vil�gos rakt�r mez� k�p�t
	 * @return		vil�gos rakt�r ImageIcon-ja
	 */
	public ImageIcon getIMG() {
		return storage;
	}
	
	/**
	 * Visszaadja a s�t�t mez� k�p�t
	 * @return		s�t�t mez� ImageIcon-ja
	 */
	public ImageIcon getDarkIMG() {
		return darkStorage;
	}

	/**
     *  Kiv�lasztja az storage-hez sz�ks�ges rajzol�st
     */
	@Override
	public void pickDraw(View v) {
		v.drawStorage(this);
	}
}
