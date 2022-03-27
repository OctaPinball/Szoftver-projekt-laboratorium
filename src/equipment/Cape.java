package equipment;

import block.*;
import miscellaneous.Logger;

public class Cape extends Equipment{

    public void getEffect(){

        Logger.enter(this, "getEffect", null);

        wearer.setBlock(new PartialBlock());

        Logger.exit(this, "getEffect", null);

    }

    public void loseEffect(){

        Logger.enter(this, "loseEffect", null);

        wearer.setBlock(new NoBlock());

        Logger.exit(this, "loseEffect", null);

    }
}
