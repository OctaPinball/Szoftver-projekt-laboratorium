package equipment;

import block.*;

/**
 * Egy olyan felszerelést reprezentál a programban, amelyet ha felvesz egy játékos,
 * akkor megkapja a PartialBlock tulajdonságot, amely 82,3%-os védelmet nyújt minden vírus ellen.
 */
public class Cape extends Equipment{

    /**
     * Aktiválja a PartialBlock hatást a virológuson
     */
    public void getEffect(){
        wearer.setBlock(new PartialBlock());
    }

    /**
     *  Deaktiválja a PartialBlock hatást a virológuson, visszaállítja a NoBlock hatást
     */
    public void loseEffect(){
        wearer.setBlock(new NoBlock());
    }
}
