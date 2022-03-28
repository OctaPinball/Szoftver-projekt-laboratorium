package equipment;

import fillmaterial.*;

/**
 * Egy olyan felszerelést reprezentál a programban, amelyet ha felvesz egy játékos,
 * akkor megkapja a IncreasedMatter effektust, amely megnöveli a virológus maximális anyag kapacitását.
 */
public class Sack extends Equipment{

    /**
     * Aktiválja a IncreasedMatter hatást a virológuson
     */
    public void getEffect(){
        wearer.setFillMaterial(new IncreasedMatter());
    }

    /**
     *  Deaktiválja a IncreasedMatter hatást a virológuson, visszaállítja a NormalMatter hatást
     */
    public void loseEffect(){
        wearer.setFillMaterial(new NormalMatter());
    }
}
