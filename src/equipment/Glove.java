package equipment;

import block.*;

public class Glove extends Equipment{

    public void getEffect(){
        wearer.setBlock(new BlockAndReturn());
    }

    public void loseEffect(){
        wearer.setBlock(new NoBlock());
    }
}
