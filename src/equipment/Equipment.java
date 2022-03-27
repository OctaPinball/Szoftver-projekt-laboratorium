package equipment;

import field.Field;
import miscellaneous.Virologist;

public abstract class Equipment {

    protected Virologist wearer;
    private Field currentField;

    public void pickupEquipment(Virologist v){
        if(v.addEquipment(this)) {
            wearer = v;
            this.getEffect();
            currentField.removeEquipment(this);
        }
    }

    public void dropEquipment(){
        if(currentField.spawnEquipment(this)) {
            wearer.loseEquipment(this);
            this.loseEffect();
        }
        wearer.loseEquipment(this);
    }

    protected abstract void getEffect();

    protected abstract void loseEffect();

}