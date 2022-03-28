package equipment;

import block.*;
import miscellaneous.Logger;

public class Glove extends Equipment{

    /**
     * Aktiválja a BlockAndReturn hatást a virológuson
     */
    public void getEffect(){

        Logger.enter(this, "getEffect", null);

        wearer.setBlock(new BlockAndReturn());

        Logger.exit(this, "getEffect", null);

    }

    /**
     *  Deaktiválja a BlockAndReturn hatást a virológuson, visszaállítja a NoBlock hatást
     */
    public void loseEffect(){

        Logger.enter(this, "loseEffect", null);

        wearer.setBlock(new NoBlock());

        Logger.exit(this, "loseEffect", null);

    }
}