package equipment;

import block.PartialBlock;
import fillmaterial.*;
import miscellaneous.Logger;

/**
 * Egy olyan felszerelést reprezentál a programban, amelyet ha felvesz egy játékos,
 * akkor megkapja a IncreasedMatter effektust, amely megnöveli a virológus maximális anyag kapacitását.
 */
public class Sack extends Equipment{

    /**
     * Aktiválja a IncreasedMatter hatást a virológuson
     */
    public void getEffect(){

        Logger.enter(this, "getEffect", null);

        wearer.setFillMaterial(new IncreasedMatter());

        Logger.exit(this, "getEffect", null);

    }

    /**
     *  Deaktiválja a IncreasedMatter hatást a virológuson, visszaállítja a NormalMatter hatást
     */
    public void loseEffect(){

        Logger.enter(this, "loseEffect", null);

        wearer.setFillMaterial(new NormalMatter());

        Logger.exit(this, "loseEffect", null);

    }
}
