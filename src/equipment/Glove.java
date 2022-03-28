package equipment;

import block.*;

/**
 * Egy olyan felszerelést reprezentál a programban, amelyet ha felvesz egy játékos, akkor megkapja a BlockAndReturn tulajdonságot,
 * amely megvédi a virológust bármilyen vírustól, és azt vissza is dobja a támadójára.
 */
public class Glove extends Equipment{

    /**
     * Aktiválja a BlockAndReturn hatást a virológuson
     */
    public void getEffect(){
        wearer.setBlock(new BlockAndReturn());
    }

    /**
     *  Deaktiválja a BlockAndReturn hatást a virológuson, visszaállítja a NoBlock hatást
     */
    public void loseEffect(){
        wearer.setBlock(new NoBlock());
    }
}
