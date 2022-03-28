package equipment;

import field.Field;
import miscellaneous.Virologist;

public abstract class Equipment {

    protected Virologist wearer;
    private Field currentField;

    /**
     * A paraméterként kapott virológus felveszi az adott felszerelést, ha még nem érte el a maximális felszerelés kapacitást
     * @param v a virológus aki felveszi a felszerelést
     */
    public void pickupEquipment(Virologist v){
        if(v.addEquipment(this)) {
            wearer = v;
            this.getEffect();
            currentField.removeEquipment();
        }
    }

    /**
     * A virológus eldobja a felszerelést, arra a mezőre amin éppen áll, ezzel elveszítve az adott felszerelés hatását
     */
    public void dropEquipment(){
        if(currentField.spawnEquipment(this)) {
            wearer.loseEquipment(this);
            this.loseEffect();
        }
        wearer.loseEquipment(this);
    }

    protected abstract void getEffect();

    protected abstract void loseEffect();

    public Field getCurrentField() {
    	return currentField;
    }

    public void setCurrentField(Field currentField) {
    	this.currentField = currentField;
    }

}