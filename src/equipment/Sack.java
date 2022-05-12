package equipment;

import java.awt.Image;

import javax.swing.ImageIcon;

import block.PartialBlock;
import fillmaterial.*;
import miscellaneous.Control;
import miscellaneous.Logger;

/**
 * Egy olyan felszerelést reprezentál a programban, amelyet ha felvesz egy játékos,
 * akkor megkapja a IncreasedMatter effektust, amely megnöveli a virológus maximális anyag kapacitását.
 */
public class Sack extends Equipment{

	Image sack = new ImageIcon("res/Sack.png").getImage();
	
    /**
     * Aktiválja a IncreasedMatter hatást a virológuson
     */
    public void getEffect(){

        Logger.enter(this, "getEffect", null);

        IncreasedMatter im = new IncreasedMatter();
        
        if(im.getPriority() > wearer.getFillMaterial().getPriority())
			wearer.setFillMaterial(im);
        

        Logger.exit(this, "getEffect", null);

    }

    /**
     *  Deaktiválja a IncreasedMatter hatást a virológuson, visszaállítja a NormalMatter hatást
     */
    public void loseEffect(){

        Logger.enter(this, "loseEffect", null);

        wearer.setFillMaterial(new NormalMatter());

        Logger.exit(this, "loseEffect", null);

    }
    
    public String toString() {
		return "sack\t\t" + Control.getName(this);
	}
}
