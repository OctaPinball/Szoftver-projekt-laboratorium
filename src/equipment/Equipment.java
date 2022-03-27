package equipment;

import java.util.ArrayList;

import field.Field;
import miscellaneous.Logger;
import miscellaneous.Virologist;

public abstract class Equipment {

    protected Virologist wearer;
    private Field currentField;

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

    public void dropEquipment(){

        Logger.enter(this, "dropEquipment", null);

        if(currentField.spawnEquipment(this)) {
            wearer.loseEquipment(this);
            this.loseEffect();
        }
        wearer.loseEquipment(this);

        Logger.exit(this, "dropEquipment", null);

    }

    protected abstract void getEffect();

    protected abstract void loseEffect();

}