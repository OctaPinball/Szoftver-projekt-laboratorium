package equipment;

import block.*;

public class Cape extends Equipment{

    public void getEffect(){
        wearer.setBlock(new PartialBlock());
    }

    public void loseEffect(){
        wearer.setBlock(new NoBlock());
    }
}
