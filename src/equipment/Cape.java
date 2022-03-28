package equipment;

import block.*;
import miscellaneous.Logger;

/**
 * Egy olyan felszerelést reprezentál a programban, amelyet ha felvesz egy játékos,
 * akkor megkapja a PartialBlock tulajdonságot, amely 82,3%-os védelmet nyújt minden vírus ellen.
 */
public class Cape extends Equipment{

    /**
     * Aktiválja a PartialBlock hatást a virológuson
     */
    public void getEffect(){

        Logger.enter(this, "getEffect", null);

        wearer.setBlock(new PartialBlock());
        Logger.register(wearer.getBlock(), "pb");

        Logger.exit(this, "getEffect", null);

    }

    /**
     *  Deaktiválja a PartialBlock hatást a virológuson, visszaállítja a NoBlock hatást
     */
    public void loseEffect(){

        Logger.enter(this, "loseEffect", null);

        wearer.setBlock(new NoBlock());

        Logger.exit(this, "loseEffect", null);

    }
}
