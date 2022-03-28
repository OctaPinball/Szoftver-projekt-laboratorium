package equipment;

import fillmaterial.*;

public class Sack extends Equipment{

    /**
     * Aktiválja a IncreasedMatter hatást a virológuson
     */
    public void getEffect(){
        wearer.setFillMaterial(new IncreasedMatter());
    }

    /**
     *  Deaktiválja a IncreasedMatter hatást a virológuson, visszaállítja a NormalMatter hatást
     */
    public void loseEffect(){
        wearer.setFillMaterial(new NormalMatter());
    }
}
