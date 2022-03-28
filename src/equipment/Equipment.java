package equipment;

import java.util.ArrayList;

import field.Field;
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
    protected Virologist wearer;
    /**
     * A mező, amelyen a felszerelés található
     */
    private Field currentField;

    /**
     * A paraméterként kapott virológus felveszi az adott felszerelést, ha még nem érte el a maximális felszerelés kapacitást
     * @param v, a virológus aki felveszi a felszerelést
     */
    public void pickupEquipment(Virologist v){

        ArrayList<Object> par = new ArrayList<>();
        par.add(v);
        Logger.enter(this, "pickupEquipment", par);

        if(v.addEquipment(this)) {
            wearer = v;
            this.getEffect();
            currentField.removeEquipment();
        }

        Logger.exit(this, "pickupEquipment", null);

    }

    /**
     * A virológus eldobja a felszerelést, arra a mezőre amin éppen áll, ezzel elveszítve az adott felszerelés hatását
     */
    public void dropEquipment(){

        Logger.enter(this, "dropEquipment", null);

        if(currentField.spawnEquipment(this)) {
            wearer.loseEquipment(this);
            this.loseEffect();
        }
        wearer.loseEquipment(this);

        Logger.exit(this, "dropEquipment", null);

    }

    /**
     * Aktiválja a felszerelés hatását
     */
    protected abstract void getEffect();

    /**
     * Megszünteti a felszerelés hatását
     */
    protected abstract void loseEffect();

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

}