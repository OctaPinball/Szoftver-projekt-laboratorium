package equipment;

import block.*;

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
