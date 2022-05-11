package equipment;

import java.util.ArrayList;

import field.Field;
import miscellaneous.Control;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * Egy felszerelést reprezentál a programban, ez az ősosztály, amelyből leszármaznak a különféle felszerelés típusok.
 * A játékos felveheti a felszerelést, és ezzel megszerzi a annak hatását, illetve el is dobhatja a felszerelést,
 * ami után elveszti annak hatását.
 */
public abstract class Equipment {

    /**
     * A felszerelés viselője
     */
    protected Virologist wearer = null;
    /**
     * A mező, amelyen a felszerelés található
     */
    private Field currentField = null;

    /**
     * A paraméterként kapott virológus felveszi az adott felszerelést, ha még nem érte el a maximális felszerelés kapacitást
     * @param v, a virológus aki felveszi a felszerelést
     */
    public void pickupEquipment(Virologist v){

        ArrayList<Object> par = new ArrayList<>();
        par.add(v);
        Logger.enter(this, "pickupEquipment", par);

        Virologist temp = wearer;
        wearer = v;
        
        if(v.addEquipment(this)) {
        	if(currentField != null)
        		currentField.removeEquipment();
        }
        else
        {
        	wearer = temp;
        }

        Logger.exit(this, "pickupEquipment", null);

    }

    /**
     * A virológus eldobja a felszerelést, arra a mezőre amin éppen áll, ezzel elveszítve az adott felszerelés hatását
     */
    public void dropEquipment(){

        Logger.enter(this, "dropEquipment", null);

        if(wearer.getField().spawnEquipment(this)) {
            wearer.loseEquipment(this);
            this.loseEffect();
        }
        //wearer.loseEquipment(this);

        Logger.exit(this, "dropEquipment", null);

    }
    
    public void setWearer(Virologist v) {
    	wearer = v;
    }

    /**
     * Aktiválja a felszerelés hatását.
     **/
    public abstract void getEffect();

    /**
     * Megszünteti a felszerelés hatását
     */
    public abstract void loseEffect();

    /**
     * Visszaadja a mezőt amelyen a felszerelés található
     * @return currentField
     */
    public Field getCurrentField() {
    	return currentField;
    }


    /**
     * Beállítja az új mezőt, amelyre a felszerelést ledobták
     * @param currentField, az új mező lesz a currentField
     */
    public void setCurrentField(Field currentField) {
    	this.currentField = currentField;
    }
    
    public void usedLife(){
    	
    }
    
    public String toString() {
		return "equipment\t\t" + Control.getName(this);
	}


}