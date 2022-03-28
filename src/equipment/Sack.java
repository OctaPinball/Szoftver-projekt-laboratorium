package equipment;

import block.PartialBlock;
import fillmaterial.*;
import miscellaneous.Logger;

public class Sack extends Equipment{

    public void getEffect(){

        Logger.enter(this, "getEffect", null);

        wearer.setFillMaterial(new IncreasedMatter());

        Logger.exit(this, "getEffect", null);

    }

    public void loseEffect(){

        Logger.enter(this, "loseEffect", null);

        wearer.setFillMaterial(new NormalMatter());

        Logger.exit(this, "loseEffect", null);

    }
}
