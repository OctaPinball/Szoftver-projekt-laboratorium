package equipment;

import block.*;

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
