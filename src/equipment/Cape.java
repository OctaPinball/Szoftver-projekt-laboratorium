package equipment;

import block.*;
import miscellaneous.Logger;

public class Cape extends Equipment{

    /**
     * Aktiválja a PartialBlock hatást a virológuson
     */
    public void getEffect(){

        Logger.enter(this, "getEffect", null);

        wearer.setBlock(new PartialBlock());

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
