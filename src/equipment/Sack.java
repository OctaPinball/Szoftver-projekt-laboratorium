package equipment;

import fillmaterial.*;

public class Sack extends Equipment{

    public void getEffect(){
        wearer.setFillMaterial(new IncreasedMatter());
    }

    public void loseEffect(){
        wearer.setFillMaterial(new NormalMatter());
    }
}
